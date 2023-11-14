package com.example.saqayaCoderbyteProject.config;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SHA1HashGenerator {
    @Value("${our.salt}")
    private static String salt;
    public static String generateHash(String email) {

        try {
            // Concatenate the email and salt
            String data = email + salt;

            // Create SHA1 hash
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = digest.digest(data.getBytes());

            // Convert byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
