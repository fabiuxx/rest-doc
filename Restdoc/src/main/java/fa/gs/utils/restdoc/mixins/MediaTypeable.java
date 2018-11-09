/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.mixins;

import fa.gs.utils.restdoc.http.MediaType;

/**
 *
 * @author Fabio A. González Sosa
 */
public interface MediaTypeable<T extends MediaTypeable<T>> extends Attributable<T> {

    default public MediaType mediaType() {
        return get("mediaType");
    }

    default public T mediaType(String type, String subtype) {
        MediaType mtype = MediaType.instance(type, subtype);
        return mediaType(mtype);
    }

    default public T mediaType(MediaType mediaType) {
        set("mediaType", mediaType);
        return (T) this;
    }

}
