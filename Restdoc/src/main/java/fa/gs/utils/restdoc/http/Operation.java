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
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Operation extends AttributableImpl<Operation> implements Nameable<Operation>, Descriptable<Operation> {

    private Request request;
    private final Collection<Response> responses;

    private Operation(String title) {
        name(title);
        alias(title);
        description(Text.instance());
        request = null;
        responses = new LinkedList<>();
    }

    public static Operation instance(String title) {
        return new Operation(title);
    }

    public Operation request(Request request) {
        this.request = request;
        return this;
    }

    public Request request() {
        return request;
    }

    public Operation response(Response response) {
        this.responses.add(response);
        return this;
    }

    public Collection<Response> responses() {
        return responses;
    }

}
