import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
//import org.apache.commons.codec.binary.Base64;


public class MyStringCrypto {

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String SALT = "AIR";

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
            SecretKeySpec secretKey;
            byte[] key;
            MessageDigest sha = null;
            key = m_key.getBytes("UTF-8");
            System.out.println(key.length);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit
            System.out.println(key.length);
            System.out.println(new String(key,"UTF-8"));
            secretKey = new SecretKeySpec(key, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(mode, secretKey);
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
}
