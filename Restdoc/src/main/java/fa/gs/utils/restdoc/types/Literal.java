/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types;

import fa.gs.utils.restdoc.mixins.Quotable;
import fa.gs.utils.restdoc.mixins.TypeContaineable;
import fa.gs.utils.restdoc.mixins.Valuable;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Literal<T extends Type> extends Any<Literal<T>> implements Quotable<Literal<T>>, Valuable<Literal<T>>, TypeContaineable<Literal<T>> {

    public Literal(T type, String value, boolean quoted) {
        super("Literal");
        containedType(type);
        value(value);
        quoted(quoted);
    }

    public static <P extends Type> Literal<P> of(P type, String value) {
        return Literal.of(type, value, false);
    }

    public static <P extends Type> Literal<P> of(P type, String value, boolean quoted) {
        return new Literal(type, value, quoted);
    }

}
