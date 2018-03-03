package Project;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
public class MyJFrame extends JFrame implements ActionListener,ItemListener{
private JLabel jbl=new JLabel("��������");
private JLabel func=new JLabel("����");
private JPanel jpl=new JPanel();
private JComboBox jcb=new JComboBox();
private BorderLayout bl=new BorderLayout(10,10);
private JButton jbt1=new JButton("���ִ�������");
private JButton jbt2=new JButton("�ܶ�����");
private JButton jbt3=new JButton("����ܶ�ͼ");
private JTextArea jta=new JTextArea(30,30);
private JTextArea jta1=new JTextArea(30,30);
private static String personName=null;
private static String[] arr1=new String[] {"����","�ܲ�","����","�����","�ŷ�",
		"����","���","����","��Ȩ","κ��"};
private static String[] arr7=new String[] {"����","�ϵ�","�Ƴ�","����","���",
		"����","���","����","��ı","�ĳ�"};
private static String[] arr8=new String[] {"������","���ϵ�","���Ƴ�","������","�����",
		"������","�ܹ��","������","����ı","κ�ĳ�"};
private Font font=new Font("����_GB2312",Font.BOLD,20);
private Font font1=new Font("����",Font.BOLD,20);
public JPanel createWest() {
	JPanel west=new JPanel();
	west.setLayout(new GridLayout(6,1,5,5));
	west.add(jcb);
	jcb.addItem("��ѡ������:");
	jcb.addItem("����");
	jcb.addItem("�ܲ�");
	jcb.addItem("����");
	jcb.addItem("�����");
	jcb.addItem("�ŷ�");
	jcb.addItem("����");
	jcb.addItem("���");
	jcb.addItem("����"); 
	jcb.addItem("��Ȩ");
	jcb.addItem("κ��");
	west.add(func);
	west.add(jbt1);
	west.add(jbt2);
	west.add(jbt3);
	return west;
}
public JPanel createWest1() {
	JPanel west1=new JPanel();
	west1.setLayout(new FlowLayout());
	west1.add(createWest());
	return west1;
}
public JPanel createNorth() {
	JPanel north=new JPanel();
	north.setLayout(new FlowLayout(FlowLayout.CENTER));
	north.add(jbl);
	return north;
}
public JPanel createCenter() {
	JPanel center=new JPanel();
	center.add(jta);
	return center;
}
public JPanel createEast() {
	JPanel east=new JPanel();
	east.add(jta1);
	return east;
}
public MyJFrame() {
	this.add(jpl);
	jpl.setLayout(bl);
	jpl.add(createWest1(),BorderLayout.WEST);
	jpl.add(createNorth(),BorderLayout.NORTH);
	jpl.add(createCenter(),BorderLayout.CENTER);
	jpl.add(createEast(),BorderLayout.EAST);
	jta.setFont(font);
	jta1.setFont(font);
	jbt1.setFont(font1);
	jbt2.setFont(font1);
	jbt3.setFont(font1);
	jbl.setFont(font);
	func.setFont(font);
	jpl.setBackground(Color.blue);	
	jbt1.addActionListener(this);
	jbt2.addActionListener(this);
	jbt3.addActionListener(this);
	jcb.addItemListener(this);
	this.setTitle("ʵ��");
	this.setSize(900, 600);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
public void itemStateChanged(ItemEvent e){
	if(e.getStateChange()==ItemEvent.SELECTED){
		switch((String)e.getItem()){
		case "����":
			personName="����"; break;
		case "�ܲ�":
			personName="�ܲ�"; break;
		case "����":	
			personName="����"; break;
		case "�����":
			personName="�����"; break;
		case "�ŷ�":
			personName="�ŷ�"; break;
		case "����":	
			personName="����"; break;
		case "���":	
			personName="���"; break;
		case "����":	
			personName="����"; break;
		case "��Ȩ":
			personName="��Ȩ"; break;
		case "κ��":
			personName="κ��"; break;
			}
		try {
			Save.saver(personName);
			File file=new File("d:/result.txt");
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
            jta1.setText("�����ǽ����\n");
			while(true){
				String msg=br.readLine();
				if(msg==null) {
					break;
					}
					jta1.append(msg+"\n");
			}
			fr.close();
			br.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}		
	}
}

public void actionPerformed(ActionEvent ac) {
	if(ac.getSource()==jbt1) {
	try { 
		 int a,b,c,d,e,f,g,h,i,j;
		  a=FileI.count("D:/��������.txt", "����")+
				  FileI.count("D:/��������.txt", "����")+
				  FileI.count("D:/��������.txt", "������") ; 
		  b=FileI.count("D:/��������.txt", "�ܲ�")+
				  FileI.count("D:/��������.txt", "�ϵ�")+
				  FileI.count("D:/��������.txt", "���ϵ�") ;
		  c=FileI.count("D:/��������.txt", "����")+
				  FileI.count("D:/��������.txt", "�Ƴ�")+
				  FileI.count("D:/��������.txt", "���Ƴ�");
		  d=FileI.count("D:/��������.txt", "�����")+
				  FileI.count("D:/��������.txt", "����")+
				  FileI.count("D:/��������.txt", "������") ;
		  e=FileI.count("D:/��������.txt", "�ŷ�")+
				  FileI.count("D:/��������.txt", "���")+
				  FileI.count("D:/��������.txt", "�����") ;
		  f=FileI.count("D:/��������.txt", "����")+
				  FileI.count("D:/��������.txt", "����")+
				  FileI.count("D:/��������.txt", "������") ;
		  g=FileI.count("D:/��������.txt", "���")+
				  FileI.count("D:/��������.txt", "���")+
				  FileI.count("D:/��������.txt", "�ܹ��") ;
		  h=FileI.count("D:/��������.txt", "����")+
				  FileI.count("D:/��������.txt", "����")+
				  FileI.count("D:/��������.txt", "������") ;
		  i=FileI.count("D:/��������.txt", "��Ȩ")+
				  FileI.count("D:/��������.txt", "��ı")+
				  FileI.count("D:/��������.txt", "����ı") ;
		  j=FileI.count("D:/��������.txt", "κ��")+
				  FileI.count("D:/��������.txt", "�ĳ�")+
				  FileI.count("D:/��������.txt", "κ�ĳ�") ;
		  TreeMap tm=new TreeMap();
			 tm.put(a, "����");
			 tm.put(b,"�ܲ�");
			 tm.put(c, "����");
			 tm.put(d, "�����");
			 tm.put(e, "�ŷ�");
			 tm.put(f, "����");
			 tm.put(g, "���");
			 tm.put(h, "����");
			 tm.put(i, "��Ȩ");
			 tm.put(j, "κ��");
			 Set keySet=tm.keySet();
			 jta.setText("�����ǽ����\n");
			 for(Object key:keySet) {
				 jta.append(tm.get(key)+"->"+key+"  "+"\n");
			 }
		  } catch (Exception ex) {}
	}else if(ac.getSource()==jbt2){
		int i;
		float[] arr3=new float[10];
		float[] arr4=new float[10];
		float[] arr5=new float[10];
		float[] arr6=new float[10];
		HashMap<Float,String> hm=new HashMap<Float,String>();
		for(i=0;i<10;i++){
			try {
			arr3[i]=Density.Span(arr1[i]);
			arr4[i]=Density.Span(arr7[i]);
			arr5[i]=Density.Span(arr8[i]);
			arr6[i]=(arr3[i]+arr4[i]+arr5[i])/3;
			hm.put(arr6[i],arr1[i]);
			}catch (Exception e1) {}
		}
		Arrays.sort(arr6);
		jta.setText("�����ǽ����\n");
		for(float a:arr6){
			jta.append(hm.get(a)+"���ܶ�Ϊ:"+a+"\n");
			}
	}else if(ac.getSource()==jbt3) {
		MyGraph planeHistogram = new MyGraph(); 
        BufferedImage image = planeHistogram.paintPlaneHistogram("�ܶ�ֱ��ͼ",  
                        new int[]{95,59,90,85,78,57,58,84,70,40}, 
                        new String[]{"����","�ܲ�","����","�����","�ŷ�",
                        		"����","���","����","��Ȩ","κ��"} ,  
                        new Color[] {Color.BLACK,Color.RED, Color.GRAY, Color.LIGHT_GRAY ,Color.CYAN,Color.MAGENTA, Color.PINK
                                      , Color.BLUE, Color.GREEN ,Color.ORANGE});  
        File output = new File("d:/�ܶ�ͼ.jpg");  
        try {  
            ImageIO.write(image, "jpg", output);  
        } catch (Exception e) {}
	}else {
		System.exit(0);
	}
	
}
public static void main(String[] args) {
	MyJFrame mj=new MyJFrame();
}
}

