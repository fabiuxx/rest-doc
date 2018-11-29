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
public class Text {

    private final Collection<String> lines;

    private Text() {
        this.lines = new LinkedList<>();
    }

    public static Text instance() {
        return new Text();
    }

    public static Text instance(String... lines) {
        Text text = new Text();
        text.lines.addAll(Arrays.asList(lines));
        return text;
    }

    public Collection<String> text() {
        return lines;
    }

    public boolean isEmpty() {
        return lines.isEmpty();
    }

}
