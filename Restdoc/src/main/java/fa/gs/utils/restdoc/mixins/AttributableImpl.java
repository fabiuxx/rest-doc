/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.mixins;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fabio A. González Sosa
 */
public class AttributableImpl<T extends AttributableImpl<T>> implements Attributable<T> {

    protected final Map<String, Object> attributes;

    public AttributableImpl() {
        this.attributes = new HashMap<>();
    }

    @Override
    public boolean has(String name) {
        return attributes.containsKey(name);
    }

    @Override
    public T set(String name, Object value) {
        attributes.put(name, value);
        return (T) this;
    }

    @Override
    public <T> T get(String name, T fallback) {
        Object obj = attributes.getOrDefault(name, fallback);
        return (T) obj;
    }

}
