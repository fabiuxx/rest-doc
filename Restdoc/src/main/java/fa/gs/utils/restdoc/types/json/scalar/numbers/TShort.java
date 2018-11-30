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
public class TShort extends TNumber {

    public TShort() {
        this(true);
    }

    public TShort(boolean signed) {
        super("Int16", 16, signed);
    }

}
