/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.mixins;

import fa.gs.utils.restdoc.types.Type;

/**
 *
 * @author Fabio A. González Sosa
 */
public interface TypeContaineable<T extends TypeContaineable<T>> extends Attributable<T> {

    default public Type<?> containedType() {
        return get("containedType");
    }

    default public T containedType(Type<?> containedType) {
        set("containedType", containedType);
        return (T) this;
    }

}
