package com.sobol.JavaServer;

import java.util.HashSet;
import java.util.Set;

public class RegisterRepository {

    public static Set <String> tokens = new HashSet<>();

    public static void register(String token) {
        tokens.add(token);
    }

    public static void unregister(String token) {
        tokens.remove(token);
    }

    public static boolean isRegister(String token) {
        return tokens.contains(token);
    }
}
