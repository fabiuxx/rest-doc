/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.misc.Args;
import fa.gs.utils.restdoc.format.Formatter;
import fa.gs.utils.restdoc.mixins.Modelable;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
class ModelableFormatter implements Formatter<Modelable> {

    public static final ModelableFormatter instance = new ModelableFormatter();

    @Override
    public void format(Modelable object, Writer writer, Object... args) throws IOException {
        Integer ident = Args.argv(args, 0, 0);
        format(object, writer, ident);
    }

    public void format(Modelable object, Writer writer, Integer ident) throws IOException {
        writer.write("<pre>");
        StringBuilder builder = new StringBuilder();
        object.model(builder, ident);
        writer.write(builder.toString());
        writer.write("</pre>");
    }

}
