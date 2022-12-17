/*
 @author: lateef
 @project: digitalashram
 @created: 17/12/2022 - 3:07 pm
 */
package com.digitalashram.core.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import java.security.Key;

public class CansCrypt {
    public static final String EMPTY = "";

    private static String algorithm = "AES";
    private static String algorithmChiper = "AES/CBC/PKCS5PADDING";
    //private static byte[] keyValue = new byte[] { 'D', 'i', 'g', 'I', 't', 'a', 'l', 'A', 's', 'H', 'R', 'A', 'm','o','r','G'};

    private static byte[] keyValue = new byte[] { 'T', 'e', 'c', 'H', 't', 'r', 'e', 'E', 'i', 'T', 'S', 'Y', 's', 't', 'e', 'M' };
    private static IvParameterSpec ivspec = new IvParameterSpec(keyValue);

    private CansCrypt() {
        // Default implementation is ignored.
    }

    // Performs Encryption
    public static String encrypt(String plainText) {
        Key key = generateKey();
        byte[] encVal;
        try {
            Cipher chiper = Cipher.getInstance(algorithmChiper);
            chiper.init(Cipher.ENCRYPT_MODE, key, ivspec);
            encVal = chiper.doFinal(plainText.getBytes("UTF8"));
            return new Base64().encodeToString(encVal);
        } catch (Exception e) {
            System.out.println("@@@ Exception in CansCrypt at encrypt(): "+ e);
        }
        return null;
    }

    // generateKey() is used to generate a secret key for AES algorithm
    private static SecretKeySpec generateKey() {
        return new SecretKeySpec(keyValue, algorithm);
    }

    // Performs decryption
    public static String decrypt(String encryptedText) {
        // generate key
        Key key = generateKey();
        byte[] decValue = null;
        try {
            Cipher chiper = Cipher.getInstance(algorithmChiper);
            chiper.init(Cipher.DECRYPT_MODE, key, ivspec);
            byte[] decordedValue = new Base64().decode(encryptedText.getBytes("UTF8"));
            decValue = chiper.doFinal(decordedValue);
            return new String(decValue, "UTF-8");
        } catch (Exception e) {
            System.out.println("@@@ Exception in CansCrypt at decrypt(): "+ e);
        }
        return EMPTY;
    }


    public static void main(String[] args) {

        String originalval="2776";
        System.out.println("originalval "+originalval);
        String encryptedval = encrypt(originalval);
        System.out.println("encryptedval "+encryptedval);
        String decryptedval=decrypt(encryptedval);
        System.out.println("decryptedval "+decryptedval);

    }
}
