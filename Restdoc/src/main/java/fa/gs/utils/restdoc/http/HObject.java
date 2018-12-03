/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.http;

import fa.gs.utils.restdoc.mixins.AttributableImpl;
import fa.gs.utils.restdoc.mixins.Descriptable;
import fa.gs.utils.restdoc.text.Text;
import java.util.Collection;

/**
 *
 * @author Fabio A. González Sosa
 */
class HObject<T extends HObject<T>> extends AttributableImpl<T> implements Descriptable<T> {

    protected final HCollection<Header> headers;
    protected Content content;

    protected HObject() {
        description(Text.instance());
        this.headers = new HCollection<>();
        content = null;
    }

    public HObject<T> header(Header header) {
        this.headers.add(header);
        return this;
    }

    public final Collection<Header> headers() {
        return headers.elements();
    }

    public final HObject<T> content(Content content) {
        this.content = content;
        return this;
    }

    public final Content content() {
        return content;
    }

    public boolean hasHeaders() {
        return headers != null && !headers.isEmpty();
    }

    public boolean hasContent() {
        return content != null;
    }

}
