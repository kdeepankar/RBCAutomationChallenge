package com.demo.automation.utilities;

import java.io.*;
import java.text.*;
import java.util.*;

public class MyLogger {
	protected static String defaultLogFile = "log.txt";
	protected static String defaultHTMLReportFile = "AutomationResults.html";

	public static void write(String s, boolean addToReport, boolean stepResult) throws IOException {
		write(defaultLogFile, s);
		if (addToReport) {
			writeHTML(defaultHTMLReportFile, s, stepResult);
		} else {
			// no logging
		}
	}

	public static void write(String f, String s) throws IOException {
		TimeZone tz = TimeZone.getTimeZone("EST"); // or PST, MID, etc ...
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy.mm.dd hh:mm:ss ");
		df.setTimeZone(tz);
		String currentTime = df.format(now);

		FileWriter aWriter = new FileWriter(f, true);
		String message = currentTime + " " + s + System.lineSeparator();
		System.out.println(message); // print to console
		aWriter.write(message); // print to files
		aWriter.flush();
		aWriter.close();
	}

	public static void writeHTML(String f, String s, boolean stepResult) throws IOException {
		FileWriter aWriter = new FileWriter(f, true);
		String message = "<span>" + s + "&nbsp;&nbsp;" + "<span style='color:"
				+ ((stepResult == true) ? "green" : "red") + ";'><b>" + stepResult + "</b></span>" + "</span><br>";
		aWriter.write(message); // print to files
		aWriter.flush();
		aWriter.close();
	}

	public static void initiateHTMLReporting() {
		try {
			FileWriter aWriter = new FileWriter(defaultHTMLReportFile, true);
			String message = "<!document><html><body>" + "<h1>Magic Mouse Automation testing</h1>" + "<hr>";
			aWriter.write(message); // print to files
			aWriter.flush();
			aWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void endHTMLReporting() {
		try {
			FileWriter aWriter = new FileWriter(defaultHTMLReportFile, true);
			String message = "</body></html>";
			aWriter.write(message); // print to files
			aWriter.flush();
			aWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String args[]) throws IOException { MyLogger log =
	 * new MyLogger(); log.write("Deepay Relax bro"); }
	 */
}