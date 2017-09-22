// Richard Riedel, J.T. Liso, Sean Whalen
// CS 583 Fall 2017
// Programming Assignment 1
//


import java.util.Arrays;
import java.lang.Integer;

class Padder
{

    // Function Name: pad 
    //
    // Param: data Plaintext to be encrypted.
    // Param: blockize Blocksize  of the cryptographic scheme.
    //
    // Return: byte[] Plaintext with padding added. 
    //
    static public byte[] pad(byte[] data, int blocksize)
    {

		int padlength = AES.blocksize() - data.length % blocksize;
        System.err.println("Data length: " + Integer.toString(data.length));
        System.err.println("Blocksize: " + Integer.toString(blocksize));
        System.err.println("Pad Length: " + Integer.toString(padlength));

		// padding an extra blocksize if the padlength would be 0
		if(padlength == 0)
			padlength = blocksize;
		
		byte[] padded_data = Arrays.copyOf(data, data.length+padlength);

		//padding the data with the padlength 
		for(int i = data.length; i < padded_data.length; i++){
			padded_data[i] = (byte)padlength;
		}

		return padded_data;
    }

}
