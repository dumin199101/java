package glyj_paper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
     public static void main(String[] args) {
//    	   testDateFormat();
//		formatQZDate();
    	 formatBLDate();
		System.out.println("数据写入成功");
		
	 }

	private static void formatBLDate() {
		try {
 			BufferedReader br = new BufferedReader(new FileReader("D:\\八路军军政基本信息.txt"));
 		    String line = null;
 		    while((line = br.readLine())!=null){
 		    	 String[] data = line.split("\\t");
 		    	 int beginIndex = data[7].indexOf('-');
 		    	 int endIndex = data[7].lastIndexOf('-');
 		    	 int year = Integer.parseInt(data[7].substring(0,4));
 		    	 int month = Integer.parseInt(data[7].substring(beginIndex+1,endIndex));
 		    	 int day = Integer.parseInt(data[7].substring(endIndex+1));
 		    	 Date d = new Date(year-1900,month-1,day);
 		    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		    	 int year_mg = year - 1911;
 		    	 String mg_date = "民国"+year_mg+"年"+month+"月"+day+"日";
 		    	 String date_str = year+"年"+month+"月";
// 		    	 System.out.println(data[2]+"\t"+sdf.format(d)+"\t"+mg_date+"\t"+date_str);
 		    	 String result =data[2]+"\t"+sdf.format(d)+"\t"+mg_date+"\t"+date_str;
 		    	 writeTitleToLog("D:\\BL_Date.txt", result);	 
 		    }
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
	}

	private static void formatQZDate() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:\\群众周刊日期信息.txt"));
		    String line = null;
		    while((line = br.readLine())!=null){
		    	 String[] data = line.split("\\t");
		    	 int beginIndex = data[1].indexOf('-');
		    	 int endIndex = data[1].lastIndexOf('-');
		    	 int year = Integer.parseInt(data[1].substring(0,4));
		    	 int month = Integer.parseInt(data[1].substring(beginIndex+1,endIndex));
		    	 int day = Integer.parseInt(data[1].substring(endIndex+1));
		    	 Date d = new Date(year-1900,month-1,day);
		    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    	 int year_mg = year - 1911;
		    	 String month_str = month<=9 ? "0" + month : Integer.toString(month); 
		    	 String day_str = day<=9 ? "0"+day : Integer.toString(day);
		    	 String mg_date = "民国"+year_mg+"年"+month_str+"月"+day_str+"日";
		    	 String date_str = year+"年"+month_str+"月";
//		    	 System.out.println(data[0]+"\t"+data[1]+"\t"+sdf.format(d)+"\t"+mg_date+"\t"+date_str);
		    	 String result =data[0]+"\t"+data[1]+"\t"+sdf.format(d)+"\t"+mg_date+"\t"+date_str;
		    	 writeTitleToLog("D:\\QZ_Date.txt", result);	 
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     
     private static void writeTitleToLog(String fileName, String result)
 			throws IOException {
 		// TODO Auto-generated method stub
 		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
 		bw.write(result);
 		bw.newLine();
 		bw.flush();
 		bw.close();
 	}

	private static void testDateFormat() {
		// TODO Auto-generated method stub
	       Date d = new Date(38,0,15);
	       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	       System.out.println(sdf.format(d));
	}
     
     
}
