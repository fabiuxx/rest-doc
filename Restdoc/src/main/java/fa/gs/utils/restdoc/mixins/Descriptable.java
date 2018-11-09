/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.mixins;

import fa.gs.utils.restdoc.text.Text;

/**
 *
 * @author Fabio A. González Sosa
 */
public interface Descriptable<T extends Descriptable<T>> extends Attributable<T> {

    default public Text description() {
        return get("description");
    }

    default public T description(Text description) {
        set("description", description);
        return (T) this;
    }

    default public T description(String... lines) {
        Text text = Text.instance(lines);
        return description(text);
    }

}
