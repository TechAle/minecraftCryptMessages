package com.company;


import java.util.Random;

public class Main {

    public static void main(String[] args) {

        gsCrypt crypt = new gsCrypt("prova");

        String encrypted = crypt.encrypt("ciao it works");
        String encrypted1 = crypt.encrypt("cxad");
        String encrypted2 = crypt.encrypt("ciaaaao");

        System.out.print(encrypted + "\n");
        System.out.print(encrypted1 + "\n");
        System.out.print(encrypted2 + "\n");

        String dencrypted = crypt.decrypt("ryor");
        String dencrypted1 = crypt.decrypt("roos");
        String dencrypted2 = crypt.decrypt("riayycr");

        System.out.print(dencrypted + "\n");
        System.out.print(dencrypted1 + "\n");
        System.out.print(dencrypted2 + "\n");

    }



}
