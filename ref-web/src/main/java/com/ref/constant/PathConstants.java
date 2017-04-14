package com.ref.constant;

/**
 * Created by perxin on 2017/3/31 14:46.
 *
 */
public class PathConstants {

    ////////////////////////////////////////////////////////////

    public static final String ROUTE_USER = "user";
    public static final String ROUTE_USER_SIGN_UP = "/sign_up";
    public static final String ROUTE_USER_SIGN_IN = "/sign_in";
    public static final String ROUTE_USER_SIGNOUT = "/sign_out";

    ////////////////////////////////////////////////////////////

    public static final String ROUTE_NOTE = "note";
    public static final String ROUTE_NOTE_ADD = "/add";
    public static final String ROUTE_NOTE_MODIFY = "/modify/{noteId}";
    public static final String ROUTE_NOTE_GET_PAGE = "/page";
    public static final String ROUTE_NOTE_GET_PAGE_HOT = "/page_hot";
    public static final String ROUTE_NOTE_GET_PAGE_NEW = "/page_new";
    public static final String ROUTE_NOTE_GET_NOTE_DETAIL = "/{noteId}";
    public static final String ROUTE_NOTE_GET_COMMENT = "/comment";
}