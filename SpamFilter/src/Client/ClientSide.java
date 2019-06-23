package Client;

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

import naive_bayes.CLassifierEvaluator;
import naive_bayes.NaiveBayesClassifier;

public class ClientSide extends JFrame implements ActionListener,Runnable{
	//JPanel jp=new JPanel();
	JTextArea sub;
	JTextArea a;
	JLabel sub1;
	JLabel mail;
	JButton send;
	JButton back;
	JLabel j1;
	Socket s;
	Thread t;
	private BufferedWriter writer;
	BufferedReader rea;
	FileWriter fw;
	private int max=0;
	StringTokenizer st4;
	static String st3="";
	
	     ClientSide() throws UnknownHostException, IOException
		{
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
			add(sub);
			add(a);
			add(send);
			add(back);
			add(sub1);
			add(mail);
			//add(subim);
			//add(mailim);

            try{
				s=new Socket("localhost",1111);
				
			}
            catch(Exception e)
            {
            	e.printStackTrace();	
            }
               
						//add(j1);
            setVisible(true);
						writer= new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
						rea=new BufferedReader(new InputStreamReader(s.getInputStream()));
						send.addActionListener(new ActionListener()
						{
							private BufferedWriter bufferedWriter;
							private int r;

							public void actionPerformed(ActionEvent ae)
							{
								String t1=sub.getText();
								String t2=a.getText();
								String st=t1+" Message : "+t2;
					        	// char buffer[]=new char[st.length()];
					        	 //st.getChars(0, st.length(), buffer, 0);
								FileWriter f1;
								try {
									File direct = new File("datasetB/OutboxC");
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
									String temp5="datasetB/OutboxC/"+na+".txt";
									f1=new FileWriter(temp5,true);
						        	
									//f1 = new FileWriter("datasetA/OutboxS/text1.txt",true);
									f1.write(st);
									f1.write("\r\n");
									f1.close();
									writer.write(st);
									writer.write("\r\n");
									//writer.close();
				                    writer.flush();
				                    OutboxCF.add_out();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					 			
						    }
						});
						back.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae)
							{
								try {
									new HomeC();
									dispose();
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
				String s=rea.readLine();
				String temp="Subject : "+s;
				System.out.println(s);
				String tem="";
				//String s1[]=new String[800];
				//String st3 = "";
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
				/*if(s!="")
				{
					JLabel p1=new JLabel("");
				
				}*/
				File direct = new File("datasetB/testMessages");
				File[] file = direct.listFiles();
				max=0;
				if(file.length==0)
				{
					fw=new FileWriter("datasetB/testMessages/test1.txt",true);
					fw.write(temp);
					fw.write("\r\n");
					fw.close();
				}
				else {
				for(File f1: file) {
					String st1="";
					String name=f1.getName();
					for(int i=0;i<name.length();i++)
					{
						char a=name.charAt(i);
						//System.out.println("character of element is "+a);
						if(Character.isDigit(a))
						{
							st1+=a;
						}
					}
					//System.out.println(s1);
					int d=Integer.parseInt(st1);
					//System.out.println("file number is: "+d);
					if(d>max)
					{
						max=d;
						//System.out.println("inside if value of max is"+max);
					}
				}
				//System.out.println(max);
				String c=Integer.toString(max+1);
				String na="test"+c;
				String path="datasetB/testMessages/"+na+".txt";
				fw=new FileWriter(path,true);
				fw.write(temp);
				fw.write("\r\n");
				fw.close();}
				//max=0;
				NaiveBayesClassifier nb = new NaiveBayesClassifier();
				CLassifierEvaluator eval = new CLassifierEvaluator(nb);
				eval.Evaluate(false);
				if(eval.result==true)
				{
					String tems="";
					st3="Subject : ";
				     st4=new StringTokenizer(s);
				     while(st4.hasMoreTokens())
				     {
				    	 tems=st4.nextToken();
				    	 System.out.println(tems);
				    	 if(tems.equals("Message"))
				    	 {
				    		 System.out.println("entered in else if");
				    		 break;
				    	 }
				    	 else
				    	 {
				    		 st3=st3+tems+" ";
				    		 System.out.println("st3 is "+st3);
				    	 }
				     }
				     System.out.println(st3);
					SpamFC.add_spam();
					
					
					File directory = new File("datasetB/spamc");
					File[] files = directory.listFiles();
					//int r1 = 0;
					max=0;
					for(File f1: files) {
						String s9="";
						String name1=f1.getName();
						for(int i=0;i<name1.length();i++)
						{
							char a1=name1.charAt(i);
							if(Character.isDigit(a1))
							{
								s9+=a1;
							}
						}
						int d=Integer.parseInt(s9);
						if(d>max)
						{
							max=d;
						}
						//r1=d;
					}
					String c1=Integer.toString(max+1);
					String na1="spmsga"+c1;
					String temp1="datasetB/spamc/"+na1+".txt";
					fw=new FileWriter(temp1,true);
					//fw=new FileWriter("datasetA/spamc/text1.txt",true);
					fw.write(temp);
					fw.write("\r\n");
					System.out.println("msg is spam client");
					//fw.write("\r\n");
					fw.close();
					max=0;
				}
				else{
					FileWriter t1;
					File directory = new File("datasetB/hamc");
					File[] files2 = directory.listFiles();
					//int r2 = 0;
					for(File f1: file) {
						String s8="";
						String name2=f1.getName();
						for(int i=0;i<name2.length();i++)
						{
							char a1=name2.charAt(i);
							if(Character.isDigit(a1))
							{
								s8+=a1;
							}
						}
						int d=Integer.parseInt(s8);
						if(d>max)
						{
							max=d;
						}
						//r=d;
					}
					String c3=Integer.toString(max+1);
					String na2="msg"+c3;
					String temp3="datasetB/hamc/"+na2+".txt";
					fw=new FileWriter(temp3,true);
					//fw.write(s);
					fw.write(temp);
					fw.write("\r\n");
					fw.close();
					String na3="in"+c3;
					String temp4="datasetB/Inboxc/"+na3+".txt";
					t1=new FileWriter(temp4,true);
					//fw=new FileWriter("datasetA/hamc/text1.txt",true);
					System.out.println("msg is ham client");
				t1.write(s);
				t1.write("\r\n");
				t1.close();}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public static void main(String args[]) throws UnknownHostException, IOException
		{
			System.out.println("Hello");
			ClientSide cs=new ClientSide();
		}
	}

