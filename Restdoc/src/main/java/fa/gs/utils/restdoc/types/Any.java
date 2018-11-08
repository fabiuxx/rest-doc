/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types;

import fa.gs.utils.restdoc.mixins.AttributableImpl;
import fa.gs.utils.restdoc.text.EmptyText;
import fa.gs.utils.restdoc.text.Text;
import java.util.Collections;
import java.util.Map;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Any<T extends Any<T>> extends AttributableImpl<T> implements Type<T> {

    public Any() {
        this("Any");
    }

    protected Any(String name) {
        this(name, name, EmptyText.instance(), Collections.EMPTY_MAP);
    }

    protected Any(String name, String alias, Text description, Map<String, Object> attributes) {
        name(name);
        alias(alias);
        description(description);
        set(attributes);
    }

}
