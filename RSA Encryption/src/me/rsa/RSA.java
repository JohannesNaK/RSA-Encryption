package me.rsa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class RSA {

    private Map<Integer, String> numberLetterList = new HashMap<>();
    private Map<String, Integer> letterNumberList;
    public RSA (){
        numberLetterList.put(1, "A");
        numberLetterList.put(2, "B");
        numberLetterList.put(3, "C");
        numberLetterList.put(4, "D");
        numberLetterList.put(5, "E");
        numberLetterList.put(6, "F");
        numberLetterList.put(7, "G");
        numberLetterList.put(8, "H");
        numberLetterList.put(9, "I");
        numberLetterList.put(10, "J");
        numberLetterList.put(11, "K");
        numberLetterList.put(12, "L");
        numberLetterList.put(13, "M");
        numberLetterList.put(14, "N");
        numberLetterList.put(15, "O");
        numberLetterList.put(16, "P");
        numberLetterList.put(17, "Q");
        numberLetterList.put(18, "R");
        numberLetterList.put(19, "S");
        numberLetterList.put(20, "T");
        numberLetterList.put(21, "U");
        numberLetterList.put(22, "V");
        numberLetterList.put(23, "W");
        numberLetterList.put(24, "X");
        numberLetterList.put(25, "Y");
        numberLetterList.put(26, "Z");
        letterNumberList = numberLetterList.entrySet().stream().
                collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }




    StringBuilder decryptText(BigInteger moduloN, BigInteger keyE, String[] list) {
        StringBuilder text = new StringBuilder();
        String decryptedWord = "";
        String[] letters;
        for (String word : list){
            decryptedWord = "";
            letters = word.split(",");

            for (String letter : letters){
                try{
                    BigInteger x = new BigInteger(letter);

                    x = x.modPow(keyE, moduloN);
                    letter = numberLetterList.get(x.intValue());

                    decryptedWord += letter;
                } catch (NumberFormatException e){
                    System.out.println(letter + "Is not an integer!");
                }

            }
            decryptedWord += " ";
            text.append(decryptedWord);
        }
        return  text;

    }
    StringBuilder encryptText(BigInteger moduloN, BigInteger keyD, String[] list){

        StringBuilder text = new StringBuilder();
        String encryptedWord = "";
        for (String word : list){
            encryptedWord = "";
            for (Character letter : word.toCharArray()){
                try{
                    BigInteger x = new BigInteger("" + letterNumberList.get(letter.toString()));

                    x = x.modPow(keyD, moduloN);
                    encryptedWord += x;
                    encryptedWord += ",";
                } catch (NullPointerException e){
                    System.out.println(letter + " has no assigned value!");
                }

            }

            text.append(encryptedWord + " ");
        }
        return  text;
    }

}
