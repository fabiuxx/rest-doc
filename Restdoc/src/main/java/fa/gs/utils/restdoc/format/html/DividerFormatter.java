/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.utils.restdoc.format.Formatter;
import j2html.TagCreator;
import j2html.tags.ContainerTag;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
class DividerFormatter implements Formatter<Integer> {

    public static final int SPACE_TINY = 5;
    public static final int SPACE_SMALL = 10;
    public static final int SPACE_NORMAL = 20;
    public static final int SPACE_MEDIUM = 50;
    public static final int SPACE_LARGE = 80;

    public static final DividerFormatter instance = new DividerFormatter();

    @Override
    public void format(Integer width, Writer writer, Object... args) throws IOException {
        ContainerTag div = TagCreator.div().withStyle(String.format("height: %dpx !important;", width));
        div.render(writer);
    }

    public static void tiny(Writer writer) throws IOException {
        instance.format(SPACE_TINY, writer);
    }

    public static void small(Writer writer) throws IOException {
        instance.format(SPACE_SMALL, writer);
    }

    public static void normal(Writer writer) throws IOException {
        instance.format(SPACE_NORMAL, writer);
    }

    public static void medium(Writer writer) throws IOException {
        instance.format(SPACE_MEDIUM, writer);
    }

    public static void large(Writer writer) throws IOException {
        instance.format(SPACE_LARGE, writer);
    }

}
