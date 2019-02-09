import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;


public class MyStringCrypto {

    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final int SIZE = 128;
    private final SecureRandom random;

    public static final String encrypt(final String toDecrypt, final String key) {
        return crypto(toDecrypt,key,Cipher.ENCRYPT_MODE);
    }

    public static final String decrypt(final String toDecrypt, final String key) {
        return crypto(toDecrypt,key,Cipher.DECRYPT_MODE);
    }

    private static final String crypto(final String toCrypt, final String m_key, final int mode) {

        if (toCrypt.isEmpty() || m_key.isEmpty())
            return null;

        String encrypt = null;
        byte[] decodedKey = Base64.getDecoder().decode(m_key);
        Key key = new SecretKeySpec(m_key.getBytes(), 0, m_key.getBytes().length, method);


        //Key key = new SecretKeyFactory.getInstance("AES")
        try {
            Cipher cipher = Cipher.getInstance(method);
            cipher.init(mode, key);
            encrypt = new String(cipher.doFinal(toCrypt.getBytes()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypt;
    }
}
