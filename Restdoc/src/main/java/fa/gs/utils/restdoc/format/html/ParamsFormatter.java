/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.utils.restdoc.http.Param;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
public class ParamsFormatter extends TableFormatter<Param> {

    public static final ParamsFormatter instance = new ParamsFormatter();

    @Override
    public int getColumnsCount() {
        return 4;
    }

    @Override
    public String[] getHeaders() {
        String[] headers = {
            "Nombre",
            "Mandatorio",
            "Tipo",
            "Descripción"
        };
        return headers;
    }

    @Override
    public void formatRow(Param param, Writer writer, Object... args) throws IOException {
        writer.write("<td>");
        NameableFormatter.instance.format(param, writer);
        writer.write("</td>");

        writer.write("<td>");
        RequireableFormatter.instance.format(param, writer);
        writer.write("</td>");

        writer.write("<td>");
        writer.write("<b>TODO</b>");
        writer.write("</td>");

        writer.write("<td>");
        TextFormatter.instance.format(param.description(), writer);

        if (param.hasExample()) {
            ExampleFormatter.instance.format(param.example(), writer);
        }

        writer.write("</td>");
    }

}
