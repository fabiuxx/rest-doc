/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Null extends Literal<Null> {

    public Null() {
        super(null, "null", false);
        name("Null");
        alias("Nil");
        containedType(Null.this);
    }

}
