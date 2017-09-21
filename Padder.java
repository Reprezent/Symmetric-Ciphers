// Richard Riedel, J.T. Liso, Sean Whalen
// CS 583 Fall 2017
// Programming Assignment 1
//


import java.util.Arrays;

class Padder
{
	private int padlength;

    // Function Name: pad 
    //
    // Param: data containing bytes for encrypted data
    // Param: blockize of the IV
    // Return: padded data 
    //
    public byte[] pad(byte[] data, int blocksize)
    {
		padlength = blocksize%data.length;

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
