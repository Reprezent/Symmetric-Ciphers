import java.net.*;
import java.util.Arrays;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

public class EncThreadCTR extends Thread
{
	byte[] msg;
	byte[] key;
	byte[] iv;
	int pos;
	SharedData cipherBase;

	public EncThreadCTR(byte[] msg, byte[] key, byte[] iv, int pos, SharedData C)
	{
		this.msg = msg;
		this.key = key;
		this.iv = iv;
		this.pos = pos;
		this.cipherBase = C;
	}
	public void run()
	{
		byte[] iv_enc = AES.Encrypt(iv, key);
		byte[] buffer = new byte[AES.blocksize()];
		int i = 0;
		for (i = 0; i < msg.length; i++) {
			try {
				buffer[i] = (byte)(iv_enc[i] ^ msg[i]);
			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				System.err.println("I is " + Integer.toString(i));
			}
		}

		cipherBase.insertBlock(pos, Arrays.copyOf(buffer,i));
	}
}
