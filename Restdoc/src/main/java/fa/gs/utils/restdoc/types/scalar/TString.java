/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types.scalar;

import fa.gs.utils.restdoc.mixins.Patternable;
import fa.gs.utils.restdoc.types.Any;

/**
 *
 * @author Fabio A. González Sosa
 */
public final class TString extends Any<TString> implements Patternable<TString> {

    public TString() {
        super("String");
        pattern("*");
    }

}
