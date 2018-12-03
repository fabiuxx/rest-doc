/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.utils.restdoc.format.Formatter;
import fa.gs.utils.restdoc.http.Request;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
class PathFormatter implements Formatter<Request> {

    public static final PathFormatter instance = new PathFormatter();

    @Override
    public void format(Request object, Writer writer, Object... args) throws IOException {
        writer.write("<h4>");
        BadgeFormatter.primary(object.verb().name(), writer);
        writer.write("&nbsp;&nbsp;");
        writer.write(object.path().value());
        writer.write("</h4>");
    }

}
