/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.http;

import fa.gs.utils.restdoc.mixins.AttributableImpl;
import fa.gs.utils.restdoc.mixins.Descriptable;
import fa.gs.utils.restdoc.mixins.Nameable;
import fa.gs.utils.restdoc.text.Text;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Verb extends AttributableImpl<Verb> implements Nameable<Verb>, Descriptable<Verb> {

    public static final Verb GET = Verb.instance("GET");
    public static final Verb POST = Verb.instance("POST");
    public static final Verb PUT = Verb.instance("PUT");
    public static final Verb DELETE = Verb.instance("DELETE");
    public static final Verb PATCH = Verb.instance("PATCH");
    public static final Verb OPTION = Verb.instance("OPTION");

    private Verb(String name) {
        name(name);
        alias(name);
        description(Text.instance());
    }

    public static Verb instance(String name) {
        return new Verb(name);
    }

}
