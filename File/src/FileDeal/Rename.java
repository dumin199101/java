package FileDeal;

import java.io.File;

public class Rename {
	 
	public static void main(String[] args) {
		
		File srcFolder = new File("E:\\wamp\\www\\test\\product_update\\lhh\\Public\\Mpr\\Book\\MPR_CN\\1587");
		
		File[] fileArr = srcFolder.listFiles();
		
		for(File f : fileArr){
			
			if(f.getName().endsWith(".bk")){
				
//				System.out.println(f.getName());
				
				int index = f.getName().lastIndexOf('.');
				
				String newName = f.getName().substring(0, index);
				
//				System.out.println(newName);
				
				File newFile = new File(srcFolder,newName);
				
				System.out.println(newFile.getName() + "-----" + f.renameTo(newFile));
				
			}
			
//			System.out.println(f.getName());
			
			if(f.getName().startsWith("0")){
				
//				System.out.println(f.getName());
				
				String newName = f.getName().substring(1);
				
				String[] s = newName.split(".jpg");
				
		        int i = Integer.parseInt(s[0]);
		        
		        i = i+1;
		        
		        String string = String.valueOf(i).concat("bak.jpg");
		        
		        File newFile = new File(srcFolder, string);
		        
		        System.out.println(newFile.getName() + "-----" + f.renameTo(newFile));
		        
//		        System.out.println(string);
				
//				System.out.println(newName);
				
//				File newFile = new File(srcFolder,newName);
				
			}
			
			
			
//			String[] s = f.getName().split(".jpg");
//			
//			int i = Integer.parseInt(s[0]);
//			
//			i = i-9;
//			
//			String string = String.valueOf(i).concat("bak.jpg");
//			
//			File newFile = new File(srcFolder, string);
//	        
//	        System.out.println(newFile.getName() + "-----" + f.renameTo(newFile));
			
			String[] s = f.getName().split("bak.jpg");
			
			int i = Integer.parseInt(s[0]);
			
			String string = String.valueOf(i).concat(".jpg");
			
			File newFile = new File(srcFolder, string);
			
			System.out.println(newFile.getName() + "-----" + f.renameTo(newFile));
			
		}
		
		
	}

}
