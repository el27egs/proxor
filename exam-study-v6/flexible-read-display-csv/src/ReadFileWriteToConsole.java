import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import com.csvreader.CsvReader;


public class ReadFileWriteToConsole {

    private static final String inFile = "in.csv";
    private static String[][] hoja = new String[0][0];

    public static void main(String args[]) throws IOException {
    	// (add code to implement the following)
    	// create a ReadFileWriteToConsole object
    	ReadFileWriteToConsole obj = new ReadFileWriteToConsole();
    	// call method below to read the data from inFile
    	obj.makeSheet();
    	// call method below to write the data to the console
    	obj.writeSheet();
    	// Do not change the signature of this method.
    	return;
    }
	
    public String getCell(int row, int col) {
	// return the value of the spreadsheet at the given row and column
	// Do not change the signature of this method.
    	String contenido = hoja[row][col];
	return contenido; // <-- fix this to return a proper value
    }
	
    public int getRowCount() {
	// return the number of rows in the spreadsheet
	// Do not change the signature of this method.
    	try {
    		int rows = 0, cols = 0;
        	CsvReader csvRC = new CsvReader(inFile);
        	while(csvRC.readRecord()) {
        		for(int c=0; c<=csvRC.getColumnCount(); c++) {
        			cols = csvRC.getColumnCount();
        		}
        		rows++;
        	}
        	csvRC.close();
        	return rows;
		} catch (Exception e) {
			return 0;
			// TODO: handle exception
		}
	// <-- fix this to return a proper value
    }
    
    public int getColCount() {
	// return the number of columns in row
	// Do not change the signature of this method.
    	try {
    		int rows = 0, cols = 0;
        	CsvReader csvRC = new CsvReader(inFile);
        	while(csvRC.readRecord()) {
        		for(int c=0; c<=csvRC.getColumnCount(); c++) {
        			cols = csvRC.getColumnCount();
        		}
        		rows++;
        	}
        	csvRC.close();
        	return cols;
		} catch (Exception e) {
			return 0;
			// TODO: handle exception
		}
    	// <-- fix this to return a proper value
    }
	  
    public void makeSheet() throws IOException {
	// read the data from inFile
    	int rows = getRowCount(), cols = getColCount();
    	hoja = new String[rows][cols];
    	int r=0;
    	
    	CsvReader csvR = new CsvReader(inFile);
    	while(csvR.readRecord()) {
    		for(int c=0; c<csvR.getColumnCount(); c++) {
    			hoja[r][c] = csvR.get(c);
    		}
    		r++;
    	}
    	csvR.close();
	// Do not change the signature of this method.
	return;
    }	
	   
    public void writeSheet() {
	// format data to console
    	int maxRows = getRowCount();
    	int maxCols = getColCount();
    	
    	for(int r=0; r<maxRows; r++) {
    		for(int c=0; c<maxCols; c++) {
    			System.out.print("[" + hoja[r][c] + "]");
    		}
    		System.out.println();
    	}
	// Do not change the signature of this method.
	return;
    }
}
