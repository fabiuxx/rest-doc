/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.main;

import fa.gs.utils.restdoc.format.html.OperationFormatter;
import fa.gs.utils.restdoc.http.Content;
import fa.gs.utils.restdoc.http.Header;
import fa.gs.utils.restdoc.http.MediaType;
import fa.gs.utils.restdoc.http.Operation;
import fa.gs.utils.restdoc.http.Param;
import fa.gs.utils.restdoc.http.Request;
import fa.gs.utils.restdoc.http.Response;
import fa.gs.utils.restdoc.http.Status;
import fa.gs.utils.restdoc.http.Verb;
import fa.gs.utils.restdoc.mixins.Sizeable;
import fa.gs.utils.restdoc.mixins.TypeContaineable;
import fa.gs.utils.restdoc.text.Example;
import fa.gs.utils.restdoc.text.Text;
import fa.gs.utils.restdoc.types.Type;
import fa.gs.utils.restdoc.types.json.Literal;
import fa.gs.utils.restdoc.types.json.Null;
import fa.gs.utils.restdoc.types.json.Types;
import fa.gs.utils.restdoc.types.json.composed.TArray;
import fa.gs.utils.restdoc.types.json.composed.TObject;
import fa.gs.utils.restdoc.types.json.composed.TOneOf;
import fa.gs.utils.restdoc.types.json.scalar.TBoolean;
import fa.gs.utils.restdoc.types.json.scalar.TString;
import fa.gs.utils.restdoc.types.json.scalar.numbers.TByte;
import fa.gs.utils.restdoc.types.json.scalar.numbers.TDouble;
import fa.gs.utils.restdoc.types.json.scalar.numbers.TFloat;
import fa.gs.utils.restdoc.types.json.scalar.numbers.TInteger;
import fa.gs.utils.restdoc.types.json.scalar.numbers.TLong;
import fa.gs.utils.restdoc.types.json.scalar.numbers.TShort;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Main {

    private static class Punto extends TObject {

        public Punto() {
            name("Punto");
            TObject x = new TObject().property("x", new TInteger()).property("a", new TBoolean());
            TObject y = new TObject().property("y", new TInteger()).property("b", new TBoolean());
            property("x", x).property("y", y);
        }

    }

    private static String linearize(Type type) {
        if (type instanceof TObject) {
            TObject obj = (TObject) type;
            StringBuilder builder = new StringBuilder();
            builder.append("{");
            Iterator<TObject.Property> it = obj.properties().iterator();
            while (it.hasNext()) {
                TObject.Property property = it.next();
                builder.append(String.format("%s: %s", property.name(), linearize(property.containedType())));
                if (it.hasNext()) {
                    builder.append(", ");
                }
            }
            builder.append("}");
            return builder.toString();
        } else {
            return String.format("|%s|", type.name());
        }
    }

    private static void test_types(String... args) throws Exception {
        Type[] types = {
            Types.Any(),
            Null.instance(),
            new TString(),
            Literal.of(new TString(), "null"),
            new TBoolean(),
            TBoolean.TRUE,
            TBoolean.FALSE,
            new TObject(),
            new TByte(),
            new TByte(false),
            new TShort(),
            new TShort(false),
            new TInteger(),
            new TInteger(false),
            new TLong(),
            new TLong(false),
            new TFloat(),
            new TDouble(),
            TArray.of(Types.Any()),
            new TOneOf<>(new TInteger()),
            new Punto()
        };

        for (Type type : types) {
            System.out.printf("name=%s alias=%s toString=%s", type.name(), type.alias(), linearize(type));

            if (type instanceof Sizeable) {
                Sizeable ztype = (Sizeable) type;
                System.out.printf(" min=%s max=%s", ztype.minSize(), ztype.maxSize());
            }

            if (type instanceof TypeContaineable) {
                System.out.printf(" of=%s", ((TypeContaineable) type).containedType().name());
            }

            System.out.println();
        }
    }

    public static void test_http(String... args) throws Exception {
        Header h = Header.instance("Authorization")
                .containedType(Types.Integer())
                .example(Example.instance().description("Bearer <token>"))
                .description("El cosito.", "Donde se usa.");

        String L1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus ultricies ligula a lacus posuere, ac cursus dui lobortis. Phasellus scelerisque justo at ultricies egestas. Integer fringilla tellus id nibh tincidunt, ut efficitur dolor condimentum. Etiam nibh tellus, rutrum non nunc at, ultrices fringilla ex. Nulla facilisi. Nulla facilisi. In placerat vulputate purus. Praesent accumsan turpis ac magna ultrices dapibus. Ut id tincidunt ligula, sit amet eleifend ex. Proin ultricies orci ligula, ac iaculis orci suscipit vel.";
        String L2 = "Curabitur sed tristique neque. Pellentesque aliquet facilisis congue. Maecenas interdum sagittis arcu, sed finibus elit eleifend elementum. Morbi purus nulla, maximus id vehicula eget, hendrerit nec eros. Sed imperdiet interdum sapien, non tristique orci porta ac. Ut faucibus sem vel quam tempus tempor. Cras porta nec ante eu facilisis. Nulla odio nisl, fermentum vitae urna et, tristique iaculis mi. Fusce convallis placerat molestie. Nulla accumsan libero at dolor porta, ut consectetur tellus aliquet. Aenean semper quis nisi nec posuere. Praesent dolor ligula, venenatis eget felis nec, bibendum tempor erat.";

        //System.out.printf("%s: %s (%s |%s)", h.name(), String.join(" ", h.value().text()), h.required(), h.containedType().name());
        Request req = Request.instance(Verb.POST, "/asd/{kind}/find");
        req.description("dafeq?");
        req.path().pathParam(Param.instance("{kind}").description("Este parametro.", "Se usa <b>para</b> parametrizar, xD."));
        req.path().pathParam(Param.instance("oki").name(null));
        req.path().queryParam(Param.instance("page"));
        req.path().queryParam(Param.instance("pageSize"));
        req.headers().add(h);

        Content c = Content.instance();
        c.mediaType(MediaType.APPLICATION_JSON);
        c.containedType(new Punto());
        req.content(c);

        Response res = Response.instance(Status.OK);
        res.content(c);

        Operation operation = Operation.instance("Listar Productos v1");
        Text description = Text.instance();
        description.line(L1);
        description.line(L2);
        operation.description(description);

        operation.request(req);
        operation.response(res);

        File file = new File("C:\\Users\\SepsaIT\\Desktop\\rest-doc\\out.txt");
        file.createNewFile();
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8))) {
            OperationFormatter.instance.format(operation, bw);
        }
    }

    private static void format1(Operation operation) {
        Request req = operation.request();

        System.out.println("-----------------------");
        System.out.printf("REQUEST: %s %s\n", req.verb().name(), req.path().value());
        System.out.println("-----------------------");
        for (Param param : req.path().pathParams()) {
            System.out.printf("%s (%s) \n", param.name(), param.required());
            if (!param.description().isEmpty()) {
                System.out.printf("%s \n\n", String.join("\n", param.description().lines()));
            }
        }
        System.out.println("-----------------------");
        for (Param param : req.path().queryParams()) {
            System.out.printf("%s (%s) \n", param.name(), param.required());
            if (!param.description().isEmpty()) {
                System.out.printf("%s \n\n", String.join("\n", param.description().lines()));
            }
        }

        System.out.println("-----------------------");
        System.out.printf("content (%s) %s", req.content().mediaType().full(), linearize(req.content().containedType()));
    }

    public static void main(String... args) throws Exception {

        //test_types(args);
        test_http(args);

    }

}
