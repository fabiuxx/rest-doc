/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.utils.restdoc.format.Formatter;
import fa.gs.utils.restdoc.http.Operation;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
public class OperationFormatter implements Formatter<Operation> {

    public static final OperationFormatter instance = new OperationFormatter();

    @Override
    public void format(Operation operation, Writer writer, Object... args) throws IOException {
        TitleFormatter.instance.format(operation.name(), writer);
        TextFormatter.instance.format(operation.description(), writer);
        DividerFormatter.large(writer);

        if (operation.request() != null) {
            TitleFormatter.instance.format("Petición", writer);
            writer.write("<h4>");
            BadgeFormatter.instance.format(operation.request().verb().name(), writer);
            writer.write("&nbsp;&nbsp;");
            writer.write(operation.request().path().value());
            writer.write("</h4>");

            if (operation.request().hasDescription()) {
                TextFormatter.instance.format(operation.request().description(), writer);
            }
        }

        DividerFormatter.large(writer);

        if (operation.request().path().hasPathParams()) {
            SubtitleFormatter.instance.format("Path Params", writer);
            ParamsFormatter.instance.format(operation.request().path().pathParams(), writer);
            DividerFormatter.normal(writer);
        }

        if (operation.request().path().hasQueryParams()) {
            SubtitleFormatter.instance.format("Query Params", writer);
            ParamsFormatter.instance.format(operation.request().path().queryParams(), writer);
            DividerFormatter.instance.normal(writer);
        }

        writer.write(":v");

    }

}
