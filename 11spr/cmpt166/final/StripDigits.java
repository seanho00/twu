/** StripDigits: remove digit characters from text file
 * There are a couple ways to do this; the code below includes
 * two ways, so each line in the output is doubled.
 * Usage: StripDigits <infile> <outfile>
 * @author Sean Ho
 */
package com.seanho;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class StripDigits {
	/** main()
	 * @param args
	 */
	public static void main(String[] args) {

		// For exam purposes it's okay to read only from fixed files
		String inName  = "input.txt";
		if (args.length >= 2) inName  = args[1];
		String outName = "output.txt";
		if (args.length >= 3) outName = args[2];
		File inFile  = new File( inName  );
		File outFile = new File( outName );

		// Open input stream
		Scanner in = null;
		try {
			in = new Scanner( inFile );
			System.err.println("Reading from " + inFile);
		} catch (FileNotFoundException e) {
			in = new Scanner( System.in );
			System.err.println("Reading from stdin");
		}

		// Open output stream
		PrintWriter out = null;		// output text
		try {
			out = new PrintWriter( outFile );
			System.err.println("Writing to " + outFile);
		} catch (FileNotFoundException e) {
			out = new PrintWriter( System.out );
			System.err.println("Writing to stdout");
		}
		
		// Read+write one line at a time
		String line;
		while ( in.hasNextLine() ) {
			line = in.nextLine();
			
			// Easy way: use String utility method
			out.println( line.replaceAll("[0-9]", "") );

			// Alternate way: loop over each char
			for (char c : line.toCharArray()) {
				switch (c) {
				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
					break;
				default:
					out.print(c);
				}
			}
			out.println();
			
			out.flush();
		}
		
		in.close();
		out.close();
	}
}
