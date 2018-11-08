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
public interface Quotable<T extends Quotable<T>> extends Attributable<T> {

    default public boolean quoted() {
        return get("quoted");
    }

    default public T quoted(boolean quoted) {
        set("quoted", quoted);
        return (T) this;
    }

}
