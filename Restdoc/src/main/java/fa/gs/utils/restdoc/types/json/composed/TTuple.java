/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types.json.composed;

import fa.gs.utils.restdoc.mixins.Sizeable;
import fa.gs.utils.restdoc.types.Any;
import fa.gs.utils.restdoc.types.Type;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Fabio A. González Sosa
 */
public class TTuple extends Any<TTuple> implements Sizeable<TTuple> {

    private final Collection<Type> elements;

    public TTuple() {
        super("Tuple");
        minSize("0");
        maxSize("inf");
        this.elements = new LinkedList<>();
    }

    public TTuple element(Type type) {
        elements.add(type);
        return this;
    }

    public Collection<Type> elements() {
        return elements;
    }

}
