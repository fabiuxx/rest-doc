/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.text;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Fabio A. González Sosa
 */
public class TextLines implements Text {

    private final Collection<String> lines;

    protected TextLines() {
        this.lines = new LinkedList<>();
    }

    public static TextLines instance(String... lines) {
        TextLines text = new TextLines();
        text.add(lines);
        return text;
    }

    public final TextLines add(String... lines) {
        return add(Arrays.asList(lines));
    }

    public final TextLines add(Text text) {
        return add(text.text());
    }

    public final TextLines add(Collection<String> lines) {
        this.lines.addAll(lines);
        return this;
    }

    @Override
    public Collection<String> text() {
        return lines;
    }

}
