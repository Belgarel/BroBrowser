package ressource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CsvRepository {

	ArrayList<String> columns;
	ArrayList<ArrayList<String>> values; //each element of the values ArrayList is a row
	
	public CsvRepository(String filePath) throws IOException {
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);

		columns = new ArrayList<String>();
		values = new ArrayList<ArrayList<String>>();
		
		//Set columns
		String line = br.readLine();
		for (String col : line.split(","))
			columns.add(col);
		
		//fill data
		while (line != null) {
			ArrayList<String> rec = new ArrayList<String>();
			for (String col : line.split(","))
				rec.add(col);
			values.add(rec);
			line = br.readLine();
		}
	}
	
	private int getColumnIndex(String colname) {
		int i = 0;
		while (i < columns.size() && !columns.get(i).equals(colname))
			i++;
		if (i == columns.size())
			i = -1;
		return i;
	}
	private String getField(int colIndex, int rowIndex) {
		if (colIndex > columns.size() || rowIndex > values.size() || colIndex < 0 || rowIndex < 0)
			return null;
		return values.get(rowIndex).get(colIndex);
	}
	/**
	 * Returns the value of a field
	 * @param colname the name of the column
	 * @param rowIndex the rowid
	 * @return the value of a field
	 */
	public String getField(String colname, int rowIndex) {
		return getField(getColumnIndex(colname), rowIndex);
	}
	public int getNumberOfRows() {
		return values.size();
	}
	
	private int getRowIndexForColumnIndex(int colIndex, String colValue) {
		if (colIndex > columns.size() || colIndex < 0)
			return -1;
		int indexRow = 0;
		while (indexRow < values.size() &&
				!values.get(indexRow).get(colIndex).equals(colValue))
			indexRow++;
		if (indexRow == columns.size())
			return -1;
		return indexRow;
	}
	private ArrayList<Integer> getRowsIndexForColumnIndex(int colIndex, String colValue) {
		if (colIndex > columns.size() || colIndex < 0)
			return null;
		ArrayList<Integer> rows = new ArrayList<Integer>();
		int rowid = 0;
		for (ArrayList<String> row : values) {
			if (row.get(colIndex).equals(colValue))
				rows.add(rowid);
			rowid++;
		}
		return rows;
	}

	/**
	 * Returns the index of the first row with the value "colValue" in the column named "colName"
	 * @param colName the name of the column
	 * @param colValue the value of the column
	 * @return index of the first row. If no row found (or invalid colName), returns -1.
	 */
	public int getRowIndexForColumnIndex(String colName, String colValue) {
		return getRowIndexForColumnIndex(getColumnIndex(colName), colValue);
	}
	/**
	 * Returns a list of rowIds with the value "colValue" in the column named "colName"
	 * @param colName the name of the column
	 * @param colValue the value of the column
	 * @return list of rowIds. null if the colName does not exist.
	 */
	public ArrayList<Integer> getRowsIndexForColumnIndex(String colName, String colValue) {
		return getRowsIndexForColumnIndex(getColumnIndex(colName), colValue);
	}
	
	
}
