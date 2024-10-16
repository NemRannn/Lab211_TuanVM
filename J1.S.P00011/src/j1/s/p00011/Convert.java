/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p00011;

import java.math.BigInteger;

/**
 *
 * @author tuana
 */
class Convert {

    public static String convertValue(String inputValue, int baseInput, int baseOutput) {
        String result = "";
        switch (baseInput) {
            //Convert Binary to Other
            case 2:
                result = convertBinToOther(baseInput, inputValue, baseOutput);
                break;
            //Convert Decimal to Other
            case 10:
                result = convertDecToOther(inputValue, baseOutput);
                break;
            //Convert Hexadecimal to Other
            case 16:
                result = convertHexToOther(baseInput, inputValue, baseOutput);
                break;
        }
        return result;
    }

    public static String binToHex(String input) {
        switch (input) {
            case "0000":
                return "0";
            case "0001":
                return "1";
            case "0010":
                return "2";
            case "0011":
                return "3";
            case "0100":
                return "4";
            case "0101":
                return "5";
            case "0110":
                return "6";
            case "0111":
                return "7";
            case "1000":
                return "8";
            case "1001":
                return "9";
            case "1010":
                return "A";
            case "1011":
                return "B";
            case "1100":
                return "C";
            case "1101":
                return "D";
            case "1110":
                return "E";
            case "1111":
                return "F";
            default:
                return "";
        }
    }

    public static String hexToBin(String input) {
        switch (input) {
            case "0":
                return "0000";
            case "1":
                return "0001";
            case "2":
                return "0010";
            case "3":
                return "0011";
            case "4":
                return "0011";
            case "5":
                return "0101";
            case "6":
                return "0110";
            case "7":
                return "0111";
            case "8":
                return "1000";
            case "9":
                return "1001";
            case "A":
                return "1010";
            case "B":
                return "1011";
            case "C":
                return "1100";
            case "D":
                return "1101";
            case "E":
                return "1110";
            case "F":
                return "1111";
            default:
                return "";
        }
    }

    public static String convertBinToOther(int baseInput, String inputValue, int baseOutput) {
        BigInteger inputBase = new BigInteger(Integer.toString(baseInput));
        String result = "";
        switch (baseOutput) {
            //Case Binary to decimal
            case 10:
                BigInteger decString = new BigInteger("0");
                //Loop to access each character from begining to end of the string
                for (int i = 0; i < inputValue.length(); i++) {
                    BigInteger number = new BigInteger(Character.toString(inputValue.charAt(i)));
                    decString = decString.add(number.multiply(inputBase.pow(inputValue.length() - (i + 1))));
                }
                result = decString.toString();
                break;
            //Case Binary to Hexadecimal
            case 16:
                //Check remain of inputValue length divided by 4 are equal, or not equal to 0
                while (inputValue.length() % 4 != 0) {
                    inputValue = "0" + inputValue;
                }
                //Loop to access each substring with length = 4 from begining to the end of the string 
                for (int i = 0; i < inputValue.length(); i += 4) {
                    String binSequence = inputValue.substring(i, i + 4);
                    result += binToHex(binSequence);
                }
                break;
        }
        return result;
    }

    public static String convertDecToOther(String valueInput, int baseOutput) {
        String hexSequence = "0123456789ABCDEF";
        BigInteger inputValue = new BigInteger(valueInput);
        StringBuilder result = new StringBuilder();
        BigInteger outputBase = new BigInteger(Integer.toString(baseOutput));
        do {
            BigInteger remain = inputValue.remainder(outputBase);
            char number = hexSequence.charAt(remain.intValue());
            //Compare inputValue to 0 or not
            if (!inputValue.equals(new BigInteger("0"))) {
                result = result.append(number);
                inputValue = inputValue.divide(outputBase);
            } else {
                break;
            }
        } while (true);
        return result.reverse().toString();
    }

    public static String convertHexToOther(int baseInput, String valueInput, int baseOutput) {
        String hexSequence = "0123456789ABCDEF";
        BigInteger inputBase = new BigInteger(Integer.toString(baseInput));
        String result = "";
        switch (baseOutput) {
            //Case Hexadecimal to Binary
            case 2:
                //Loop to access each character from begining to end of the string
                for (int i = 0; i < valueInput.length(); i++) {
                    String hexChar = Character.toString(valueInput.charAt(i));
                    result += hexToBin(hexChar);
                }
                break;
            //Case Hexadecimal to Decimal
            case 10:
                BigInteger decString = new BigInteger("0");
                //Loop to access each character from begining to end of the string
                for (int i = 0; i < valueInput.length(); i++) {
                    int digit = hexSequence.indexOf(Character.toString(valueInput.charAt(i)));
                    BigInteger number = new BigInteger(Integer.toString(digit));
                    decString = decString.add(number.multiply(inputBase.pow(valueInput.length() - (i + 1))));
                }
                result = decString.toString();
        }
        return result;
    }

}
