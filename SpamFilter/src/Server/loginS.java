package Server;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginS extends JFrame
{
	JLabel user;
	JLabel pass;
	JTextField usert;
	JPasswordField passt;
	JButton log;
	JButton register;

	loginS() throws IOException
	{
		setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width,d.height);
		setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("E://Study_Stuff//spam_mail//pp5.jpg")))));
		user=new JLabel("User Name  :");
		pass = new JLabel("Password     :");
		usert=new JTextField();
		passt=new JPasswordField();
		log=new JButton("Login");
		register=new JButton("Register");
		
		user.setForeground(Color.white);
		user.setBounds(700,440,150,40);
		pass.setBounds(700,510,150,40);
		pass.setForeground(Color.white);
		usert.setBackground(Color.black);
		passt.setBackground(Color.black);
		log.setForeground(Color.white);
		register.setForeground(Color.white);
		log.setBackground(new Color(51,0,25));
		register.setBackground(new Color(51,0,25));
		user.setFont(new Font("constantia",Font.ITALIC,20));
		pass.setFont(new Font("constantia",Font.ITALIC,20));
		log.setFont(new Font("constantia",Font.ITALIC,20));
		register.setFont(new Font("constantia",Font.ITALIC,20));
		usert.setBounds(840, 440, 250, 35);
		passt.setBounds(840,510,250,35);
		log.setBounds(750,650,150,30);
		register.setBounds(950,650,150,30);
		
		//user.setFont(new Font("constantia",Font.BOLD,17));
		//pass.setFont(new Font("constantia",Font.BOLD,17));
		
		add(user);
		add(pass);
		add(passt);
		add(usert);
		add(log);
		add(register);
		log.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("hello");
				//setVisible(false);
				dispose();
				Home home;
				try {
					home = new Home();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//ss1.setVisible(true);
			}
		});
		pack();
		setVisible(true);
	}
	public static void main(String args[]) throws IOException
	{
		new loginS();
	}
    /* public void inst()
     {
    	 try {
			ServerSide ss=new ServerSide();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }*/
}
