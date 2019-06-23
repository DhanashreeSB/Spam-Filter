package Server;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Client.HomeC;
import naive_bayes.CLassifierEvaluator;
import naive_bayes.NaiveBayesClassifier;

public class ServerSide extends JFrame implements ActionListener,Runnable{
	//JPanel jp=new JPanel();
	JTextArea a;
	JTextArea sub;
	JButton send;
	JButton back;
	JLabel l1;
	JLabel l2;
	ServerSocket ss;
	Socket s1;
	Thread t;
	private BufferedWriter writer;
	BufferedReader reade;
	FileWriter fw;
	JLabel sub1;
	JLabel mail;
	JLabel subim;
	JLabel mailim;
	static String st3;
   // FileWriter fw1;
	//int r;
	int max=0;
private StringTokenizer st4;
	public  ServerSide() throws UnknownHostException, IOException
		{
			 //setSize(700, 700);
			 setLayout(null);
			 pack();
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 setTitle("Registration Form in Java");
			 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			  setSize(screenSize.width, screenSize.height);

			  setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E://Study_Stuff//spam_mail//p5.jpg")))));
			a=new JTextArea();
			send=new JButton("send");
			back=new JButton("back");
			//l1=new JLabel("Hi");
			l2=new JLabel("");
			sub=new JTextArea();
			sub1=new JLabel("SUBJECT  :");
			mail=new JLabel("ENTER YOUR MESSAGE");
			//subim=new JLabel(new ImageIcon("D://spam_mail//yah1.png"));
			//mailim=new JLabel(new ImageIcon("D://spam_mail//mail1.png"));
			
			//subim.setBounds(10,50,30,30);
			sub1.setForeground(Color.white);
			mail.setForeground(Color.white);
			sub1.setFont(new Font("constantia",Font.BOLD,15));
			mail.setFont(new Font("constantia",Font.BOLD,15));
			send.setFont(new Font("constantia",Font.BOLD,15));
			send.setForeground(Color.white);
			send.setBackground(new Color(0,102,255));
			back.setFont(new Font("constantia",Font.BOLD,15));
			back.setForeground(Color.white);
			back.setBackground(new Color(0,102,255));
			sub1.setBounds(20,50,100,30);
			sub.setBounds(20,90,800,30);
			//mailim.setBounds(10,130,30,30);
			mail.setBounds(20,130,800,30);
			a.setBounds(20,170,800,400);
			send.setBounds(20, 600, 100,25 );
			back.setBounds(20,650,100,25);
			l2.setBounds(20, 20,800 , 20);
			l2.setForeground(Color.white);
			//l1.setForeground(Color.white);
			add(sub);
			add(a);
			add(send);
			add(back);
			add(l2);
			add(sub1);
			add(mail);
			//add(subim);
			//add(mailim);
			

            try{
            	//System.out.println("waiting for client to connect");
            	ss=new ServerSocket(1111);
				
			//	System.out.println("Client connected");
			}
            catch(Exception e)
            {
            	e.printStackTrace();	
            }
             
						//add(l1);
			
			
			l2.setText("Before sending any message to client, connect server, first login to user client account");
			add(l2);
			setVisible(true);
			s1=ss.accept();
			l2.setText("Client is now connected...you can send email to client");
			setVisible(true);
			writer= new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
			reade=new BufferedReader(new InputStreamReader(s1.getInputStream()));
			send.addActionListener(new ActionListener()
			{
				private BufferedWriter bufferedWriter;

				public void actionPerformed(ActionEvent ae)
				{
					String t1=sub.getText();
					String t2=a.getText();
					String st=t1+" Message : "+t2;
		        	 FileWriter f1;
					try {
						File direct = new File("datasetA/OutboxS");
						File[] file = direct.listFiles();
						max=0;
						for(File f3: file) {
							String s="";
							String name3=f3.getName();
							for(int i=0;i<name3.length();i++)
							{
								char a=name3.charAt(i);
								if(Character.isDigit(a))
								{
									s+=a;
								}
							}
							int d=Integer.parseInt(s);
							if(d>max)
							{
								max=d;
							}
							//r=d;
						}
						String c5=Integer.toString(max+1);
						String na="out"+c5;
						String temp5="datasetA/OutboxS/"+na+".txt";
						f1=new FileWriter(temp5,true);
			        	
						//f1 = new FileWriter("datasetA/OutboxS/text1.txt",true);
						f1.write(st);
						f1.write("\r\n");
						f1.close();
						writer.write(st);
						writer.write("\r\n");
						//writer.close();
	                    writer.flush(); 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 			
			    }
			});

			  t=new Thread(this);//start a new thread
              t.setDaemon(true);//set the thread as demon
              t.start();

		}
		@Override
		public void actionPerformed(ActionEvent ae) {
	         }
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				String s=reade.readLine();
				String temp="Subject : "+s;
				System.out.println(s);
				String tem="";
				
				int j=0;
				st3="Subject : ";
			     st4=new StringTokenizer(s);
			     while(st4.hasMoreTokens())
			     {
			    	 tem=st4.nextToken();
			    	 System.out.println(tem);
			    	 if(tem.equals("Message"))
			    	 {
			    		 System.out.println("entered in else if");
			    		 break;
			    		 //st3=st3+tem+" ";
			    		 //System.out.println("st3 is "+st3);
			    	 }
			    	 else
			    	 {
			    		// System.out.println("entered in else if");
			    		 //break;
			    		 st3=st3+tem+" ";
			    		 System.out.println("st3 is "+st3);
			    	 }
			     }
			     System.out.println(st3);
				HomeC.add_inbox();
				
				
				//FileWriter fw1;
				File direct = new File("datasetA/testMessages");
				File[] file = direct.listFiles();
				max=0;
				if(file.length==0)
				{
					fw=new FileWriter("datasetA/testMessages/test1.txt",true);
					fw.write(temp);
					fw.write("\r\n");
					fw.close();
				}
				for(File f1: file) {
					String s2="";
					String name=f1.getName();
					for(int i=0;i<name.length();i++)
					{
						char a=name.charAt(i);
						if(Character.isDigit(a))
						{
							s2+=a;
						}
					}
					int d=Integer.parseInt(s2);
					if(d>max)
					{
						max=d;
					}
					//r=d;
				}
				String c=Integer.toString(max+1);
				String na="test"+c;
				String temp1="datasetA/testMessages/"+na+".txt";
				fw=new FileWriter(temp1,true);
				fw.write(temp);
				fw.write("\r\n");
				fw.close();
				NaiveBayesClassifier nb = new NaiveBayesClassifier();
				CLassifierEvaluator eval = new CLassifierEvaluator(nb);
				eval.Evaluate(false);
				if(eval.result==true)
				{
					File directory = new File("datasetA/spams");
					File[] files = directory.listFiles();
					max=0;
					for(File f1: file) {
						String s1="";
						String name1=f1.getName();
						for(int i=0;i<name1.length();i++)
						{
							char a1=name1.charAt(i);
							if(Character.isDigit(a1))
							{
								s1+=a1;
							}
						}
						int d=Integer.parseInt(s1);
						if(d>max)
						{
							max=d;
						}
						//r=d;
					}
					String c1=Integer.toString(max+1);
					String na1="spmsga"+c1;
					String temp2="datasetA/spams/"+na1+".txt";
					fw=new FileWriter(temp2,true);
					
					//fw1=new FileWriter("datasetA/spams/spmsga1.txt",true);
					fw.write(temp);
					fw.write("\r\n");
					fw.close();
					//max=0;
					System.out.println("msg is spam server");
				}
				else{
					FileWriter ss1;
					File directory = new File("datasetA/hams");
					File[] files2 = directory.listFiles();
					//int r2 = 0;
					max=0;
					for(File f1: file) {
						String s2="";
						String name2=f1.getName();
						for(int i=0;i<name2.length();i++)
						{
							char a1=name2.charAt(i);
							if(Character.isDigit(a1))
							{
								s2+=a;
							}
						}
						int d=Integer.parseInt(s2);
						if(d>max)
						{
							max=d;
						}
						//r=d;
					}
					String c2=Integer.toString(max+1);
					String na2="msg"+c2;
					String temp3="datasetA/hams/"+na2+".txt";
					fw=new FileWriter(temp3,true);
					fw.write(temp);
					//fw1.write(st1);
					fw.write("\r\n");
					fw.close();
					String na3="in"+c2;
					String temp4="datasetA/InboxS/"+na3+".txt";
					ss1=new FileWriter(temp4,true);
					
					ss1.write(temp);
					//fw1.write(st1);
					ss1.write("\r\n");
					ss1.close();
					//max=0;
					System.out.println("msg is ham server");
					//fw1=new FileWriter("datasetA/hams/hmsg1.txt",true);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public static void main(String a[]) throws UnknownHostException, IOException
		{
			new ServerSide();
		}
		
	}

