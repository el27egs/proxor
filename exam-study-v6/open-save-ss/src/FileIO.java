
// FileIOBase.java -- template for FileIO.java.
//
// this file should be modified to implement
// open, save, and save as... commands for SpreadSheet.java
// 
// Do not modify the signatures of these methods.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class FileIO {
	public static boolean open(SpreadSheet ss, File file) {
		System.out.println("Open " + file);
		
		try {
			CsvReader read = new CsvReader(file.toString());
			String[] temp;
			int row = 0;
			while (read.readRecord()) {
				temp = read.getValues();
				for (int y = 0; y < read.getColumnCount(); y++) {
					ss.setCell(row, y, temp[y]);
					// System.out.println("row="+row+"col"+y+"temp y ="+temp[y]);
				}
				row++;
			}
			//Sacado de la prueba unitaria, sin esta linea no funciona
			ss.evaluate();
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;

	}

	public static boolean saveAs(SpreadSheet ss, File file) {
		System.out.println("SaveAs " + file);
		
		CsvWriter writer = new CsvWriter(file.toString());
		try {

			for (int r = 0; r < ss.maxRows; r++) {
				for (int c = 0; c < ss.maxCols; c++) {
					writer.write(ss.getCellFormula(r, c));
				}
				writer.endRecord();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}

		return true;
	}

}
