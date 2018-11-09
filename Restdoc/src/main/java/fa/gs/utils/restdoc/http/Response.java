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
public class Response extends HObject<Response> {

    private final Status status;

    private Response(Status status) {
        this.status = status;
    }

    public static Response instance(Status status) {
        return new Response(status);
    }

    public final Status status() {
        return status;
    }

}
