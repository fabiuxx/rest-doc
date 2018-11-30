/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.http;

import fa.gs.utils.restdoc.mixins.Nameable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fabio A. González Sosa
 */
public class HCollection<T extends Nameable<T>> {

    private final Map<String, T> elements;

    public HCollection() {
        this.elements = new HashMap<>();
    }

    public HCollection<T> add(T element) {
        this.elements.put(element.name(), element);
        return this;
    }

    public Collection<T> elements() {
        return this.elements.values();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

}
