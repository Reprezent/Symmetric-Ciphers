import java.util.Random;
import java.util.Arrays;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

class CBC{

	public static byte[] encrypt(byte[] msg, byte[] key, byte[] iv){
        byte[] padded_msg = Padder.pad(msg, AES.blocksize());
        // Prepend IV
		byte[] encrypted_msg = Arrays.copyOf(iv, padded_msg.length + iv.length);
		byte[] cipher = iv;
        byte[] buffer = new byte[AES.blocksize()];
    

		// block-chaining
		for(int i = iv.length; i < padded_msg.length; i+=iv.length){

			// XORing each byte in the message and current cipher
			for(int j = 0; j < buffer.length; j++){
				buffer[j] = (byte)(padded_msg[i + j] ^ cipher[j]);
			}

            cipher = AES.Encrypt(buffer, key);

            // Transfer the encypted bytes to the correct array.
            for(int j = 0; j < cipher.length; j++)
            {
                encrypted_msg[i + j] = cipher[j];
            }
		}

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
