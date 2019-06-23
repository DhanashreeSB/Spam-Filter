package Client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class YahooBase {
	public static JFrame jf1;
	JLabel l1;
	JLabel l2;
    JLabel yahoo;
    JLabel mail;
    JLabel india;
    JTextField search;
    JButton searchm;
    JButton compose;
    JButton inbox;
    JButton sent;
    JButton spam;
	 public StringTokenizer sti;
    static JLabel add1;
    static JLabel inbox1;
    protected static int x;
	protected static int y;
	static int z;
	static int w;
    public YahooBase() throws IOException{
    jf1=new JFrame();
	
    //setLayout(null);
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   jf1.setSize(screenSize.width, screenSize.height);
	   jf1.setDefaultCloseOperation(jf1.EXIT_ON_CLOSE);
		//p1=new JPanel();
		//setLayout(new BorderLayout());
		//l1=new JLabel(new ImageIcon("D://spam_mail//p5.jpg"));
		//add(l1);
		//l1.setLayout(new FlowLayout());
	//	setOpaque(true);
	   jf1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E://Study_Stuff//spam_mail//p5.jpg")))));
		
		yahoo=new JLabel("YAHOO!");
		mail=new JLabel("MAIL");
		india=new JLabel("INDIA");
		search=new JTextField();
		searchm=new JButton("search mail");
		compose=new JButton("Compose");
		inbox=new JButton("Inbox");
		sent=new JButton("Sent");
		spam=new JButton("Spam");
		inbox1=new JLabel("INBOX : ");
		
		yahoo.setForeground(Color.white);
		mail.setForeground(Color.white);
		india.setForeground(Color.white);
		inbox1.setForeground(Color.white);
		
		//searchm.setOpaque(true);
		searchm.setBackground(new Color(0,102,255));
		searchm.setForeground(Color.white);
		searchm.setForeground(Color.white);
		compose.setForeground(Color.white);
		inbox.setForeground(Color.white);
		sent.setForeground(Color.white);
		spam.setForeground(Color.white);
		//inbox.setForeground(Color.white);
		
		yahoo.setFont(new Font("constantia",Font.ITALIC,25));
		mail.setFont(new Font("constantia",Font.ITALIC,17));
		india.setFont(new Font("constantia",Font.ITALIC,15));
		searchm.setFont(new Font("constantia",Font.BOLD,15));
		compose.setFont(new Font("constantia",Font.PLAIN,18));
		//compose.setOpaque(true);
		compose.setBorder(null);
    compose. setBorderPainted(false);
     //compose.setContentAreaFilled(false);
    compose.setBackground(new Color(102,0,51));
    inbox.setBackground(new Color(102,0,51));
    sent.setBackground(new Color(102,0,51));
    spam.setBackground(new Color(102,0,51));
     //compose.setOpaque(false);
     sent.setFont(new Font("constantia",Font.PLAIN,18));
     sent.setBorder(null);
	       sent. setBorderPainted(false);
	       sent.setContentAreaFilled(false);
	        sent.setOpaque(false);
	        sent.setHorizontalAlignment(SwingConstants.LEFT);
     inbox.setFont(new Font("constantia",Font.PLAIN,18));
		//compose.setOpaque(true);
		inbox.setBorder(null);
    inbox. setBorderPainted(false);
     inbox.setContentAreaFilled(false);
     inbox.setOpaque(false);
     inbox.setHorizontalAlignment(SwingConstants.LEFT);
     spam.setFont(new Font("constantia",Font.PLAIN,18));
		//compose.setOpaque(true);
		spam.setBorder(null);
    spam. setBorderPainted(false);
    spam.setContentAreaFilled(false);
     spam.setOpaque(false);
     spam.setHorizontalAlignment(SwingConstants.LEFT);
		yahoo.setBounds(100,0,300,100);
		mail.setBounds(205,0,220,100);
		india.setBounds(120,23,220,100);
		search.setBounds(300,35,450,35);
		searchm.setBounds(770,35,130,35);
		compose.setBounds(45,150,130,30);
		inbox.setBounds(45,200,130,30);
		sent.setBounds(45,250,130,30);
		spam.setBounds(45,300,130,30);

		jf1.add(yahoo);
		jf1.add(mail);
		jf1.add(india);
		jf1.add(search);
		jf1.add(searchm);
		jf1.add(compose);
		jf1.add(inbox);
		jf1.add(sent);
		jf1.add(spam);
		//jf1.setVisible(true);
	
		compose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try {
					jf1.dispose();
					ClientSide ss1=new ClientSide();
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		inbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				try {
					new HomeC();
					jf1.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		sent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				try {
					jf1.dispose();
					new OutboxCF();
					jf1.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		spam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				try {
					jf1.dispose();
					new SpamFC();
					jf1.setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		//jf1.setVisible(true);
	//	jf1.dispose();

}
    public static void main(String a[]) throws IOException
    {
    	new YahooBase();
    }
}
