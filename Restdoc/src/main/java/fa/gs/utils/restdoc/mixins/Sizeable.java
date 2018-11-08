/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.mixins;

import java.math.BigInteger;

/**
 *
 * @author Fabio A. González Sosa
 */
public interface Sizeable<T extends Sizeable<T>> extends Attributable<T> {

    default public String minSize() {
        return get("minSize");
    }

    default public T minSize(BigInteger minSize) {
        return minSize(minSize.toString());
    }

    default public T minSize(String minSize) {
        set("minSize", minSize);
        return (T) this;
    }

    default public String maxSize() {
        return get("maxSize");
    }

    default public T maxSize(BigInteger maxSize) {
        return maxSize(maxSize.toString());
    }

    default public T maxSize(String maxSize) {
        set("maxSize", maxSize);
        return (T) this;
    }

}
