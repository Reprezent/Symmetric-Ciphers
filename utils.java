class utils
{
    public static byte[] hexStringToBinary(byte[] hex_string)
    {
        String s = new String(hex_string);
        byte[] rv = new byte[s.length() / 2];
        for(int i = 0; i < s.length(); i += 2)
        {
            rv[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }

        return rv;
    }
	
	//from: https://stackoverflow.com/questions/32253298/adding-1-to-binary-byte-array
	public static byte[] addOne(byte[] A) throws Exception {
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 0) {
                A[i] = 1;
                return A;
            }
            A[i] = 0;
            if (i == 0) {
                throw new Exception("Overflow");
            }
        }
        return A;
    }
}
