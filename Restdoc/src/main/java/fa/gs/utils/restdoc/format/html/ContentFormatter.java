/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.utils.restdoc.format.Formatter;
import fa.gs.utils.restdoc.http.Content;
import j2html.TagCreator;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
class ContentFormatter implements Formatter<Content> {

    public static final ContentFormatter instance = new ContentFormatter();

    @Override
    public void format(Content content, Writer writer, Object... args) throws IOException {
        if (content.hasDescription()) {
            TextFormatter.instance.format(content.description(), writer);
        }

        writer.write("<ul>");
        ul(writer, "Mandatorio", RequireableFormatter.format(content));
        ul(writer, "Media Type", content.mediaType().full());
        ul(writer, "Tipo de Dato", content.containedType().nameOrAlias());
        writer.write("</ul>");

        WellFormatter.startBody(writer, "Modelo");
        ModelableFormatter.instance.format(content.containedType(), writer, 0);
        WellFormatter.endBody(writer);

        if (content.hasExample()) {
            WellFormatter.startBody(writer, "Ejemplo");
            ExampleFormatter.instance.format(content.example(), writer);
            WellFormatter.endBody(writer);
        }

    }

    private void ul(Writer writer, String label, String text) throws IOException {
        if (!label.endsWith(":")) {
            label = label + ":";
        }

        writer.write("<li>");
        TagCreator.b(label).render(writer);
        writer.write("&nbsp;");
        writer.write(text);
        writer.write("</li>");
    }

    private void navitem(String text, String id, Writer writer) throws IOException {
        writer.write("<li class=\"nav-item\">");
        writer.write(String.format("<a class=\"nav-link active\" id=\"%s-tab\" data-toggle=\"pill\" href=\"#%s\" role=\"tab\" aria-controls=\"%s\">%s</a>", id, id, id, text));
        writer.write("</li>");
    }

}
