import java.util.Random;
import java.util.Arrays;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

class CTR{

	public static byte[] encrypt(byte[] msg, byte[] key, byte[] iv){
        byte[] padded_msg = Padder.pad(msg, AES.blocksize());
        // Prepend IV
		byte[] encrypted_msg = Arrays.copyOf(iv, padded_msg.length + iv.length);
		byte[] cipher = iv;
        byte[] buffer = new byte[AES.blocksize()];
    
		return encrypted_msg;
	}

    public static byte[] encrypt(byte[] msg, byte[] key)
    {
        // IV generation
        SecureRandom rng = new SecureRandom();
        byte[] buffer = new byte[AES.blocksize()];
        rng.nextBytes(buffer);

        return encrypt(msg, key, buffer);
    }

	public static byte[] decrypt(byte[] msg, byte[] key, byte[] iv){
		byte[] decrypted =  new byte[msg.length];
		
		//unpad


		return decrypted;
	}

    public static byte[] decrypt(byte[] msg, byte[] key)
    {
        // IV generation
        SecureRandom rng = new SecureRandom();
        byte[] buffer = new byte[AES.blocksize()];
        rng.nextBytes(buffer);

        return decrypt(msg, key, buffer);
    }
}
