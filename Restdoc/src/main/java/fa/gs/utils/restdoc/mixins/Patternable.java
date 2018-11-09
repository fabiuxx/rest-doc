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
public interface Patternable<T extends Patternable<T>> extends Attributable<T> {

    default public String pattern() {
        return get("pattern");
    }

    default public T pattern(String pattern) {
        set("pattern", pattern);
        return (T) this;
    }

}
