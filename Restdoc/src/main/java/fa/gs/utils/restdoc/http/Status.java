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
public class Status extends AttributableImpl<Status> implements Nameable<Status>, Descriptable<Status> {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    public static final Status CONTINUE = Status.instance(100, "CONTINUE", "HTTP/1.1 RFC 7231, Section 6.2.1");
    public static final Status SWITCHING_PROTOCOLS = Status.instance(101, "SWITCHING_PROTOCOLS", "HTTP/1.1 RFC 7231, Section 6.2.2");
    public static final Status PROCESSING = Status.instance(102, "PROCESSING", "WebDAV RFC 2518, Section 10.1");
    public static final Status OK = Status.instance(200, "OK", "HTTP/1.1 RFC 7231, Section 6.3.1");
    public static final Status CREATED = Status.instance(201, "CREATED", "HTTP/1.1 RFC 7231, Section 6.3.2");
    public static final Status ACCEPTED = Status.instance(202, "ACCEPTED", "HTTP/1.1 RFC 7231, Section 6.3.3");
    public static final Status NON_AUTHORITATIVE_INFORMATION = Status.instance(203, "NON_AUTHORITATIVE_INFORMATION", "HTTP/1.1 RFC 7231, Section 6.3.4");
    public static final Status NO_CONTENT = Status.instance(204, "NO_CONTENT", "HTTP/1.1 RFC 7231, Section 6.3.5");
    public static final Status RESET_CONTENT = Status.instance(205, "RESET_CONTENT", "HTTP/1.1 RFC 7231, Section 6.3.6");
    public static final Status PARTIAL_CONTENT = Status.instance(206, "PARTIAL_CONTENT", "HTTP/1.1 RFC 7233, Section 4.1");
    public static final Status MULTI_STATUS = Status.instance(207, "MULTI_STATUS", "WebDAV RFC 4918, Section 11.1");
    public static final Status ALREADY_REPORTED = Status.instance(208, "ALREADY_REPORTED", "WebDAV Binding Extensions RFC 5842, Section 7.1 (Experimental)");
    public static final Status IM_USED = Status.instance(226, "IM_USED", "Delta Encoding in HTTP RFC 3229, Section 10.4.1");
    public static final Status MULTIPLE_CHOICES = Status.instance(300, "MULTIPLE_CHOICES", "HTTP/1.1 RFC 7231, Section 6.4.1");
    public static final Status MOVED_PERMANENTLY = Status.instance(301, "MOVED_PERMANENTLY", "HTTP/1.1 RFC 7231, Section 6.4.2");
    public static final Status FOUND = Status.instance(302, "FOUND", "HTTP/1.1 RFC 7231, Section 6.4.3");
    public static final Status SEE_OTHER = Status.instance(303, "SEE_OTHER", "HTTP/1.1 RFC 7231, Section 6.4.4");
    public static final Status NOT_MODIFIED = Status.instance(304, "NOT_MODIFIED", "HTTP/1.1 RFC 7232, Section 4.1");
    public static final Status USE_PROXY = Status.instance(305, "USE_PROXY", "HTTP/1.1 RFC 7231, Section 6.4.5");
    public static final Status TEMPORARY_REDIRECT = Status.instance(307, "TEMPORARY_REDIRECT", "HTTP/1.1 RFC 7231, Section 6.4.7");
    public static final Status PERMANENT_REDIRECT = Status.instance(308, "PERMANENT_REDIRECT", "Permanent Redirect RFC 7238, Section 3 (Experimental)");
    public static final Status BAD_REQUEST = Status.instance(400, "BAD_REQUEST", "HTTP/1.1 RFC 7231, Section 6.5.1");
    public static final Status UNAUTHORIZED = Status.instance(401, "UNAUTHORIZED", "HTTP/1.1 Authentication RFC 7235, Section 3.1");
    public static final Status PAYMENT_REQUIRED = Status.instance(402, "PAYMENT_REQUIRED", "HTTP/1.1 RFC 7231, Section 6.5.2");
    public static final Status FORBIDDEN = Status.instance(403, "FORBIDDEN", "HTTP/1.1 RFC 7231, Section 6.5.3");
    public static final Status NOT_FOUND = Status.instance(404, "NOT_FOUND", "HTTP/1.1 RFC 7231, Section 6.5.4");
    public static final Status METHOD_NOT_ALLOWED = Status.instance(405, "METHOD_NOT_ALLOWED", "HTTP/1.1 RFC 7231, Section 6.5.5");
    public static final Status NOT_ACCEPTABLE = Status.instance(406, "NOT_ACCEPTABLE", "HTTP/1.1 RFC 7231, Section 6.5.6");
    public static final Status PROXY_AUTHENTICATION_REQUIRED = Status.instance(407, "PROXY_AUTHENTICATION_REQUIRED", "HTTP/1.1 Authentication RFC 7235, Section 3.2");
    public static final Status REQUEST_TIMEOUT = Status.instance(408, "REQUEST_TIMEOUT", "HTTP/1.1 RFC 7231, Section 6.5.7");
    public static final Status CONFLICT = Status.instance(409, "CONFLICT", "HTTP/1.1 RFC 7231, Section 6.5.8");
    public static final Status GONE = Status.instance(410, "GONE", "HTTP/1.1 RFC 7231, Section 6.5.9");
    public static final Status LENGTH_REQUIRED = Status.instance(411, "LENGTH_REQUIRED", "HTTP/1.1 RFC 7231, Section 6.5.10");
    public static final Status PRECONDITION_FAILED = Status.instance(412, "PRECONDITION_FAILED", "HTTP/1.1 RFC 7232, Section 4.2");
    public static final Status REQUEST_ENTITY_TOO_LARGE = Status.instance(413, "REQUEST_ENTITY_TOO_LARGE", "HTTP/1.1 RFC 7231, Section 6.5.11");
    public static final Status REQUEST_URI_TOO_LONG = Status.instance(414, "REQUEST_URI_TOO_LONG", "HTTP/1.1 RFC 7231, Section 6.5.12");
    public static final Status UNSUPPORTED_MEDIA_TYPE = Status.instance(415, "UNSUPPORTED_MEDIA_TYPE", "HTTP/1.1 RFC 7231, Section 6.5.13");
    public static final Status REQUEST_RANGE_NOT_SATISFIABLE = Status.instance(416, "REQUEST_RANGE_NOT_SATISFIABLE", "HTTP/1.1 Range Requests RFC 7233, Section 4.4");
    public static final Status EXPECTATION_FAILED = Status.instance(417, "EXPECTATION_FAILED", "HTTP/1.1 RFC 7231, Section 6.5.14");
    public static final Status MISDIRECTED_REQUEST = Status.instance(421, "MISDIRECTED_REQUEST", "HTTP/2 RFC 7540, Section 9.1.2");
    public static final Status UNPROCESSABLE_ENTITY = Status.instance(422, "UNPROCESSABLE_ENTITY", "WebDAV RFC 4918, Section 11.2");
    public static final Status LOCKED = Status.instance(423, "LOCKED", "WebDAV RFC 4918, Section 11.3");
    public static final Status FAILED_DEPENDENCY = Status.instance(424, "FAILED_DEPENDENCY", "WebDAV RFC 4918, Section 11.4");
    public static final Status UPGRADE_REQUIRED = Status.instance(426, "UPGRADE_REQUIRED", "HTTP/1.1 RFC 7231, Section 6.5.15");
    public static final Status PRECONDITION_REQUIRED = Status.instance(428, "PRECONDITION_REQUIRED", "Additional HTTP Status Codes RFC 6585");
    public static final Status TOO_MANY_REQUESTS = Status.instance(429, "TOO_MANY_REQUESTS", "Additional HTTP Status Codes RFC 6585");
    public static final Status REQUEST_HEADER_FIELDS_TOO_LARGE = Status.instance(431, "REQUEST_HEADER_FIELDS_TOO_LARGE", "Additional HTTP Status Codes RFC 6585");
    public static final Status INTERNAL_SERVER_ERROR = Status.instance(500, "INTERNAL_SERVER_ERROR", "HTTP/1.1 RFC 7231, Section 6.6.1");
    public static final Status NOT_IMPLEMENTED = Status.instance(501, "NOT_IMPLEMENTED", "HTTP/1.1 RFC 7231, Section 6.6.2");
    public static final Status BAD_GATEWAY = Status.instance(502, "BAD_GATEWAY", "HTTP/1.1 RFC 7231, Section 6.6.3");
    public static final Status SERVICE_UNAVAILABLE = Status.instance(503, "SERVICE_UNAVAILABLE", "HTTP/1.1 RFC 7231, Section 6.6.4");
    public static final Status GATEWAY_TIMEOUT = Status.instance(504, "GATEWAY_TIMEOUT", "HTTP/1.1 RFC 7231, Section 6.6.5");
    public static final Status HTTP_VERSION_NOT_SUPPORTED = Status.instance(505, "HTTP_VERSION_NOT_SUPPORTED", "HTTP/1.1 RFC 7231, Section 6.6.6");
    public static final Status VARIANT_ALSO_NEGOTIATES = Status.instance(506, "VARIANT_ALSO_NEGOTIATES", "Transparent Content Negotiation in HTTP RFC 2295, Section 8.1 (Experimental)");
    public static final Status INSUFFICIENT_STORAGE = Status.instance(507, "INSUFFICIENT_STORAGE", "WebDAV RFC 4918, Section 11.5");
    public static final Status LOOP_DETECTED = Status.instance(508, "LOOP_DETECTED", "WebDAV Binding Extensions RFC 5842, Section 7.2 (Experimental)");
    public static final Status NOT_EXTENDED = Status.instance(510, "NOT_EXTENDED", "An HTTP Extension Framework RFC 2774, Section 7 (Experimental)");
    public static final Status NETWORK_AUTHENTICATION_REQUIRED = Status.instance(511, "NETWORK_AUTHENTICATION_REQUIRED", "Additional HTTP Status Codes RFC 6585, Section 6");
    //</editor-fold>

    private Status(Integer code, String name) {
        code(code);
        name(name);
        alias(name);
        description(Text.instance());
    }

    public static Status instance(Integer code, String name) {
        return new Status(code, name);
    }

    private static Status instance(Integer code, String name, String description) {
        Status status = new Status(code, name);
        status.description(Text.instance(description));
        return status;
    }

    public final Status code(Integer code) {
        set("code", code);
        return this;
    }

    public final Integer code() {
        return get("code");
    }

}
