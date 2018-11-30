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

/**
 *
 * @author Fabio A. González Sosa
 */
class TitleFormatter implements Formatter<String> {

    public static final TitleFormatter instance = new TitleFormatter();

    @Override
    public void format(String text, Writer writer, Object... args) throws IOException {
        // Titulo general.
        if (text != null && !text.isEmpty()) {
            TagCreator.h3(text).render(writer);
            DividerFormatter.instance.format(20, writer);
        }
    }

}
