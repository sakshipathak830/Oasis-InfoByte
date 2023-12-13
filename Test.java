//test.java
//package ors;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Test implements ActionListener
{
		JFrame f;
		JButton b1,b2,b3,b4;
		Reservation r;
		Enquiry q;
		Cancel c;
		JLabel imgL;
		ImageIcon img;
		Test()
		{
			img=new ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\Online Reservation\\src\\online\\reservation\\Indian-Railway-Network.jpg");
			imgL=new JLabel(img);
			imgL.setBounds(0,0,600,600);
			f=new JFrame("Main");
			f.getContentPane().setLayout(null);
			f.getContentPane().setBackground(Color.green);
			b1=new JButton("Reservation Form");
			b1.addActionListener(this);
			b1.setBounds(50,100,210,60);
			b2=new JButton("PNR-enquiry");
			b2.addActionListener(this);
			b2.setBounds(50,250,210,60);
			b3=new JButton("Cancellation Form");
			b3.addActionListener(this);
			b3.setBounds(350,100,210,60);
			b4=new JButton("Exit");
			b4.addActionListener(this);
			b4.setBounds(350,250,210,60);

			b1.setBackground(new Color(42,144,255));
			b1.setForeground(new Color(255,255,255));
			b2.setBackground(new Color(42,144,255));
			b2.setForeground(new Color(255,255,255));
			b3.setBackground(new Color(42,144,255));
			b3.setForeground(new Color(255,255,255));
			b4.setBackground(new Color(42,144,255));
			b4.setForeground(new Color(255,255,255));

			b1.setMnemonic('R');
			b2.setMnemonic('P');
			b3.setMnemonic('C');
			b4.setMnemonic('E');

			f.getContentPane().add(b1);
			f.getContentPane().add(b2);
			f.getContentPane().add(b3);
			f.getContentPane().add(b4);
			f.getContentPane().add(imgL);
			f.setSize(600,600);
			f.setLocation(600,300);
			f.setVisible(true);
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==b1)
			{
				f.setVisible(false);
				r=new Reservation();
			}
			if(e.getSource()==b2)
			{
				f.setVisible(false);
				q=new Enquiry();
			}
			if(e.getSource()==b3)
			{
				f.setVisible(false);
				c=new Cancel();
			}
			if(e.getSource()==b4)
			{
				f.setVisible(false);
				System.exit(0);
			}
		}
		public static void main(String args[])
		{
			new Test();
		}
}