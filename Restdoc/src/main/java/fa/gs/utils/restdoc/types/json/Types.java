/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types.json;

import fa.gs.utils.restdoc.types.Type;
import fa.gs.utils.restdoc.types.json.scalar.TBoolean;
import fa.gs.utils.restdoc.types.json.scalar.TString;
import fa.gs.utils.restdoc.types.json.scalar.numbers.TByte;
import fa.gs.utils.restdoc.types.json.scalar.numbers.TDouble;
import fa.gs.utils.restdoc.types.json.scalar.numbers.TFloat;
import fa.gs.utils.restdoc.types.json.scalar.numbers.TInteger;
import fa.gs.utils.restdoc.types.json.scalar.numbers.TLong;
import fa.gs.utils.restdoc.types.json.scalar.numbers.TShort;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Types {

    public static Any Any() {
        return Any.instance("Any");
    }

    public static Null Null() {
        return Null.instance();
    }

    public static <T extends Type> Literal<T> Literal(T type) {
        return Literal.of(type);
    }

    public static <T extends Type> Literal<T> Literal(T type, String value) {
        return Literal.of(type, value);
    }

    public static <T extends Type> Literal<T> Literal(T type, String value, boolean quoted) {
        return Literal.of(type, value, quoted);
    }

    public static TBoolean Boolean() {
        return new TBoolean();
    }

    public static TString String() {
        return new TString();
    }

    //<editor-fold defaultstate="collapsed" desc="Numericos">
    public static TByte Byte() {
        return new TByte();
    }

    public static TByte UByte() {
        return new TByte(false);
    }

    public static TShort Short() {
        return new TShort();
    }

    public static TShort UShort() {
        return new TShort(false);
    }

    public static TInteger Integer() {
        return new TInteger();
    }

    public static TInteger UInteger() {
        return new TInteger(false);
    }

    public static TLong Long() {
        return new TLong();
    }

    public static TLong ULong() {
        return new TLong(false);
    }

    public static TFloat Float() {
        return new TFloat();
    }

    public static TDouble Double() {
        return new TDouble();
    }
    //</editor-fold>

}
