package utilities;


	import java.io.File;
import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.FillPatternType;
	import org.apache.poi.ss.usermodel.IndexedColors;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtils {
		
		//classes to be used 
		public static FileInputStream fi;
		public static FileOutputStream fo;
		public static XSSFWorkbook wb;
		public static XSSFSheet ws;
		public static XSSFRow row;
		public static XSSFCell cell;
		public static CellStyle style; //adding colors to cells
		String path;
		
	//Constructor - now we do not need to xl sheet path , we are capturing here in constructor
		public ExcelUtils(String path)
		{
			this.path = path;
		}
		
		public int getRowCount(String sheetName) throws IOException  //excel file path and sheet name 
		{
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(sheetName);
			int rowcount = ws.getLastRowNum();
			wb.close();
			fi.close();
			return rowcount;
		}
		
		public int getCellCount(String sheetName, int rownum) throws IOException
		{
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(sheetName);
			row = ws.getRow(rownum);
			int cellcount = row.getLastCellNum();
			wb.close();
			fi.close();
			return cellcount;
		}

		//we will put this method in looping statem,nt so that it reads data from each cell by passing diff row and col num
		public String getCellData(String sheetName, int rownum, int colnum) throws IOException
		{
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(sheetName);
			row = ws.getRow(rownum);
			cell= row.getCell(colnum);
			
			DataFormatter  formatter = new DataFormatter(); //a class 
			String data; 
			//why try catch block coz cell.toString() or data formatter  will throw an exception in case cell is empty
			try
			{
				//data = cell.toString(); //either of them
             data = formatter.formatCellValue(cell); // returns a formatted value of cell as a string regardless  of its value
			}
			catch(Exception e)
			{
				data = "";
			}
			wb.close();
			fi.close();
			return data;
			
		}
			
			public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException
			{
				File xlfile = new File(path); 
				if(!xlfile.exists())          //if file doesnt exists then create a new file
				{
					wb= new XSSFWorkbook();
					fo= new FileOutputStream(path);
					wb.write(fo);
				}
				
				//combination of reading and writing , why coz in ddt, you have some columns , in last column its empty ,we have to update the results after exceution is completed  
				fi = new FileInputStream(path); // opening the file
				wb= new XSSFWorkbook(fi);
				
				if(wb.getSheetIndex(sheetName)==-1)//if sheet does not exists then craete new sheet
					wb.createSheet(sheetName);
				    ws= wb.getSheet(sheetName);
				
			    if(ws.getRow(rownum)==null) //if row doesnt exixts then create row
				   ws.createRow(rownum);
			    row= ws.getRow(rownum);
				
				ws = wb.getSheet(sheetName);
				row = ws.getRow(rownum); //getting the row
				//new row we are not creating , creating new cell in existing row
				cell = row.createCell(colnum); //creating a new cell in the row
				cell.setCellValue(data); //updating the cell value
				fo= new FileOutputStream(path); // all changes we write back to same xlsheet
				wb.write(fo);
				wb.close();
				fi.close();
				fo.close();
			}
			
			
			public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException
			{
				fi = new FileInputStream(path);
				wb = new XSSFWorkbook(fi);
				ws = wb.getSheet(sheetName);
				row = ws.getRow(rownum);
				cell = row.getCell(colnum);
				
				style = wb.createCellStyle();
				style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				
				cell.setCellStyle(style);
				fo = new FileOutputStream(path);
				wb.close();
				fi.close();
				fo.close();
			}
			
			public void FillRedColor(String sheetName, int rownum, int colnum) throws IOException
			{
				fi = new FileInputStream(path);
				wb = new XSSFWorkbook(fi);
				ws = wb.getSheet(sheetName);
				row = ws.getRow(rownum);
				cell = row.getCell(colnum);
				
				style = wb.createCellStyle();
				style.setFillBackgroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				
				fo = new FileOutputStream(path);
				wb.close();
				fi.close();
				fo.close();
				
			}
		}


