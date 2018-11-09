/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.http;

import fa.gs.utils.restdoc.mixins.AttributableImpl;
import fa.gs.utils.restdoc.mixins.Descriptable;
import fa.gs.utils.restdoc.mixins.Nameable;
import fa.gs.utils.restdoc.mixins.Requireable;
import fa.gs.utils.restdoc.mixins.TypeContaineable;
import fa.gs.utils.restdoc.mixins.Valuable;
import fa.gs.utils.restdoc.text.Text;
import fa.gs.utils.restdoc.types.Types;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Param extends AttributableImpl<Param> implements Nameable<Param>, Descriptable<Param>, Valuable<Text, Param>, Requireable<Param>, TypeContaineable<Param> {

    private Param(String name) {
        name(name);
        alias(name);
        description(Text.instance());
        required(Boolean.TRUE);
        value(Text.instance());
        containedType(Types.String());
    }

    public static Param instance(String name) {
        return new Param(name);
    }

}
