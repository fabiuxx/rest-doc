/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types;

import fa.gs.utils.restdoc.mixins.Descriptable;
import fa.gs.utils.restdoc.mixins.Nameable;

/**
 *
 * @author Fabio A. González Sosa
 */
public interface Type<T extends Type<T>> extends Nameable<T>, Descriptable<T> {
}
