/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.text;

/**
 *
 * @author Fabio A. González Sosa
 */
public class EmptyText extends TextLine {

    protected EmptyText() {
        super("");
    }

    public static Text instance() {
        return new EmptyText();
    }

}
