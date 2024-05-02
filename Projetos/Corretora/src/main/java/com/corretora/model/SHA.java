package com.corretora.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class SHA {

    public static String SHA1(String texto) {
        StringBuilder hexString = new StringBuilder();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] hash = digest.digest(texto.getBytes());
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return hexString.toString();
    }

    public static String SHA256(String texto) {
        StringBuilder hexString = new StringBuilder();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(texto.getBytes());
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return hexString.toString();
    }
}
