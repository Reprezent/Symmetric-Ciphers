// Richard Riedel, J.T. Liso, Sean Whalen
// CS 583 Fall 2017
// Programming Assignment 1
//


class CommandLineArgParser
{
    public CommandLineArgParser(String[] cmdopts)
    {
		keyFile = null;
		inputFile = null;
		outputFile = null;
		ivFile =  null;

		int i;

		//parsing list of command options
		for(i = 0; i < cmdopts.length; i++){
			switch(cmdopts[i]){
				case "-k":
					keyFile = cmdopts[i++];
					break;

				case "-i":
					inputFile = cmdopts[i++];
					break;
				
				case "-o":
					outputFile = cmdopts[i++];
					break;

				case "-v":
					ivFile = cmdopts[i++];
					break;

				default:
					System.err.println("Ignoring command line argument " + cmdopts[i]);
					break;
			}
		}

    }

    public boolean hasKeyFile()
    {
		return keyFile != null;
    }

    public String getKeyFile()
    {
		return keyFile;
    }

    public boolean hasInputFile()
    {
		return inputFile != null;
    }

    public String getInputFile()
    {
		return inputFile;
    }


    public boolean hasoutputFile()
    {
		return outputFile != null;
    }


    public String getOutputFile()
    {
		return outputFile;
    }

    public boolean hasIVFile()
    {
		return ivFile != null;
    }

    public String getIVFile()
    {
		return ivFile;
    }



    private String opts;
	private String keyFile;
	private String inputFile;
	private String outputFile;
	private String ivFile;
}
