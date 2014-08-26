package standard.security;

import standard.models.Student;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * User: Dimitr
 * Date: 01.01.13
 * Time: 14:27
 */
public class Encryptor {
    private static final String ALGORITHM = "HmacMD5";
    private static final String SECRET_KEY = "**secret_key***";

    public static String encrypt(String data) {
        try {
            Mac mac = Mac.getInstance(ALGORITHM);
            SecretKeySpec secret = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), mac.getAlgorithm());
            mac.init(secret);
            byte[] bytes = mac.doFinal(data.getBytes("ASCII"));

            StringBuilder hash = new StringBuilder();
            for (byte aByte : bytes) {
                String hex = Integer.toHexString(0xFF & aByte);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            return hash.toString();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
