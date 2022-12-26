package com.leetcode;

import java.security.*;
import java.math.*;
import java.util.Formatter;

public class SHA256 {

    private static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This SHA256 function returns a 256-character binary String representing the full SHA256 hash of the String toHash
     * This binary String is useful when signing a message with a Lamport Signature.
     *
     * @param toHash The String to hash using SHA256
     *
     * @return String The binary String representing the entire SHA256 hash of toHash
     */
    private static String SHA256Binary(String toHash) {
        try {
            byte[] messageHash = md.digest(toHash.getBytes("UTF-8"));
            return toHexString(new BigInteger(1, messageHash).toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private static String toHexString(byte[] bytes) {
        Formatter result = new Formatter();
        try (result) {
            for (var b : bytes) {
                result.format("%02x", b & 0xff);
            }
            return result.toString();
        }
    }
}