/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.mixins;

/**
 *
 * @author Fabio A. González Sosa
 */
public interface Valuable<T extends Valuable<T>> extends Attributable<T> {

    default public String value() {
        return get("value");
    }

    default public T value(String value) {
        set("value", value);
        return (T) this;
    }

}
