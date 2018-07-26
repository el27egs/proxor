// StatsCsv.java -- add greatest values to spreadsheet
//
// This is NOT a working program. This is a "skeleton" that
// should be modified and extended to meet the specifications.

import java.io.IOException;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;


public class StatsCsv {
    
    private static final int MAXROW = 16;
    private static final int MAXCOL = 16;
    private int rowsUsed = 0;
    private int colsUsed = 0;
    private static final String inFile = "Data01.csv";
    private static final String outFile = "Data02.csv"; 
   
    public String[][] sheet = new String[MAXROW][MAXCOL];
    
    public static void main(String[] args) throws IOException {

        StatsCsv a = new StatsCsv();
        a.readSheet();
        // a.getRows() is the row count before adding medians
        Stats s = new Stats(a.getRows(), a.getCols(), a.getData());
        a.setRows(a.getRows() + 1); // because we added a row of medians
        a.writeSheet();
    }
    
    public void writeSheet() throws IOException {
        // 
        // to be completed
    	//  Do not change the signature of this method.
    	CsvWriter csvrW = new CsvWriter(outFile);
    	for(int r=0; r<rowsUsed; r++) {
    		for(int c=0; c<colsUsed; c++) {
    			csvrW.write(sheet[r][c]);
    		}
    		csvrW.endRecord();
    	}
    	csvrW.close();
    }

    public void readSheet( ) throws IOException {
        // 
        // to be completed
    	//  Do not change the signature of this method.
    	CsvReader csvR = new CsvReader(inFile);
    	int r=0;
    	while(csvR.readRecord()) {
    		for(int c=0; c<csvR.getColumnCount(); c++) {
    			sheet[r][c] = csvR.get(c);
    			colsUsed = c+1;
    		}
    		r++;
    		rowsUsed = r;
    	}
    }

    public int getRows(){
    	return rowsUsed;
    }
    
    public int setRows(int r) {
        rowsUsed = r;
        return rowsUsed;
    }

    public int getCols() {
    	return colsUsed;
    }
    
    public String[][] getData() {
    	return sheet;
    }
}
