/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.mixins;

import fa.gs.utils.restdoc.text.Example;

/**
 *
 * @author Fabio A. González Sosa
 */
public interface Exemplifiable<T extends Exemplifiable<T>> extends Attributable<T> {

    default public Example example() {
        return get("example");
    }

    default public T quoted(Example example) {
        set("example", example);
        return (T) this;
    }

}
