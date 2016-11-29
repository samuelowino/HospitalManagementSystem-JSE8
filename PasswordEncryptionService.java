/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author HACKER
 */
public class PasswordEncryptionService {
public static String getCipherText(String plainText) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] cipherLavelOne = messageDigest.digest(plainText.getBytes());
            messageDigest.update(plainText.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i< cipherLavelOne.length;i++){
                stringBuilder.append(Integer.toString((cipherLavelOne[i] & 0xff) + 0x100,32)).toString();
            }
            return  stringBuilder.toString();
            
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
            
        
    }
}
