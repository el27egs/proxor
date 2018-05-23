import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;
import com.csvreader.CsvReader;

import com.csvreader.*;

public class WriteHtml {
    public static final String inFileName = "input.csv";
    public static final String outFileName = "output.html";
    public static String[][] sheet;

    public static void main(String[] args) {
        // ... insert code here ...
    	//  Do not change the signature of this method.
	    BufferedReader input;
	    BufferedWriter output;
	    
	    try {
	        //use buffering, reading one line at a time
	        input =  new BufferedReader(new FileReader(inFileName));
	    } catch (FileNotFoundException ex) {
	    	System.out.println("Could not open " + inFileName);
	    	ex.printStackTrace();
	    	return;
	    }
	    try {
	        output = new BufferedWriter(new FileWriter(outFileName));
	    } catch (IOException ex) {
	    	System.out.println("File IO Error opening " + outFileName);
	    	ex.printStackTrace();
	    	return;
	    }	    
	    try {
        	CsvReader csvrCol = new CsvReader(inFileName);
        	csvrCol.readHeaders();
        	int maxCol = csvrCol.getHeaderCount();
        	csvrCol.close();
        	
			CsvReader csvr = new CsvReader(inFileName);		
        	csvr.getHeaders();
        	int r = 0;
        	String contenido = "<html>\n" + 
        			"  <head>\n" + 
        			"    <title>test.csv</title>\n" + 
        			"  </head>\n" + 
        			"  <body>\n" + 
        			"    <table style=\" text-align: left;\" border=\"1\"\n" + 
        			"      cellpadding=\"2\" cellspacing=\"2\">\n" + 
        			"      <tbody>\n";
        	while(csvr.readRecord())
        	{
        		contenido += "        <tr>\n" ;
        		for(int c=0; c<maxCol; c++){
        			contenido += "          <td>" + csvr.get(c) + "<br></td>\n";
        		}
        		contenido += "        </tr>\n";
        	}
        	contenido += "      </tbody>\n" + 
        			"    </table>\n" + 
        			"    <br>\n" + 
        			"  </body>\n" + 
        			"</html>";
        	csvr.close();
        	System.out.println(contenido);
         	output.write(contenido);
//	        while ((c = input.read()) != -1) { 
//	        	output.write(a);
//	        }
	        System.out.println("Copied " + inFileName + " to " + outFileName);
	    } catch (IOException ex) {
	    	System.out.println("File IO Error encountered.");
	    	ex.printStackTrace();
	    }
	    try {
	        input.close();
	    } catch (IOException ex) {
	    	// assume an earlier error caused this and was already reported
	    }
	    try {
	       	output.close();
	    } catch (IOException ex) {
	    	// assume an earlier error caused this and was already reported
	    }

    }
    
}
