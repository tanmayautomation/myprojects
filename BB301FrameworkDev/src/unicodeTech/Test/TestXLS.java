package unicodeTech.Test;

import com.unicodetechnologies.xlsConnectivity.XLSDatatable_Connectivity;

public class TestXLS {

	public static void main(String[] args) {

		XLSDatatable_Connectivity data = new XLSDatatable_Connectivity(System.getProperty("user.dir")+"\\src\\unicodeTech\\XLSFiles\\TestSuite.xlsx");
		
		System.out.println(data.totalColumn("TestSuite"));
		System.out.println(data.totalRow("TestSuite"));

		System.out.println(data.getData("TestSuite", 1, 3));
		
		System.out.println(data.getData("TestSuite", "Execution", 2));
	
		System.out.println("**************************************");
	
		int rows = data.totalRow("TestSuite");
		int cols = data.totalColumn("TestSuite");
		
		for(int row=2;row<=rows;row++) {
			
			for(int col=0;col<cols;col++) {
				
				System.out.println(data.getData("TestSuite", col, row));
				System.out.println(data.getData("TestSuite", "Execution", row));
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

	
	
}
