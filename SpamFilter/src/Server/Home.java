package Server;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
public class Home extends YahooBase implements MouseListener{
	 static JLabel add1;
	    static JLabel inbox1;
	    static int x,y,z,w,i;
	    JLabel[] Al;
		Home() throws IOException
		{
			    new YahooBase();
				inbox1=new JLabel("INBOX : ");
				inbox1.setForeground(Color.white);
				inbox1.setFont(new Font("constantia",Font.BOLD,15));
				inbox1.setBounds(300,135,100,40);
				jf2.add(inbox1);
				compose.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						//jf2.dispose();
						try {
							
							ServerSide ss1=new ServerSide();
						} catch (UnknownHostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
				//loads all inbox messages from file(hamc)
				        x=300;
						y=180;
						z=900;
						w=40;
						i=0;
						Al=new JLabel[200];
						String wor="";
						String temp="";
						File directory1=new File("datasetB/hamc");
						File[] files=directory1.listFiles();
						for(File f: files)
						{
							temp="";
							BufferedReader br = new BufferedReader(new FileReader(f));
							String line = br.readLine();
							while(line!=null)
							{
								st=new StringTokenizer(line);
								while(st.hasMoreTokens())
								{
									wor=st.nextToken();
									if(wor.equals("Message"))
									{
										break;
									}
									else
									{
										temp+=" "+wor;
									}
								}
								if(wor.equals("Message"))
								{
									break;
								}
								line=br.readLine();
								
							}
							temp+="";
						    Al[i]=new JLabel(temp);
						    Al[i].setFont(new Font("constantia",Font.PLAIN,15));
							Border border = BorderFactory.createLineBorder(Color.white, 1);
							Al[i].setBorder(border);
							Al[i].setForeground(Color.white);
							Al[i].setBackground(Color.black);
							Al[i].setOpaque(true);
							Al[i].setFont(new Font("constantia",Font.PLAIN,18));
							Al[i].setBounds(x,y,900,40);
							jf2.add(Al[i]);
							jf2.pack();
							Al[i].addMouseListener( this);
							i++;
							y=y+50;
						}
				jf2.setResizable(false);
				jf2.pack();
				jf2.setVisible(true);
		}
		public static void add_inbox()
		{
			String s5=ServerSide.st3;
			Home hc;
			try {
				hc = new Home();
				jf2.dispose();
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
			
			
			add1=new JLabel("");
			add1.setText("    "+s5);
			add1.setBackground(Color.black);
			add1.setOpaque(true);
			add1.setForeground(Color.white);
			
			add1.setFont(new Font("constantia",Font.PLAIN,15));
			
			Border border = BorderFactory.createLineBorder(Color.white, 1);
			add1.setBorder(border);
			//inbox1.setBounds(300,135,100,40);
			add1.setBounds(x,y,z,w);
			jf2.add(add1);

			add1.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent me)
				{
					String w="";
					String concate="";
					JLabel src=(JLabel) me.getSource();
					String m1=src.getText();
				    System.out.println("Text Area contents are ");
					System.out.println(m1);
					File dir=new File("datasetB/hamc");
					File[] files=dir.listFiles();
					for(File f1:files)
					{
						try {
							BufferedReader br = new BufferedReader(new FileReader(f1));
							String line=br.readLine();
					        StringTokenizer st=new StringTokenizer(line);
							while(st.hasMoreTokens())
							{
								w=st.nextToken();
								if(w.equals("Message"))
								{
									break;
								}
								else {
									if(w.equals("Subject"))
									{
										w="   "+w;
									}
									concate+=" "+w;
									System.out.println("inside" +f1.getName() +"concatenet is ");
									System.out.println(concate);
								}
							}
							concate+="";
							if(concate.equals(m1))
							{
								System.out.println("equality satisfied");
								//String filename=f1.getName();
								if(!Desktop.isDesktopSupported()){
						            System.out.println("Desktop is not supported");
						            return;
						        }
								Desktop desktop = Desktop.getDesktop();
						        if(f1.exists()) desktop.open(f1);
						        break;
							}
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						concate="";
					}
				}
			});
			//jf1.setVisible(false);
			//jf1.dispose();
		}
		
		public void mouseClicked(MouseEvent me)
		{
			JLabel src=(JLabel) me.getSource();
			String m1=src.getText();
			for(int j=0;j<i;j++)
			{
				
				if(m1.equals(Al[j].getText()))
				{
					String w="";
					String concate="";
					System.out.println("Text Area contents are ");
					System.out.println(m1);
					File dir=new File("datasetB/hamc");
					File[] files=dir.listFiles();
					for(File f1:files)
					{
						try {
							BufferedReader br = new BufferedReader(new FileReader(f1));
							String line=br.readLine();
						
							StringTokenizer st=new StringTokenizer(line);
							while(st.hasMoreTokens())
							{
								w=st.nextToken();
								if(w.equals("Message"))
								{
									break;
								}
								else {
									concate+=" "+w;
									System.out.println("inside" +f1.getName() +"concatenet is ");
									System.out.println(concate);
								}
							}
							if(concate.equals(m1))
							{
								System.out.println("equality satisfied");
								//String filename=f1.getName();
								if(!Desktop.isDesktopSupported()){
						            System.out.println("Desktop is not supported");
						            return;
						        }
								Desktop desktop = Desktop.getDesktop();
						        if(f1.exists()) desktop.open(f1);
						        break;
							}
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						concate="";
					}
				}
				}
			}
		
		
		public static void main(String a[]) throws IOException
		{
			Home a1=new Home();
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

}
