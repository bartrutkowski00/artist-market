package com.am.user_service.security;

public class Encryption {

        public static String encrypt(String input) {
            StringBuilder encrypted = new StringBuilder();
            int key = 1;
            for (char c : input.toCharArray()) {
                char shifted = (char) (c + key);
                encrypted.append(shifted);
                key++;
            }
            return encrypted.toString();
        }

        public static String decrypt(String input) {
            StringBuilder decrypted = new StringBuilder();
            int key = 1;
            for (char c : input.toCharArray()) {
                char shifted = (char) (c - key);
                decrypted.append(shifted);
                key++;
            }
            return decrypted.toString();
        }


}
