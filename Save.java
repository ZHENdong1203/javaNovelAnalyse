package Project;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class Save {
	public static String time=null;
	private static HashMap<String,Float> rls=new HashMap<String,Float>();
	private static String[] arr=new String[]{"����","�ܲ�","����","�����","�ŷ�",
			"����","���","����","��Ȩ","κ��"};
	public static void saver(String personname)throws Exception{
	try{
		int ti=FileI.count("D:/��������.txt",personname);;
		time=String.valueOf(ti);

		rls=Relation.Relationship2(personname);
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "�����쳣");
		}
	PrintStream ps=new PrintStream(new FileOutputStream("d:/result.txt"));
	String msg1="���";
	ps.println(msg1+personname+"\n");
	String msg2="���ִ�����";
	ps.println(msg2+time+"\n");

	String msg4="�����ϵ���̶ܳȣ�";
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
			ps.println(personname+"��"+hm.get(a)+"�Ĺ�ϵ���̶ܳ�Ϊ"+a);		
	}
	}
	ps.close();
	}
}
