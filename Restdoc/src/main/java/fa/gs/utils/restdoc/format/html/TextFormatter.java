/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.utils.restdoc.format.Formatter;
import fa.gs.utils.restdoc.text.Text;
import j2html.TagCreator;
import j2html.tags.ContainerTag;
import j2html.tags.UnescapedText;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
class TextFormatter implements Formatter<Text> {

    public static final String ND = "N/D";

    public static final TextFormatter instance = new TextFormatter();

    @Override
    public void format(Text texts, Writer writer, Object... args) throws IOException {
        if (texts != null && !texts.isEmpty()) {
            ContainerTag div = TagCreator.div();
            for (String text : texts.lines()) {
                UnescapedText html = TagCreator.rawHtml(text);
                ContainerTag p = TagCreator.p(html);
                div.with(p);
            }
            div.render(writer);
        }
    }

}
