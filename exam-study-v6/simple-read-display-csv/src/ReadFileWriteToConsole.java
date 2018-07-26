import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class ReadFileWriteToConsole {
	
	private static final int MAXROW = 3;
	private static final int MAXCOL = 3;
    private static final String inFile = "in.csv";
	   
    public String[][] sheet = new String[MAXROW][MAXCOL];
	   
    public static void main(String args[]) throws IOException {
    	// create a ReadWriteToConsole object
    	ReadFileWriteToConsole obj = new ReadFileWriteToConsole();
    	//  Do not change the signature of this method.
    	// ... insert code here ...
    	// invoke readSheet()
    	obj.readSheet();
    	// ... insert code here ...
    	// invoke writeSheet()
    	// ... insert code here ...
    	obj.writeSheet();
    }	
	   
    public void readSheet() throws IOException {
    	// ... insert code here ...
    	//  Do not change the signature of this method.
    	CsvReader csvR = new CsvReader(inFile);
    	int r=0;
    	while(csvR.readRecord()) {
    		for(int c=0; c<csvR.getColumnCount(); c++) {
    			sheet[r][c] = csvR.get(c);
    		}
    		r++;
    	}
    	csvR.close();
	}
	   
	public void writeSheet(){
		// ... insert code here ...
    	//  Do not change the signature of this method.
		CsvWriter csvW = new CsvWriter(inFile);
		for(int r=0; r<MAXROW; r++) {
			for(int c=0; c<MAXCOL; c++) {
				System.out.print("[" + sheet[r][c] + "]");
			}
			System.out.println();
		}
	}
}
