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
public interface Requireable<T extends Requireable<T>> extends Attributable<T> {

    default public boolean required() {
        return get("required");
    }

    default public T required(boolean required) {
        set("required", required);
        return (T) this;
    }

}
