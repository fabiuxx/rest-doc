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
public class TByte extends TNumber {

    public TByte() {
        this(true);
    }

    public TByte(boolean signed) {
        super("Int8", 8, signed);
    }

}
