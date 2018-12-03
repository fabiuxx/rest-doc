/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types.json;

import fa.gs.utils.restdoc.mixins.AttributableImpl;
import fa.gs.utils.restdoc.mixins.Exemplifiable;
import fa.gs.utils.restdoc.mixins.Modelable;
import fa.gs.utils.restdoc.text.Text;
import fa.gs.utils.restdoc.types.Type;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Any<T extends Any<T>> extends AttributableImpl<T> implements Type<T>, Exemplifiable<T>, Modelable {

    protected Any(String name) {
        name(name);
        alias(name);
        description(Text.instance());
        example();
    }

    public static Any instance() {
        return instance("any");
    }

    public static Any instance(String name) {
        return new Any(name);
    }

    protected void ident(StringBuilder builder, int ident) {
        while (ident > 0) {
            builder.append(" ");
            ident--;
        }
    }

    @Override
    public void model(StringBuilder builder, int ident) {
        //ident(builder, ident);
        builder.append(String.format("|%s|", nameOrAlias()));
    }

}
