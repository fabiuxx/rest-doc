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

        RequestFormatter.instance.format(operation.request(), writer);

        if (!operation.responses().isEmpty()) {

        }
        writer.write(":v");

    }

}
