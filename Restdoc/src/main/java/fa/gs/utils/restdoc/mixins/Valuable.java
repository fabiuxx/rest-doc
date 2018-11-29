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
public interface Valuable<V, T extends Valuable<V, T>> extends Attributable<T> {

    default public V value() {
        return get("value");
    }

    default public T value(V value) {
        set("value", value);
        return (T) this;
    }

    default public boolean hasValue() {
        return has("value") && get("value") != null;
    }

}
