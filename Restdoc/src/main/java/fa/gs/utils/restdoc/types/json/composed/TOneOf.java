/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types.json.composed;

import fa.gs.utils.restdoc.mixins.TypeContaineable;
import fa.gs.utils.restdoc.types.Type;
import fa.gs.utils.restdoc.types.json.Any;
import fa.gs.utils.restdoc.types.json.Literal;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Fabio A. González Sosa
 */
public class TOneOf<T extends Type> extends Any<TOneOf<T>> implements TypeContaineable<TOneOf<T>> {

    private final Collection<Literal<T>> elements;

    public TOneOf(T type) {
        super("OneOf");
        containedType(type);
        this.elements = new LinkedList<>();
    }

    public static <P extends Type> TOneOf<P> of(P type) {
        return new TOneOf<>(type);
    }

    public TOneOf<T> element(Literal<T> literal) {
        elements.add(literal);
        return this;
    }

    public Collection<Literal<T>> elements() {
        return elements;
    }
}
