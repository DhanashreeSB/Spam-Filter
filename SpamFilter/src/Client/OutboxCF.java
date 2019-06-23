package Client;

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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class OutboxCF extends YahooBase implements MouseListener{
    static JLabel add1;
    static JLabel outbox1;
	private int i;
	private JLabel[] Al;
    OutboxCF() throws IOException
    {
    	new YahooBase();
    	outbox1=new JLabel("OUTBOX : ");
    	outbox1.setForeground(Color.white);
    	outbox1.setFont(new Font("constantia",Font.BOLD,15));
    	outbox1.setBounds(300,135,100,40);
    	jf1.add(outbox1);
    	 x=300;
			y=180;
			z=900;
			w=40;
			i=0;
			Al=new JLabel[200];
			String wor="";
			String temp="";
		File directory1=new File("datasetB/Outboxc");
		File[] files=directory1.listFiles();
		for(File f: files)
		{
			temp="";
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			while(line!=null)
			{
				sti=new StringTokenizer(line);
				while(sti.hasMoreTokens())
				{
					wor=sti.nextToken();
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
			jf1.add(Al[i]);
			jf1.pack();
			Al[i].addMouseListener(this); 
			i++;
			y=y+50;
		}
		jf1.setVisible(true);
    }
    
    public static void add_out()
    {
    	String s5=ClientSide.st3;
		HomeC hc;
		try {
			hc = new HomeC();
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
		jf1.add(add1);

		add1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me)
			{
				String w="";
				String concate="";
				JLabel src=(JLabel) me.getSource();
				String m1=src.getText();
			    System.out.println("Text Area contents are ");
				System.out.println(m1);
				File dir=new File("datasetB/Outboxc");
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
	}
 
    /*public static void main(String a[]) throws IOException
    {
    	new OutboxCF();
    }*/

	@Override
	public void mouseClicked(MouseEvent me) {
	      JLabel src=(JLabel) me.getSource();
		String m1=src.getText();
		System.out.println("text inside label is");
		System.out.println(m1);
		for(int j=0;j<i;j++)
		{
			
			if(m1.equals(Al[j].getText()))
			{
				String w="";
				String concate="";
				System.out.println("Text Area contents are ");
				System.out.println(m1);
				File dir=new File("datasetB/Outboxc");
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
