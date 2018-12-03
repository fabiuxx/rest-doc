/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.format.html;

import fa.gs.utils.restdoc.format.Formatter;
import fa.gs.utils.restdoc.http.Request;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Fabio A. González Sosa
 */
class RequestFormatter implements Formatter<Request> {

    public static final RequestFormatter instance = new RequestFormatter();

    @Override
    public void format(Request request, Writer writer, Object... args) throws IOException {
        if (request != null) {
            TitleFormatter.instance.format("Petición", writer);
            PathFormatter.instance.format(request, writer);
            if (request.hasDescription()) {
                TextFormatter.instance.format(request.description(), writer);
            }
        }

        DividerFormatter.large(writer);

        if (request.path().hasPathParams()) {
            SubtitleFormatter.instance.format("Parámetros de Path", writer);
            ParamsFormatter.instance.format(request.path().pathParams(), writer);
            DividerFormatter.normal(writer);
        }

        if (request.path().hasQueryParams()) {
            SubtitleFormatter.instance.format("Parámetros de Query", writer);
            ParamsFormatter.instance.format(request.path().queryParams(), writer);
            DividerFormatter.normal(writer);
        }

        if (request.hasHeaders()) {
            SubtitleFormatter.instance.format("Cabeceras", writer);
            HeadersFormatter.instance.format(request.headers(), writer);
            DividerFormatter.normal(writer);
        }

        if (request.hasContent()) {
            SubtitleFormatter.instance.format("Cuerpo", writer);
            ContentFormatter.instance.format(request.content(), writer);
            DividerFormatter.normal(writer);
        }
    }

}
