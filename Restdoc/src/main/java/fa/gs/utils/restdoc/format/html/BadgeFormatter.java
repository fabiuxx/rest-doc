/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.misc.Args;
import fa.gs.utils.restdoc.format.Formatter;
import j2html.TagCreator;
import j2html.tags.ContainerTag;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
class BadgeFormatter implements Formatter<String> {

    public static final BadgeFormatter instance = new BadgeFormatter();

    @Override
    public void format(String text, Writer writer, Object... args) throws IOException {
        String cssClass = Args.argv(args, 0, "");
        format(text, writer, cssClass);
    }

    private void format(String text, Writer writer, String cssClass) throws IOException {
        ContainerTag badge = TagCreator.span(text);
        badge.withClasses("badge", cssClass);
        badge.render(writer);
    }

    public static void primary(String text, Writer writer) throws IOException {
        instance.format(text, writer, "badge-primary");
    }

    public static void secondary(String text, Writer writer) throws IOException {
        instance.format(text, writer, "badge-secondary");
    }

    public static void success(String text, Writer writer) throws IOException {
        instance.format(text, writer, "badge-success");
    }

    public static void danger(String text, Writer writer) throws IOException {
        instance.format(text, writer, "badge-danger");
    }

    public static void warning(String text, Writer writer) throws IOException {
        instance.format(text, writer, "badge-warning");
    }

    public static void info(String text, Writer writer) throws IOException {
        instance.format(text, writer, "badge-info");
    }

}
