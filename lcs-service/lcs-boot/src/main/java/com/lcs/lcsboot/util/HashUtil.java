package com.lcs.lcsboot.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    public String getSHA(String input){
        try{
            MessageDigest md=MessageDigest.getInstance("SHA-256");
            byte[] messageDigest=md.digest(input.getBytes());
            BigInteger no=new BigInteger(1,messageDigest);
            String hashtext=no.toString(16);
            while (hashtext.length()<32){
                hashtext="O"+hashtext;
            }
            return hashtext;
        }catch (NoSuchAlgorithmException e){
            System.out.println("Exception thrown for incorrect algorithm:"+e);
            return null;
        }

    }
}