/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.http;

import fa.gs.utils.restdoc.mixins.AttributableImpl;
import fa.gs.utils.restdoc.types.Type;

/**
 *
 * @author Fabio A. González Sosa
 */
public class MediaType extends AttributableImpl<MediaType> implements Type<MediaType> {

    public static final MediaType TEXT_PLAIN = MediaType.instance("text", "plain");
    public static final MediaType APPLICATION_JSON = MediaType.instance("application", "json");
    public static final MediaType APPLICATION_XML = MediaType.instance("application", "xml");
    public static final MediaType APPLICATION_BINARY = MediaType.instance("application", "octet-stream");

    private MediaType(String type, String subtype) {
        type(type);
        subType(subtype);
    }

    public static MediaType instance(String type, String subtype) {
        return new MediaType(type, subtype);
    }

    public final MediaType type(String type) {
        set("type", type);
        return this;
    }

    public String type() {
        return get("type");
    }

    public final MediaType subType(String subType) {
        set("subType", subType);
        return this;
    }

    public String subType() {
        return get("subType");
    }

    public String full() {
        return String.format("%s/%s", type(), subType());
    }

}
