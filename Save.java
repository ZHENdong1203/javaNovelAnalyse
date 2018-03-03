package Project;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class Save {
	public static String time=null;
	private static HashMap<String,Float> rls=new HashMap<String,Float>();
	private static String[] arr=new String[]{"刘备","曹操","关羽","诸葛亮","张飞",
			"吕布","周瑜","赵云","孙权","魏延"};
	public static void saver(String personname)throws Exception{
	try{
		int ti=FileI.count("D:/三国演义.txt",personname);;
		time=String.valueOf(ti);

		rls=Relation.Relationship2(personname);
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "操作异常");
		}
	PrintStream ps=new PrintStream(new FileOutputStream("d:/result.txt"));
	String msg1="人物：";
	ps.println(msg1+personname+"\n");
	String msg2="出现次数：";
	ps.println(msg2+time+"\n");

	String msg4="人物关系紧密程度：";
	ps.println(msg4);
	HashMap<Float,String> hm=new HashMap<Float,String>();
	float[] aa=new float[10];
	for(int i=0;i<10;i++){
		aa[i]=rls.get(arr[i]);
		hm.put(aa[i], arr[i]);
		}
	Arrays.sort(aa);
	for(float a:aa){
		if(personname!=hm.get(a)){
			ps.println(personname+"与"+hm.get(a)+"的关系紧密程度为"+a);		
	}
	}
	ps.close();
	}
}
