/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types.composed;

import fa.gs.utils.restdoc.mixins.Sizeable;
import fa.gs.utils.restdoc.mixins.TypeContaineable;
import fa.gs.utils.restdoc.types.Any;
import fa.gs.utils.restdoc.types.Type;

/**
 *
 * @author Fabio A. González Sosa
 */
public class TArray<T extends Type> extends Any<TArray<T>> implements Sizeable<TArray<T>>, TypeContaineable<TArray<T>> {

    public TArray(T type) {
        super("Array");
        containedType(type);
        minSize("0");
        maxSize("inf");
    }

    public static <P extends Type> TArray<P> of(P type) {
        return new TArray(type);
    }

}
