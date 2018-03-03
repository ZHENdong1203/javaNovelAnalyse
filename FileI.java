package Project;
import java.io.*;
public class FileI {
	public static byte[] getData()throws Exception{          
		File novel=new File("D:/Èý¹úÑÝÒå.txt");
		FileInputStream fis=new FileInputStream(novel);
		byte[] data=new byte[(int)novel.length()];
		fis.read(data);
		fis.close();
		return data;
}
	public static int count(String filename, String target) throws Exception { 
			  FileReader fr = new FileReader(filename); 
			  BufferedReader br = new BufferedReader(fr); 
			  StringBuilder strb = new StringBuilder(); 
			  while (true) { 
			  String line = br.readLine(); 
			  if (line == null) { 
			   break; 
			  } 
			  strb.append(line); 
			  } 
			  String result = strb.toString(); 
			  int count = 0; 
			  int index = 0; 
			  while (true) { 
			  index = result.indexOf(target, index + 1); 
			  if (index > 0) { 
			   count++; 
			  } else { 
			   break; 
			  } 
			  } 
			  br.close(); 
			  return count; 
			 }
}
