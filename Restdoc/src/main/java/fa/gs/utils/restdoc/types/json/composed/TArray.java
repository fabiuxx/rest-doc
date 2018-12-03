/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types.json.composed;

import fa.gs.utils.restdoc.mixins.Sizeable;
import fa.gs.utils.restdoc.mixins.TypeContaineable;
import fa.gs.utils.restdoc.types.Type;
import fa.gs.utils.restdoc.types.json.Any;

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

    @Override
    public void model(StringBuilder builder, int ident) {
        builder.append(String.format("||%s||", containedType().nameOrAlias()));
    }

}
