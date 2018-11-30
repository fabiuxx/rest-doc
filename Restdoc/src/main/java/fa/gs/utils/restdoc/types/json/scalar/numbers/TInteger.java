/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types.json.scalar.numbers;

import fa.gs.utils.restdoc.types.json.scalar.TNumber;

/**
 *
 * @author Fabio A. González Sosa
 */
public class TInteger extends TNumber {

    public TInteger() {
        this(true);
    }

    public TInteger(boolean signed) {
        super("Int32", 32, signed);
    }

}
