package Project;
import java.util.HashMap;
public class Density {
	public static float Span(String name)throws Exception{      
		byte[] data=FileI.getData();
		float density;
		HashMap<String,Integer> hm1=new HashMap<String,Integer>();
		HashMap<String,Integer> hm2=new HashMap<String,Integer>();
		HashMap<String,Integer> hm3=new HashMap<String,Integer>();
 		String dataStr=new String(data);
		int time=0;
		for(int i=0;i<dataStr.length()-name.length()-1;i++){
			String s3 =dataStr.substring(i,i+name.length()).toString();
			if(s3.equals(name)){
				time++;
				if(time==1){
					hm1.put(name,i);
				}
				hm2.put(name, i);				
			}
		}
		hm3.put(name, (hm2.get(name)-hm1.get(name)));
		density=((float)hm3.get(name)/(float)dataStr.length());
		return (density*100);
	}

}
