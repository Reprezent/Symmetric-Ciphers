// Richard Riedel, J.T. Liso, Sean Whalen
// CS 583 Fall 2017
// Programming Assignment 1
//

import java.nio.file.Files;
import java.io.IOException;
import java.lang.UnsupportedOperationException;
import java.lang.SecurityException;

class CBCDec
{
    public CBCDec(String[] args)
    {
        CommandLineArgParser cmd_args = new CommandLineArgParser(args);
        byte[] data = null, iv = null, key = null, output = null;
        try
        {
            data = Files.readAllBytes(cmd_args.getInputFile());
            key = utils.hexStringToBinary(Files.readAllBytes(cmd_args.getKeyFile()));
            if(cmd_args.hasIVFile())
            {
                iv = utils.hexStringToBinary(Files.readAllBytes(cmd_args.getIVFile()));
            }
        }
        catch(IOException e) { System.err.println(e.getMessage()); }
        
        output = ((iv == null) ? CBC.decrypt(data, key) : CBC.decrypt(data, key, iv));

        try
        {
            Files.write(cmd_args.getOutputFile(), output);
        }
        catch(IOException e)                   { System.err.println(e.getMessage()); }
        catch(UnsupportedOperationException e) { System.err.println(e.getMessage()); }
        catch(SecurityException e)             { System.err.println(e.getMessage()); }

    }

    public static void main(String[] args)
    {
        new CBCDec(args);
    }
}
