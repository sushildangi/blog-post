package com.luv2tech.util;

import java.util.UUID;

public final class UtilityMethods {
    private UtilityMethods() {
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
