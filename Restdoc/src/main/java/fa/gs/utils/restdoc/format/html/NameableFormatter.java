/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.utils.restdoc.format.Formatter;
import fa.gs.utils.restdoc.mixins.Nameable;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
class NameableFormatter implements Formatter<Nameable> {

    public static final NameableFormatter instance = new NameableFormatter();

    @Override
    public void format(Nameable object, Writer writer, Object... args) throws IOException {
        if (object.hasName()) {
            writer.write(object.name());
            return;
        }

        if (object.hasAlias()) {
            writer.write("<i>");
            writer.write(object.alias());
            writer.write("</i>");
            return;
        }

        writer.write(TextFormatter.NN);
    }

}
