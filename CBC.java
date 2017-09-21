import java.util.Random;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

class CBC{
	private byte[] iv;
	private AES aes;

	public CBC(byte[] i, AES a){
		iv = i;
		aes = a;
	}

	public byte[] encrypt(byte[] msg){
		byte[] encrypted = new byte[msg.length];
		byte[] cipher = iv;

		//block-chaining
		for(int i = 0; i < msg.length; i+=iv.length){
			byte[] seed = new byte[iv.length];

			//XORing each byte in the message and current cipher
			for(int j = 0; j < seed.length; j++){
				seed[j] = (byte)(msg[i] ^ cipher[j]);
			}

			//putting the seed through the PSRF
			//something = PSRF(seed);	

			//copying the array over to encrypted array
		//	for(int j = i; j < seed.length; j++)
				//encrypted[j] = something;
		}
		

		//padding after it has been encrypted
		Padder pad = new Padder();
		return pad.pad(encrypted, iv.length);
	}

	public byte[] decrypt(byte[] msg){
		byte[] decrypted =  new byte[msg.length];
		
		//unpad


		return decrypted;
	}
}
