/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.http;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Request extends HObject<Request> {

    private final Verb verb;
    private final Path path;

    private Request(Verb verb, String path) {
        this.verb = verb;
        this.path = Path.instance(path);
    }

    public static Request instance(Verb verb, String path) {
        return new Request(verb, path);
    }

    public final Verb verb() {
        return verb;
    }

    public final Path path() {
        return path;
    }

}
