/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types.composed;

import fa.gs.utils.restdoc.mixins.AttributableImpl;
import fa.gs.utils.restdoc.mixins.Descriptable;
import fa.gs.utils.restdoc.mixins.Nameable;
import fa.gs.utils.restdoc.mixins.Requireable;
import fa.gs.utils.restdoc.mixins.TypeContaineable;
import fa.gs.utils.restdoc.text.Text;
import fa.gs.utils.restdoc.types.Any;
import fa.gs.utils.restdoc.types.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fabio A. González Sosa
 */
public class TObject extends Any<TObject> {

    private final Map<String, Property> properties;

    public TObject() {
        super("Object");
        this.properties = new HashMap<>();
    }

    public TObject property(String name, Type type) {
        return property(name, type, Text.instance());
    }

    public TObject property(String name, Type type, Text description) {
        return property(name, type, true, description);
    }

    public TObject property(String name, Type type, boolean required, Text description) {
        Property property = new Property(name, type, required, description);
        return property(property);
    }

    public TObject property(Property property) {
        properties.put(property.name(), property);
        return this;
    }

    public Collection<Property> properties() {
        return properties.values();
    }

    public static class Property extends AttributableImpl<Property> implements Nameable<Property>, Descriptable<Property>, Requireable<Property>, TypeContaineable<Property> {

        public Property(String name, Type type, boolean required, Text description) {
            name(name);
            description(description);
            required(required);
            containedType(type);
        }

    }
}
