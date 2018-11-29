/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.mixins;

/**
 *
 * @author Fabio A. González Sosa
 */
public interface Nameable<T extends Nameable<T>> extends Attributable<T> {

    default public String name() {
        return get("name");
    }

    default public T name(String name) {
        set("name", name);
        return (T) this;
    }

    default public String alias() {
        return get("alias");
    }

    default public T alias(String alias) {
        set("alias", alias);
        return (T) this;
    }

    default public boolean hasName() {
        return has("name") && get("name") != null;
    }

    default public boolean hasAlias() {
        return has("alias") && get("alias") != null;
    }

}
