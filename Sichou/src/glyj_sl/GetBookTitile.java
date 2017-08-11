package glyj_sl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GetBookTitile {
    public static void main(String[] args) {
//		getBookTitleInfo();
    	getBookPagesInfo();
	}

    
    /**
     * 获取图书页数
     */
    private static void getBookPagesInfo() {
		// TODO Auto-generated method stub
    	File srcFolder = new File("J:\\新疆丝绸之路西域史料文献辑要数据库加工数据\\Resource_Img\\古代卷(241)");
		try {
			getBookPages(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getBookPages(File srcFolder) throws IOException{
		// TODO Auto-generated method stub
		File[] fileArr = srcFolder.listFiles();
		int fileCount = 0;
		if(fileArr!=null){
		    for(File file : fileArr){
		    	if(file.isDirectory()){
		    		getBookPages(file);
		    	}else{
		    		fileCount++;
		    	}
		    }	
		}
		if(!srcFolder.getName().contains("古代卷"))
			System.out.println(srcFolder.getName().substring(3)+"\t"+fileCount);
	}


	/**
     * 获取图书标题
     */
	private static void getBookTitleInfo() {
		File srcFolder = new File("J:\\新疆丝绸之路西域史料文献辑要数据库加工数据\\成本PDF\\古代卷(241)");
		try {
			getyBookTitle(srcFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getyBookTitle(File srcFolder) throws IOException {
		// TODO Auto-generated method stub
		File[] fileArr  = srcFolder.listFiles();
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\古代卷（241）Title.txt"));
		for(File file : fileArr){
			 int pos = file.getName().lastIndexOf(".pdf");
		     bw.write(file.getName().substring(3,pos)+"\t");
		     bw.newLine();
		     bw.flush();
		}
		bw.close();
	}
	
   
}
