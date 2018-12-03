/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.utils.restdoc.http.Header;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
class HeadersFormatter extends TableFormatter<Header> {

    public static final HeadersFormatter instance = new HeadersFormatter();

    @Override
    public int getColumnsCount() {
        return 4;
    }

    @Override
    public String[] getHeaders() {
        String[] headers = {
            "Nombre",
            "Mandatorio",
            "Tipo de Dato",
            "Descripción"
        };
        return headers;
    }

    @Override
    public void formatRow(Header header, Writer writer, Object... args) throws IOException {
        writer.write("<td>");
        NameableFormatter.instance.format(header, writer);
        writer.write("</td>");

        writer.write("<td>");
        RequireableFormatter.instance.format(header, writer);
        writer.write("</td>");

        writer.write("<td>");
        NameableFormatter.instance.format(header.containedType(), writer);
        writer.write("</td>");

        writer.write("<td>");
        TextFormatter.instance.format(header.description(), writer);
        if (header.hasExample()) {
            ExampleFormatter.instance.format(header.example(), writer);
        }
        writer.write("</td>");
    }

}
