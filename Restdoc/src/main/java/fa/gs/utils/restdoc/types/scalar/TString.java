/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.types.scalar;

import fa.gs.utils.restdoc.types.Any;

/**
 *
 * @author Fabio A. González Sosa
 */
public final class TString extends Any<TString> {

    public TString() {
        super("String");
        minSize(0);
        maxSize(64 * 1024);
        pattern("*");
    }

    public Integer minSize() {
        return get("minSize");
    }

    public TString minSize(Integer minSize) {
        set("minSize", minSize);
        return this;
    }

    public Integer maxSize() {
        return get("maxSize");
    }

    public TString maxSize(Integer maxSize) {
        set("maxSize", maxSize);
        return this;
    }

    public String pattern() {
        return get("pattern");
    }

    public TString pattern(String pattern) {
        set("pattern", pattern);
        return this;
    }

}
