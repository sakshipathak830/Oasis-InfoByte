

import java.awt.*;
import javax.swing.*;
class Welcome implements Runnable
{
JFrame f;
JLabel l1,l2,l3;
Thread t;
Login l;
ImageIcon img;
Image bg;
Welcome()
{
img=new ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\Online Reservation\\src\\online\\reservation\\indian-rail.jpg");
bg=img.getImage();
t=new Thread(this);
f=new JFrame("Welcome");
f.getContentPane().setLayout(null);
f.getContentPane().setBackground(Color.yellow);
l1=new JLabel("OnLine Reservation");
l1.setBounds(80,250,500,50);
l1.setFont(new Font("Eras Bold ITC",Font.BOLD,40));
l1.setForeground(Color.black);
l2=new JLabel(" _By Jeevan Thapa");
l2.setFont(new Font("Eras Bold ITC",Font.BOLD,20));
l2.setBounds(100,300,400,40);
l2.setForeground(Color.black);
l3=new JLabel(img);
l3.setBounds(0,0,600,600);
f.getContentPane().add(l1);
f.getContentPane().add(l2);
f.getContentPane().add(l3);
f.setSize(600,600);
f.setLocation(600,300);
f.setVisible(true);
t.start();
}

public void run()
{
int x=1;
while(x<=5)
{
try
{
Thread.sleep(1000);
}
catch(Exception e)
{}
x++;
}
f.setVisible(false);
l=new Login();
}
}