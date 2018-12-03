/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
class WellFormatter {

    public static void startBody(Writer writer, String header) throws IOException {
        writer.write("<div class=\"card bg-light\">");
        writer.write("<div class=\"card-header\">");
        writer.write(header);
        writer.write("</div>");
        writer.write("<div class=\"card-body\">");
    }

    public static void endBody(Writer writer) throws IOException {
        writer.write("</div>");
        writer.write("</div>");
        DividerFormatter.normal(writer);
    }

}
