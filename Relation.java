package Project;
import java.util.*; 
public class Relation {
	private static float[] rs=new float[10];
	private static HashMap<String,Float> rls=new HashMap<String,Float>();
	private static String[] arr=new String[]{"¡ı±∏","≤‹≤Ÿ","πÿ”","÷Ó∏¡¡","’≈∑…",
			"¬¿≤º","÷‹Ë§","’‘‘∆","ÀÔ»®","Œ∫—”"};
	public static float Relationship1(String name1,String name2)throws Exception{
		byte[] data=FileI.getData();
		String dataStr=new String(data);
		int score=0;
		int length1=0;
		int length2=1000;
		for(;(length2<dataStr.length());length1+=1000,length2+=1000){
			for(int i=length1;i<length2-name1.length()-1;i++){
			String s1=dataStr.substring(i,i+name1.length()).toString();
				for(int j=length1;(s1.equals(name1))&&(j<length2-name2.length()-1);j++){
					String s2=dataStr.substring(j,j+name2.length()).toString();
					if(s2.equals(name2)){
					score++; break;
					}
					}
				}
			}
		float rs=(float)score/100;
		return rs;
	}
	public static HashMap<String,Float> Relationship2(String name)throws Exception{
		for(int i=0;i<10;i++){
			rs[i]=Relationship1(name,arr[i]);
			rls.put(arr[i],rs[i]);
		}
		return rls;
	}
}
