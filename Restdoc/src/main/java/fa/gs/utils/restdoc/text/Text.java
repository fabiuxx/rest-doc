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
        text.lines(lines);
        return text;
    }

    public Text line(String line) {
        this.lines.add(line);
        return this;
    }

    public Text lines(String... lines) {
        this.lines.addAll(Arrays.asList(lines));
        return this;
    }

    public Collection<String> lines() {
        return lines;
    }

    public boolean isEmpty() {
        return lines.isEmpty();
    }

}
