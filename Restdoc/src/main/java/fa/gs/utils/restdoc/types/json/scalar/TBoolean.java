/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types.json.scalar;

import fa.gs.utils.restdoc.types.Any;
import fa.gs.utils.restdoc.types.json.Literal;

/**
 *
 * @author Fabio A. González Sosa
 */
public class TBoolean extends Any<TBoolean> {

    public static final Literal TRUE = Literal.of(new TBoolean(), "true");
    public static final Literal FALSE = Literal.of(new TBoolean(), "false");

    public TBoolean() {
        super("Boolean");
    }

}
