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
					if((i+1) >= cmdopts.length){
						System.err.println("ERROR: No key file provided.");
                        System.exit();
						return;
					}

					keyFile = cmdopts[++i];
					break;

				case "-i":
					if((i+1) >= cmdopts.length){
						System.err.println("ERROR: No input file provided.");
                        System.exit();
						return;
					}

					inputFile = cmdopts[++i];
					break;
				
				case "-o":
					if((i+1) >= cmdopts.length){
						System.err.println("ERROR: No output file provided.");
                        System.exit();
						return;
					}

					outputFile = cmdopts[++i];
					break;

				case "-v":
					if((i+1) >= cmdopts.length)
                    {
                        System.err.println("ERROR: No IV file provided.");
                        System.exit();
						return;
                    }
					

					ivFile = cmdopts[++i];
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
