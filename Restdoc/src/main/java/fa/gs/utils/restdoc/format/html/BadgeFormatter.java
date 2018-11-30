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
class BadgeFormatter implements Formatter<String> {

    public static final BadgeFormatter instance = new BadgeFormatter();

    @Override
    public void format(String text, Writer writer, Object... args) throws IOException {
        ContainerTag badge = TagCreator.span(text);
        badge.withClasses("badge", "badge-primary");
        badge.render(writer);
    }

}
