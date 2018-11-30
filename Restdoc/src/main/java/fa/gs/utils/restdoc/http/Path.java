/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.http;

import fa.gs.utils.restdoc.mixins.AttributableImpl;
import fa.gs.utils.restdoc.mixins.Valuable;
import java.util.Collection;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Path extends AttributableImpl<Path> implements Valuable<String, Path> {

    private final HCollection<Param> pathParams;
    private final HCollection<Param> queryParams;

    private Path(String path) {
        value(path);
        pathParams = new HCollection<>();
        queryParams = new HCollection<>();
    }

    public static Path instance(String path) {
        return new Path(path);
    }

    public final Path pathParam(Param param) {
        this.pathParams.add(param);
        return this;
    }

    public final Collection<Param> pathParams() {
        return pathParams.elements();
    }

    public final Path queryParam(Param param) {
        this.queryParams.add(param);
        return this;
    }

    public final Collection<Param> queryParams() {
        return queryParams.elements();
    }

    public final boolean hasPathParams() {
        return pathParams != null && !pathParams.isEmpty();
    }

    public final boolean hasQueryParams() {
        return queryParams != null && !queryParams.isEmpty();
    }

}
