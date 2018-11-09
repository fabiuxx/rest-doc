/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types.scalar.numbers;

import fa.gs.utils.restdoc.types.scalar.TNumber;

/**
 *
 * @author Fabio A. González Sosa
 */
public class TLong extends TNumber {

    public TLong() {
        this(true);
    }

    public TLong(boolean signed) {
        super("Int64", 64, signed);
    }

}
