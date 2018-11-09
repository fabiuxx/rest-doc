/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.main;

import fa.gs.utils.restdoc.http.Content;
import fa.gs.utils.restdoc.http.Header;
import fa.gs.utils.restdoc.http.MediaType;
import fa.gs.utils.restdoc.http.Param;
import fa.gs.utils.restdoc.http.Request;
import fa.gs.utils.restdoc.http.Verb;
import fa.gs.utils.restdoc.mixins.Sizeable;
import fa.gs.utils.restdoc.mixins.TypeContaineable;
import fa.gs.utils.restdoc.text.Text;
import fa.gs.utils.restdoc.types.Literal;
import fa.gs.utils.restdoc.types.Null;
import fa.gs.utils.restdoc.types.Type;
import fa.gs.utils.restdoc.types.Types;
import fa.gs.utils.restdoc.types.composed.TArray;
import fa.gs.utils.restdoc.types.composed.TObject;
import fa.gs.utils.restdoc.types.composed.TOneOf;
import fa.gs.utils.restdoc.types.scalar.TBoolean;
import fa.gs.utils.restdoc.types.scalar.TString;
import fa.gs.utils.restdoc.types.scalar.numbers.TByte;
import fa.gs.utils.restdoc.types.scalar.numbers.TDouble;
import fa.gs.utils.restdoc.types.scalar.numbers.TFloat;
import fa.gs.utils.restdoc.types.scalar.numbers.TInteger;
import fa.gs.utils.restdoc.types.scalar.numbers.TLong;
import fa.gs.utils.restdoc.types.scalar.numbers.TShort;
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
                .value(Text.instance("Bearer <token>"))
                .description("El cosito.", "Donde se usa.");

        System.out.printf("%s: %s (%s |%s)", h.name(), String.join(" ", h.value().text()), h.required(), h.containedType().name());

        Request req = Request.instance(Verb.GET, "/asd/{kind}/find");
        req.path().pathParam(Param.instance("{kind}").description("Este parametro.", "Se usa para parametrizar, xD."));
        req.path().queryParam(Param.instance("page"));
        req.path().queryParam(Param.instance("pageSize"));

        Content c = Content.instance();
        c.mediaType(MediaType.APPLICATION_JSON);
        c.containedType(new Punto());
        req.content(c);

        System.out.println("-----------------------");
        System.out.printf("REQUEST: %s %s\n", req.verb().name(), req.path().value());
        System.out.println("-----------------------");
        for (Param param : req.path().pathParams()) {
            System.out.printf("%s (%s) \n", param.name(), param.required());
            if (!param.description().text().isEmpty()) {
                System.out.printf("%s \n\n", String.join("\n", param.description().text()));
            }
        }
        System.out.println("-----------------------");
        for (Param param : req.path().queryParams()) {
            System.out.printf("%s (%s) \n", param.name(), param.required());
            if (!param.description().text().isEmpty()) {
                System.out.printf("%s \n\n", String.join("\n", param.description().text()));
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
