import java.util.Arrays;
import java.util.Scanner;

public class Stats {
	
		public Stats(int rows, int cols, String[][] hoja) {
			computeMedians(rows, cols, hoja);
			
		};
		public void computeMedians(int rows, int cols, String[][] hoja) {
			Integer[] val = new Integer[rows-1];
			String[] newRow = new String[cols+1];
			for(int c=0; c<cols; c++) {
				for(int r=1; r<rows; r++) {
					if(isNumber(hoja[r][c])) {
						val[r-1] = Integer.parseInt(hoja[r][c]);
					}
					else
						break;
				}
				if(val[0] != null) {
					Arrays.sort(val);
					if(val.length % 2 == 0) {
						double a = (val[(val.length/2)] + val[(val.length/2)-1]);
						double b = Math.round(a/2);
						int f = (int)b;
						newRow[c] = Integer.toString(f);
					}
					else {
						newRow[c] = Integer.toString(val[Math.round(val.length/2)]);
					}
				}
				else {
					newRow[c] = c == 0 ? "" : "Median";
				}
			}
			for(int i=0; i<=cols; i++) {
				hoja[rows][i] = newRow[i];
			}
		}
		
		public Boolean isNumber(String tok) {
			Scanner scnr = new Scanner(tok);
			if(scnr.hasNextDouble()) {
				scnr.close();
				return true;
			}
			else {
				scnr.close();
				return false;
			}
		}	
}
