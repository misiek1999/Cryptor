import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
//import org.apache.commons.codec.binary.Base64;


public class MyStringCrypto {

    public static final String encrypt(final String toDecrypt, final String key) {
        return crypto(toDecrypt,key,Cipher.ENCRYPT_MODE);
    }

    public static final String decrypt(final String toDecrypt, final String key) {
        return crypto(toDecrypt,key,Cipher.DECRYPT_MODE);
    }

    private static final String crypto(final String toCrypt, final String m_key, final int mode) {

        if (toCrypt.isEmpty() || m_key.isEmpty())
            return null;

        String strData="";

        try {
            SecretKeySpec sKey = crateKey(m_key);
            if (sKey == null)
                return strData;

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(mode, sKey);
            if (mode == Cipher.ENCRYPT_MODE)
                strData = new String(Base64.getEncoder().encode(cipher.doFinal(toCrypt.getBytes("UTF-8"))));
            else
                strData = new String(cipher.doFinal(Base64.getDecoder().decode(toCrypt)));

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("WTF! ");
        }
        return strData;
    }

    private static SecretKeySpec crateKey(String keyString){
        SecretKeySpec secretKey = null;
        try {
            byte[] key;
            MessageDigest sha = null;
            key = keyString.getBytes("UTF-8");
            System.out.println(key.length);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit
            System.out.println(key.length);
            System.out.println(new String(key, "UTF-8"));
            secretKey = new SecretKeySpec(key, "AES");
        } catch (Exception e){
            e.printStackTrace();

        }
        return secretKey;

    }
}
