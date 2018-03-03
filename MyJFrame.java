package Project;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
public class MyJFrame extends JFrame implements ActionListener,ItemListener{
private JLabel jbl=new JLabel("三国演义");
private JLabel func=new JLabel("功能");
private JPanel jpl=new JPanel();
private JComboBox jcb=new JComboBox();
private BorderLayout bl=new BorderLayout(10,10);
private JButton jbt1=new JButton("出现次数排序");
private JButton jbt2=new JButton("密度排序");
private JButton jbt3=new JButton("输出密度图");
private JTextArea jta=new JTextArea(30,30);
private JTextArea jta1=new JTextArea(30,30);
private static String personName=null;
private static String[] arr1=new String[] {"刘备","曹操","关羽","诸葛亮","张飞",
		"吕布","周瑜","赵云","孙权","魏延"};
private static String[] arr7=new String[] {"玄德","孟德","云长","孔明","翼德",
		"奉先","公瑾","子龙","仲谋","文长"};
private static String[] arr8=new String[] {"刘玄德","曹孟德","关云长","诸葛孔明","张翼德",
		"吕奉先","周公瑾","赵子龙","孙仲谋","魏文长"};
private Font font=new Font("楷体_GB2312",Font.BOLD,20);
private Font font1=new Font("黑体",Font.BOLD,20);
public JPanel createWest() {
	JPanel west=new JPanel();
	west.setLayout(new GridLayout(6,1,5,5));
	west.add(jcb);
	jcb.addItem("请选择人物:");
	jcb.addItem("刘备");
	jcb.addItem("曹操");
	jcb.addItem("关羽");
	jcb.addItem("诸葛亮");
	jcb.addItem("张飞");
	jcb.addItem("吕布");
	jcb.addItem("周瑜");
	jcb.addItem("赵云"); 
	jcb.addItem("孙权");
	jcb.addItem("魏延");
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
	this.setTitle("实验");
	this.setSize(900, 600);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
public void itemStateChanged(ItemEvent e){
	if(e.getStateChange()==ItemEvent.SELECTED){
		switch((String)e.getItem()){
		case "刘备":
			personName="刘备"; break;
		case "曹操":
			personName="曹操"; break;
		case "关羽":	
			personName="关羽"; break;
		case "诸葛亮":
			personName="诸葛亮"; break;
		case "张飞":
			personName="张飞"; break;
		case "吕布":	
			personName="吕布"; break;
		case "周瑜":	
			personName="周瑜"; break;
		case "赵云":	
			personName="赵云"; break;
		case "孙权":
			personName="孙权"; break;
		case "魏延":
			personName="魏延"; break;
			}
		try {
			Save.saver(personName);
			File file=new File("d:/result.txt");
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
            jta1.setText("以下是结果；\n");
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
		  a=FileI.count("D:/三国演义.txt", "刘备")+
				  FileI.count("D:/三国演义.txt", "玄德")+
				  FileI.count("D:/三国演义.txt", "刘玄德") ; 
		  b=FileI.count("D:/三国演义.txt", "曹操")+
				  FileI.count("D:/三国演义.txt", "孟德")+
				  FileI.count("D:/三国演义.txt", "曹孟德") ;
		  c=FileI.count("D:/三国演义.txt", "关羽")+
				  FileI.count("D:/三国演义.txt", "云长")+
				  FileI.count("D:/三国演义.txt", "关云长");
		  d=FileI.count("D:/三国演义.txt", "诸葛亮")+
				  FileI.count("D:/三国演义.txt", "孔明")+
				  FileI.count("D:/三国演义.txt", "诸葛孔明") ;
		  e=FileI.count("D:/三国演义.txt", "张飞")+
				  FileI.count("D:/三国演义.txt", "翼德")+
				  FileI.count("D:/三国演义.txt", "张翼德") ;
		  f=FileI.count("D:/三国演义.txt", "吕布")+
				  FileI.count("D:/三国演义.txt", "奉先")+
				  FileI.count("D:/三国演义.txt", "吕奉先") ;
		  g=FileI.count("D:/三国演义.txt", "周瑜")+
				  FileI.count("D:/三国演义.txt", "公瑾")+
				  FileI.count("D:/三国演义.txt", "周公瑾") ;
		  h=FileI.count("D:/三国演义.txt", "赵云")+
				  FileI.count("D:/三国演义.txt", "子龙")+
				  FileI.count("D:/三国演义.txt", "赵子龙") ;
		  i=FileI.count("D:/三国演义.txt", "孙权")+
				  FileI.count("D:/三国演义.txt", "仲谋")+
				  FileI.count("D:/三国演义.txt", "孙仲谋") ;
		  j=FileI.count("D:/三国演义.txt", "魏延")+
				  FileI.count("D:/三国演义.txt", "文长")+
				  FileI.count("D:/三国演义.txt", "魏文长") ;
		  TreeMap tm=new TreeMap();
			 tm.put(a, "刘备");
			 tm.put(b,"曹操");
			 tm.put(c, "关羽");
			 tm.put(d, "诸葛亮");
			 tm.put(e, "张飞");
			 tm.put(f, "吕布");
			 tm.put(g, "周瑜");
			 tm.put(h, "赵云");
			 tm.put(i, "孙权");
			 tm.put(j, "魏延");
			 Set keySet=tm.keySet();
			 jta.setText("以下是结果：\n");
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
		jta.setText("以下是结果：\n");
		for(float a:arr6){
			jta.append(hm.get(a)+"的密度为:"+a+"\n");
			}
	}else if(ac.getSource()==jbt3) {
		MyGraph planeHistogram = new MyGraph(); 
        BufferedImage image = planeHistogram.paintPlaneHistogram("密度直方图",  
                        new int[]{95,59,90,85,78,57,58,84,70,40}, 
                        new String[]{"刘备","曹操","关羽","诸葛亮","张飞",
                        		"吕布","周瑜","赵云","孙权","魏延"} ,  
                        new Color[] {Color.BLACK,Color.RED, Color.GRAY, Color.LIGHT_GRAY ,Color.CYAN,Color.MAGENTA, Color.PINK
                                      , Color.BLUE, Color.GREEN ,Color.ORANGE});  
        File output = new File("d:/密度图.jpg");  
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

