//passenger.java
//package ors;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Passenger extends Connection1 implements ActionListener
{
		JFrame f;
		JLabel l1,l2,l3,l4,l5,l6;
		JTextField t1,t2,t3;
		JButton b1,b2,b3;
		JCheckBox c3,c4,c5;
		//CheckboxGroup cbg;
		JTextArea ta;
		PreparedStatement ps;
		Statement st;
		ResultSet rs;
		int pno;
		JLabel imgL;
		ImageIcon img;
                ButtonGroup cbg;
                JRadioButton c1,c2;
		Passenger(int p)
		{
			pno=p;
			img=new ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\Online Reservation\\src\\online\\reservation\\railwaybg.jpg");
			imgL=new JLabel(img);
			imgL.setBounds(0,0,600,600);
			f=new JFrame("Passenger");
			f.getContentPane().setLayout(null);
			f.getContentPane().setBackground(Color.green);
			l1=new JLabel("PId");
			l1.setBounds(50,50,100,30);
			t1=new JTextField(10);
			t1.setBounds(170,50,100,30);
			l2=new JLabel("Name of Passenger");
			l2.setBounds(50,80,120,30);
			t2=new JTextField(10);
			t2.setBounds(170,80,100,30);
			l3=new JLabel("Age");
			l3.setBounds(50,130,100,30);
			t3=new JTextField(10);
			t3.setBounds(150,130,50,30);
			l4=new JLabel("Gender");
			l4.setBounds(250,130,50,30);
			ta=new JTextArea(5,10);
			ta.setBounds(150,170,130,70);
			l5=new JLabel("Address");
			l5.setBounds(50,170,100,30);
			l6=new JLabel("Catagory");
			l6.setBounds(50,240,100,30);
			b1=new JButton("More");
			b1.setBackground(Color.yellow);
			b1.addActionListener(this);
			b1.setBounds(50,330,100,30);
			b2=new JButton("Save");
			b2.setBackground(Color.yellow);
			b2.addActionListener(this);
			b2.setBounds(170,330,100,30);
			b3=new JButton("Back");
			b3.setBackground(Color.yellow);
			b3.addActionListener(this);
			b3.setBounds(290,330,100,30);

			b1.setMnemonic('M');
			b2.setMnemonic('S');
			b3.setMnemonic('B');

                        cbg=new ButtonGroup();
			//cbg=new CheckboxGroup();
                        c1=new JRadioButton("Male");
			//c1=new Checkbox("Male",cbg,true);
                        c1.setBorderPainted(false);
                        c1.setOpaque(true);
                        c1.setContentAreaFilled(false);
			c1.setBounds(300,130,100,30);
                        cbg.add(c1);
                        c2=new JRadioButton("FeMale");
			//c2=new Checkbox("Female",cbg,false);
                        c2.setBorderPainted(false);
                        c2.setOpaque(true);
                        c2.setContentAreaFilled(false);
			c2.setBounds(300,160,100,30);
                        cbg.add(c2);

			c3=new JCheckBox("General");
                        c3.setBorderPainted(false);
                        c3.setOpaque(true);
                        c3.setContentAreaFilled(false);
                        c3.setForeground(Color.red);
			c3.setBounds(150,240,100,30);
			c4=new JCheckBox("Senior Citizen");
                        c4.setBorderPainted(false);
                        c4.setOpaque(true);
                        c4.setContentAreaFilled(false);
			c4.setForeground(Color.red);
                        c4.setBounds(150,270,100,30);
			c5=new JCheckBox("Ex-serviceman");
                        c5.setBorderPainted(false);
                        c5.setOpaque(true);
                        c5.setContentAreaFilled(false);
			c5.setForeground(Color.red);
                        c5.setBounds(150,300,100,30);
			f.getContentPane().add(l1);
			f.getContentPane().add(l2);
			f.getContentPane().add(l3);
			f.getContentPane().add(l4);
			f.getContentPane().add(l5);
			f.getContentPane().add(l6);
			f.getContentPane().add(t1);
			f.getContentPane().add(t2);
			f.getContentPane().add(t3);
			f.getContentPane().add(ta);
			f.getContentPane().add(b1);
			f.getContentPane().add(b2);
			f.getContentPane().add(b3);
			f.getContentPane().add(c1);
			f.getContentPane().add(c2);
			f.getContentPane().add(c3);
			f.getContentPane().add(c4);
			f.getContentPane().add(c5);
			f.getContentPane().add(imgL);
			f.setSize(600,600);
			f.setLocation(600,300);
			f.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==b1)
	{
		try
		{
                        String sg="";
			String cat="";
			ps=con.prepareStatement("insert into TempPassenger values(?,?,?,?,?,?,?)");
			ps.setString(1,t1.getText());
			ps.setString(2,t2.getText());
			ps.setString(3,t3.getText());
                        if(c1.isSelected())
				sg=c1.getLabel();
			if(c2.isSelected())
				sg=sg+c2.getLabel();
                        ps.setString(4,sg);
			//ps.setString(4,cbg.getSelectedCheckbox().getLabel());
			ps.setString(5,ta.getText());
			if(c3.isSelected())
			cat+=c3.getLabel()+",";
			if(c4.isSelected())
			cat+=c4.getLabel()+",";
			if(c5.isSelected())
			cat+=c5.getLabel()+",";
			ps.setString(6,cat);
			ps.setInt(7,pno);
			ps.executeUpdate();
			ps.close();

			Passenger P=new Passenger(pno);
			st=con.createStatement(pno, pno);
			rs=st.executeQuery("select * from PassengerID");
			rs.next();
			int x=rs.getInt(1);
			P.t1.setText(String.valueOf(x));
			st.close();
			ps=con.prepareStatement("update PassengerID set PID=? where PID=?");
			ps.setInt(1,(x+1));
			ps.setInt(2,x);
			ps.executeUpdate();
			ps.close();
			}
			catch(Exception e1)
			{
			System.out.println("Connection failed:"+e1);
			}
			}
			if(e.getSource()==b2)
			{

			try
			{
                            String sg="";
				String cat="";
				ps=con.prepareStatement("insert into TempPassenger values(?,?,?,?,?,?,?)");
				ps.setString(1,t1.getText());
				ps.setString(2,t2.getText());
				ps.setString(3,t3.getText());
                                if(c1.isSelected())
				sg=c1.getLabel();
			if(c2.isSelected())
				sg=sg+c2.getLabel();
                                ps.setString(4,sg);
			
				//ps.setString(4,cbg.getSelectedCheckbox().getLabel());
				ps.setString(5,ta.getText());
				if(c3.isSelected())
				cat+=c3.getLabel()+",";
				if(c4.isSelected())
				cat+=c4.getLabel()+",";
				if(c5.isSelected())
				cat+=c5.getLabel()+",";
				ps.setString(6,cat);
				ps.setInt(7,pno);
				ps.executeUpdate();
				ps.close();

				st=con.createStatement(pno, pno);
				rs=st.executeQuery("select * from TempPassenger");
				while(rs.next())
				{
					ps=con.prepareStatement("insert into Passenger values(?,?,?,?,?,?,?)");
					ps.setString(1,rs.getString(1));
					ps.setString(2,rs.getString(2));
					ps.setString(3,rs.getString(3));
					ps.setString(4,rs.getString(4));
					ps.setString(5,rs.getString(5));
					ps.setString(6,rs.getString(6));
					ps.setString(7,rs.getString(7));
					ps.executeUpdate();
					ps.close();
				}
				st=con.createStatement(pno, pno);
				st.executeUpdate("delete from TempPassenger");
				JOptionPane.showMessageDialog(null,"Ticket Booked Successfuly");
				b2.setEnabled(false);
				b1.setEnabled(false);
				st.close();
			}
			catch(Exception e1)
			{
				System.out.println("Connection failed:"+e1);
			}
			}

			if(e.getSource()==b3)
			{
				f.setVisible(false);
				new Reservation();
			}
	}
	public static void main(String args[])
	{
		new Passenger(0);
	}
} 