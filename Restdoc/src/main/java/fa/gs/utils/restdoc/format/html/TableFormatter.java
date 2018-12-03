/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.utils.restdoc.format.Formatter;
import j2html.TagCreator;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author Fabio A. González Sosa
 */
abstract class TableFormatter<T> implements Formatter<Collection<T>> {

    public abstract int getColumnsCount();

    public abstract String[] getHeaders();

    public float[] getHeadersWeigths() {
        int N = getColumnsCount();
        float[] weights = new float[N];
        float weight = 100f / N;
        Arrays.fill(weights, weight);
        return weights;
    }

    public abstract void formatRow(T objet, Writer writer, Object... args) throws IOException;

    @Override
    public void format(Collection<T> objects, Writer writer, Object... args) throws IOException {
        String[] headers = getHeaders();
        float[] weights = getHeadersWeigths();

        writer.write("<table class=\"table table-bordered\">");

        // Cabecera.
        writer.write("<thead>");
        writer.write("<tr>");
        for (int i = 0; i < getColumnsCount(); i++) {
            writer.write(String.format("<th style=\"width: %.02f%% !important;\">", weights[i]));
            TagCreator.rawHtml(headers[i]).render(writer);
            writer.write("</th>");
        }
        writer.write("</tr>");
        writer.write("</thead>");

        // Cuerpo.
        writer.write("<tbody>");
        for (T object : objects) {
            writer.write("<tr>");
            formatRow(object, writer, args);
            writer.write("</tr>");
        }
        writer.write("</tbody>");

        writer.write("</table>");
    }

}
