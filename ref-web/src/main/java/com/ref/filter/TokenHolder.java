package com.ref.filter;

import com.ref.base.util.GSONUtil;
import com.ref.model.user.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Created by perxin on 2017/4/10.
 */
public class TokenHolder {

    private static Logger logger = LoggerFactory.getLogger(TokenHolder.class);

    private static final ThreadLocal<Token> token = new ThreadLocal<>();

    private TokenHolder() {};

    public static Token getToken() {
        return token.get();
    }

    public static Long getUserId() {
        Token tk = getToken();
        logger.info("userId:{}", tk == null ? null : tk.getUserId());
        return tk == null ? null : tk.getUserId();
    }
    public static Token getToken(String str) {
        return GSONUtil.fromJson(str, Token.class);
    }

    public static Long getUserId(String str) {
        Token tk = getToken(str);
        logger.info("userId:{}", tk == null ? null : tk.getUserId());
        return tk == null ? null : tk.getUserId();
    }

    public static void setToken(Token tk) {
        token.set(tk);
    }

    public static void removeToken() {
        if (getToken() != null) {
            token.remove();
        }
    }

}
