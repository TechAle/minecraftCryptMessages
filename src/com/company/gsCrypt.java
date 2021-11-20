package com.company;

import java.util.Locale;
import java.util.Random;

/*
    @Author: TechAle
 */

/*
    This basically is a custom Caesar cipher.
    Given a string, for calculating the crypted text, we sum each character by
    a random number that is recived by a random function with seed
    as key + lenght + index character
 */

/*
    How to make it works:
    gsCrypt crypt = new gsCrypt("prova");
    String encrypted = crypt.encrypt("ciac");
    String dencrypted = crypt.decrypt("ryor");
 */

public class gsCrypt {

    String keyString;

    public gsCrypt(String key) {
        this.keyString = key;
    }

    /*
        Return a Random variable with as seed the sum of characters + the length
     */
    Random getRandom(String text, int lenght) {
        int value = 0;
        for(char character : text.toCharArray())
            value += character;
        value += lenght;
        return new Random(value);
    }

    /*
        This return a string encrypted
     */
    String encrypt(String text) {
        text = text.toLowerCase(Locale.ROOT);
        StringBuilder st = new StringBuilder();
        int lenght = text.length();
        int i = 0;
        for(char character : text.toCharArray()) {
            st.append(encryptChar(getRandom(this.keyString, lenght + (i++)), character));
        }
        return st.toString();
    }

    /*
        This is used by the function encrypt
        and return the new encrypted character
     */
    char encryptChar(Random rd, char character) {
        int newChar;
        return (char) ((newChar = character + (rd.nextInt(25))) > 122
                        ? newChar - 25 : newChar);
    }

    /*
        Return the decrypted text
     */
    String decrypt(String text) {
        StringBuilder st = new StringBuilder();
        int lenght = text.length();
        int i = 0;
        for(char character : text.toCharArray()) {
            st.append(decryptChar(getRandom(this.keyString, lenght + (i++)), character));
        }
        return st.toString();
    }

    /*
        This, given a character, decrypt it, is used by the function decrypt
     */
    char decryptChar(Random rd, char charecter) {
        int newChar;
        return (char) ((newChar = charecter - (rd.nextInt(25))) < 97
                ? newChar + 25 : newChar);
    }


}
