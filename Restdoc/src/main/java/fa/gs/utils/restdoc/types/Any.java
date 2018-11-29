/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types;

import fa.gs.utils.restdoc.mixins.AttributableImpl;
import fa.gs.utils.restdoc.mixins.Exemplifiable;
import fa.gs.utils.restdoc.text.Text;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Any<T extends Any<T>> extends AttributableImpl<T> implements Type<T>, Exemplifiable<T> {

    protected Any(String name) {
        name(name);
        alias(name);
        description(Text.instance());
        example();
    }

}
