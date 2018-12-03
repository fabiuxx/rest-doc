/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.utils.restdoc.format.Formatter;
import fa.gs.utils.restdoc.text.Example;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
class ExampleFormatter implements Formatter<Example> {

    public static final ExampleFormatter instance = new ExampleFormatter();

    @Override
    public void format(Example object, Writer writer, Object... args) throws IOException {
        if (object.hasDescription()) {
            TextFormatter.instance.format(object.description(), writer);
        }

        if (object.hasValue()) {
            writer.write("<pre>");
            TextFormatter.instance.format(object.value(), writer, args);
            writer.write("</pre>");
        }
    }

}
