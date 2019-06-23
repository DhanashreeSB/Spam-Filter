package Server;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import Server.YahooBase;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SpamSF extends Server.YahooBase implements MouseListener{
	static JLabel adds;
    static JLabel spam1;
    private static String s5;
    private JLabel[] Al;
	private int i;
    public SpamSF() throws IOException {
		new YahooBase();
		spam1=new JLabel("SPAM : ");
		spam1.setForeground(Color.white);
    	spam1.setFont(new Font("constantia",Font.BOLD,15));
    	spam1.setBounds(300,135,100,40);
    	jf2.add(spam1);
    	x=300;
		y=180;
		z=900;
		w=40;
		i=0;
		Al=new JLabel[200];
		String wor="";
		String temp="";
	File directory1=new File("datasetA/spams");
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
		System.out.println(Al[i].getText());
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
		Al[i].addMouseListener(this); 
		i++;
		y=y+50;
	}
    	//jf2.setVisible(true);
	}
	
    public static void add_spam()
    {
    	adds=new JLabel("");
		adds.setText("    "+s5);
		adds.setBackground(Color.black);
		adds.setOpaque(true);
		adds.setForeground(Color.white);
		adds.setFont(new Font("constantia",Font.PLAIN,15));
		Border border = BorderFactory.createLineBorder(Color.white, 1);
		adds.setBorder(border);
		adds.setBounds(300,185,900,40);
		jf2.add(adds);
		adds.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me)
			{
				String w="";
				String concate="";
				JLabel src=(JLabel) me.getSource();
				String m1=src.getText();
			System.out.println("Text Area contents are ");
				System.out.println(m1);
				File dir=new File("datasetA/spams");
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
						concate+=" ";
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
    	
    }

	@Override
	public void mouseClicked(MouseEvent me) {
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
				File dir=new File("datasetA/spams");
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
	/*public static void main(String a[]) throws IOException
	{
		new SpamSF();
	}*/

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
