/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0070.bank;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author tuana
 */
public class EBank {

    public static void loginWithVietNamese() {
        Locale locale = new Locale("vn");
//        String base_name= "j1.s.p0070.lang_vn";
        setLocale(locale);
    }

    public static void loginWithEnglish() {
        Locale locale = new Locale("en");
//        String base_name= "j1.s.p0070.lang_en";
        setLocale(locale);
    }

    public static void setLocale(Locale locale) {
        loiginSystem(locale);
    }

    private static void loiginSystem(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("j1.s.p0070.lang", locale);
        GetInput GetInput = new GetInput();

        String accountNumber = GetInput.getString(bundle.getString("Account"), bundle.getString("AccountError"), bundle.getString("AccountEmpty"), "[0-9]{10,}");
        String password = GetInput.getPassword(bundle.getString("Password"), bundle.getString("PasswordEmpty"), bundle.getString("PasswordError"));
        String userEnterCaptcha;

        //loop until user enter a correct captcha
        while (true) {
            String captcha = generateCaptcha();
            System.out.println(bundle.getString("Captcha") + captcha);
            userEnterCaptcha = GetInput.getString(bundle.getString("CaptchaEnter"), "", bundle.getString("CaptchaEmpty"), "");
            //loop until check user enter a correct captcha
            if (userEnterCaptcha.equals(captcha)) {
                break;
            }
            System.out.println(bundle.getString("CaptchaWrong"));
        }
        boolean accountExit = checkAccountNumber(accountNumber);
        boolean passwordExit = checkPassword(accountNumber, password);

        /*Check if accountNumber and password of accountNumber is exist in 
        list of account*/
        if (accountExit && passwordExit) {
            System.out.println(bundle.getString("LoginSuccess"));
        } else {
            System.out.println(bundle.getString("LoginFail"));
        }
    }

    //Check account number is
    public static boolean checkAccountNumber(String accountNumber) {
        ArrayList<Account> accountList = listAccount();
        //check list account has empty or not
        if (accountList.isEmpty()) {
            return false;
        } else {
            //Traverso to first element of array to last element 
            for (Account account : accountList) {
                //check account user enter is exit or not
                if (account.getAccountNumber().equals(accountNumber)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkPassword(String accountNumber, String password) {
        ArrayList<Account> accountList = listAccount();
        //check list account has empty or not
        if (accountList.isEmpty()) {
            return false;
        } else {
            //Traverso to first element of array to last element 
            for (Account account : accountList) {
                /*check account and password user enter same account 
              and passsword in list accont or not
                 */
                if (account.getAccountNumber().equals(accountNumber) && account.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String generateCaptcha() {
        Random random = new Random();
        String captcha = "";
        String numberCharacter = "0123456789";
        char character = 'A';
        //Loop add until uppcase and lowercase to number character
        for (int i = 0; i < 26; i++) {
            numberCharacter += Character.toString(character).toLowerCase() + character;
            character += 1;
        }
        //Loop until get a captcha with a correct format and length must equal 5
        do {
            //loop from first to last element of character
            for (int i = 0; i < 5; i++) {
                int indexCharacter = random.nextInt(numberCharacter.length());
                captcha += numberCharacter.charAt(indexCharacter);
            }
            //check leght has 5 or not
            if (captcha.length() == 5) {
                break;
            }
        } while (true);
        return captcha;
    }

    public static ArrayList<Account> listAccount() {
        ArrayList<Account> listAccount = new ArrayList<>();
        listAccount.add(new Account("0123456789", "123456ab"));
        return listAccount;

    }

}
