package me.rsa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {


    public static  void main(String[] args){
        RSA rsa = new RSA();
        BigInteger mod = new BigInteger("65");
        BigInteger keyE = new BigInteger("17");
        BigInteger keyD = new BigInteger("17");
        Scanner input = new Scanner(System.in);
        while (true){

              args = input.nextLine().split(" ");
              if (args[0].equalsIgnoreCase("encrypte") && args.length > 1){
                  args[0] = "";
                  StringBuilder encryptText = rsa.encryptText(mod,keyD,args);
                  System.out.println("Encrypting like a Science19 Student...");
                  System.out.println(encryptText);
              } else if (args[0].equalsIgnoreCase("decrypt") && args.length > 1){
                  args[0] = "";
                  StringBuilder decryptText = rsa.decryptText(mod,keyE,args);
                  System.out.println("Encrypting like a Science19 Student...");
                  System.out.println(decryptText);
              } else
                  System.out.println("Invalid arguements you mortal being!");



        }



    }

}
