package com.demo.automation.utilities;

import java.util.ArrayList;

public class DataEntry {

	static XlsxReader reader;

	public static ArrayList<Object[]> getData(String dataFilePath) {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		try {

			reader = new XlsxReader(dataFilePath);

		} catch (Exception e) {
			System.out.println("file xlsx reader not found");
			e.printStackTrace();
		}

		for (int rowNum = 2; rowNum <= reader.getRowCount("Data"); rowNum++) {

			String email = reader.getCellData("Data", "email", rowNum);
			String b_fname = reader.getCellData("Data", "b_fname", rowNum);
			String b_lname = reader.getCellData("Data", "b_lname", rowNum);
			String b_address = reader.getCellData("Data", "b_address", rowNum);
			String b_city = reader.getCellData("Data", "b_city", rowNum);
			String b_state = reader.getCellData("Data", "b_state", rowNum);
			String b_country = reader.getCellData("Data", "b_country", rowNum);
			String b_postalcode = reader.getCellData("Data", "b_postalcode", rowNum);
			String b_phone = reader.getCellData("Data", "b_phone", rowNum);
			String s_check = reader.getCellData("Data", "s_check", rowNum);

			Object obj[] = { email, b_fname, b_lname, b_address, b_city, b_state, b_country, b_postalcode, b_phone,
					s_check };

			myData.add(obj);
		}

		return myData;
	}
}
