/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.text;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Fabio A. González Sosa
 */
public class TextLine implements Text {

    private final String text;

    protected TextLine(String text) {
        this.text = text;
    }

    public static TextLine instance(String text) {
        return new TextLine(text);
    }

    @Override
    public Collection<String> text() {
        Collection<String> parts = new LinkedList<>();
        parts.add(text);
        return parts;
    }

}
