//login.java
//package ors;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Login implements ActionListener
{
		JFrame f;
		JLabel l1,l2,l3;
		JTextField t1;
		JPasswordField t2;
		JButton b1,b2;
		Test M;
		ImageIcon img;
		Login()
		{
			img=new ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\Online Reservation\\src\\online\\reservation\\indian-rail.jpg");
			f=new JFrame("Login");
			f.getContentPane().setLayout(null);
			f.getContentPane().setBackground(Color.pink);
			l1=new JLabel("User Name");
			l1.setFont(new Font("Cascadia Code SemiBold",Font.BOLD,18));
			l1.setForeground(Color.red);
			l1.setBounds(300,50,100,30);
			l2=new JLabel("Password");
			l2.setForeground(Color.red);
			l2.setFont(new Font("Cascadia Code SemiBold",Font.BOLD,18));
			l2.setBounds(300,100,100,30);
			t1=new JTextField(10);
			t1.setForeground(Color.blue);
			t1.addActionListener(this);
			t1.setBounds(410,50,150,30);
			t2=new JPasswordField(10);
			t2.setForeground(Color.blue);
			t2.setEchoChar('*');
			t2.addActionListener(this);
			t2.setBounds(410,100,150,30);
			b1=new JButton("Ok");
			b1.setForeground(Color.blue);
			b1.addActionListener(this);
			b1.setBounds(100,250,100,30);
			b2=new JButton("Cancel");
			b2.setForeground(Color.blue);
			b2.addActionListener(this);
			b2.setBounds(230,250,100,30);
			l3=new JLabel(img);
			l3.setBounds(0,0,600,600);

			b1.setMnemonic('O');
			b2.setMnemonic('C');

			f.getContentPane().add(l1);
			f.getContentPane().add(l2);
			f.getContentPane().add(t1);
			f.getContentPane().add(t2);
			f.getContentPane().add(b1);
			f.getContentPane().add(b2);
			f.getContentPane().add(l3);
			f.setBounds(600,300,600,600);
			f.setResizable(false);
			f.setVisible(true);
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==b1)
			{
				if(t1.getText().length()==0||t2.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Fields are empty");
				}
				else if(t1.getText().equals("jeevan") && t2.getText().equals("1234"))
				{
					f.setVisible(false);
					M=new Test();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid User Name or Password");
				}
			}
			if(e.getSource()==b2)
			{
				f.setVisible(false);
				System.exit(0);
			}
		}
}