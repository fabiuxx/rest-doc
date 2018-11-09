/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.text;

import fa.gs.utils.restdoc.mixins.AttributableImpl;
import fa.gs.utils.restdoc.mixins.Descriptable;
import fa.gs.utils.restdoc.mixins.Valuable;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Example extends AttributableImpl<Example> implements Descriptable<Example>, Valuable<Text, Example> {

    private Example() {
        description(Text.instance());
        value(Text.instance());
    }

    public static Example instance() {
        return new Example();
    }

}
