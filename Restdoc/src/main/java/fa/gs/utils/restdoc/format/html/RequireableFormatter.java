/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.utils.restdoc.format.Formatter;
import fa.gs.utils.restdoc.mixins.Requireable;
import j2html.TagCreator;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
class RequireableFormatter implements Formatter<Requireable> {

    public static final RequireableFormatter instance = new RequireableFormatter();

    @Override
    public void format(Requireable object, Writer writer, Object... args) throws IOException {
        String txt = RequireableFormatter.format(object);
        TagCreator.rawHtml(txt).render(writer);
    }

    public static String format(Requireable object) {
        String txt = object.required() ? "Sí" : "No";
        return txt;
    }

}
