package com.ref.util;

import java.util.ResourceBundle;

public class QCloudUtil {
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("propertites/file");

    public static final String URL = BUNDLE.getString("file.url");
}
