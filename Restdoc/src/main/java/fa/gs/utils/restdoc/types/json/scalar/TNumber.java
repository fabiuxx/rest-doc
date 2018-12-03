/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types.json.scalar;

import fa.gs.utils.restdoc.mixins.Sizeable;
import fa.gs.utils.restdoc.types.json.Any;
import java.math.BigInteger;

/**
 *
 * @author Fabio A. González Sosa
 */
public class TNumber extends Any<TNumber> implements Sizeable<TNumber> {

    protected TNumber(String alias, int nbits, boolean signed) {
        super(alias);
        alias("Number");
        minSize(TNumber.size_min(nbits, signed));
        maxSize(TNumber.size_max(nbits, signed));
    }

    protected TNumber(String alias, String minSize, String maxSize) {
        super(alias);
        alias("Number");
        minSize(minSize);
        maxSize(maxSize);
    }

    private static BigInteger size_min(int nbits, boolean signed) {
        if (signed) {
            BigInteger a = BigInteger.valueOf(-1);
            BigInteger b = BigInteger.valueOf(2).pow(nbits - 1);
            return a.multiply(b);
        } else {
            return BigInteger.ZERO;
        }
    }

    private static BigInteger size_max(int nbits, boolean signed) {
        if (signed) {
            BigInteger a = BigInteger.valueOf(-1);
            BigInteger b = BigInteger.valueOf(2).pow(nbits - 1);
            return a.add(b);
        } else {
            return BigInteger.valueOf(2).pow(nbits);
        }
    }

}
