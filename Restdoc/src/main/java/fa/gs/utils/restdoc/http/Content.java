/*
 * To change this license header, choose License Contents in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa.gs.utils.restdoc.http;

import fa.gs.utils.restdoc.mixins.AttributableImpl;
import fa.gs.utils.restdoc.mixins.Descriptable;
import fa.gs.utils.restdoc.mixins.MediaTypeable;
import fa.gs.utils.restdoc.mixins.Requireable;
import fa.gs.utils.restdoc.mixins.TypeContaineable;
import fa.gs.utils.restdoc.mixins.Valuable;
import fa.gs.utils.restdoc.text.Text;
import fa.gs.utils.restdoc.types.Types;

/**
 *
 * @author Fabio A. González Sosa
 */
public class Content<T extends Content<T>> extends AttributableImpl<T> implements Descriptable<T>, Requireable<T>, Valuable<Text, T>, MediaTypeable<T>, TypeContaineable<T> {

    private Content() {
        description(Text.instance());
        containedType(Types.String());
        mediaType(MediaType.TEXT_PLAIN);
        required(Boolean.FALSE);
        value(Text.instance());
    }

    public static Content instance() {
        return new Content();
    }

}
