import java.util.Arrays;
import java.util.Scanner;

public class Stats {
	public Stats(int rows, int cols, String[][] hoja) {
		greatestValue(rows, cols, hoja);
		
	};
	public void greatestValue(int rows, int cols, String[][] hoja) {
		Integer[] val = new Integer[rows-1];
		String[] newRow = new String[cols+1];
		for(int c=0; c<=cols; c++) {
			for(int r=1; r<rows; r++) {
				if(isNumber(hoja[r][c])) {
					val[r-1] = Integer.parseInt(hoja[r][c]);
				}
				else
					break;
			}
			if(val[0] != null) {
				Arrays.sort(val);
				 newRow[c] = Integer.toString(val[val.length -1]);
			}
			else {
				newRow[c] = c == 0 ? "Greatest" : "Value";
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
