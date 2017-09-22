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
}
