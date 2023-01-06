import java.awt.*;
import java.applet.*;
import java.awt.event.*;

import javax.swing.event.AncestorListener;

/*
 <APPLET CODE="Angryface" WIDTH=500 HEIGHT=500>
 </APPLET>
*/

public class Angryface extends Applet implements ActionListener, Runnable
{
    Thread t;
    int x1=10, y1=1,tx=10,ty=10;
    Button b1,b2,b3,b4;

    public void init(){
    
    b1=new Button("UP");
    
    b1.setBounds(1000,1000,2500,120);
    
    b2=new Button("Left");
    
    b2.setBounds(1000,700,1500,900);
    
    b3=new Button("Down");
    
    b3.setBounds(1000,1300,2500,900);
    
    b4=new Button("Right");
    
    b4.setBounds(1000,1900,180,120);
    
    
    add(b1);
    b1.addActionListener(this);
    
    add(b2);
    b2.addActionListener(this);
    
    add(b3);
    b3.addActionListener(this);
    
    add(b4);
    b4.addActionListener(this);
    } 

    public void start()
    {
        if(t==null)
        {
            t=new Thread(this,"New Thread");//New side Thread created on start of applet.
            t.start();
        }
    }
    public void stop()
    {
        if(t!=null)
        {
            t=null;//On stop of applet the created thread is destroyed.
        }
    }
    //Implementation of method run() of Runnable interface.
    public void run()
    {
        Thread t1=Thread.currentThread();
        while(t==t1)
        {
            repaint();
            try
            {
                Thread.sleep(180);
            }
            catch(Exception e)
            {

            }
        }
    }
    public void paint(Graphics g)
    {   
        
        //Change color to cream
        Color clr=new Color(255,129,46);
        g.setColor(clr);
        //Draw and fill the face
        g.drawOval(100+x1,100+y1,250,250);
        g.fillOval(100+x1,100+y1,250,250);
        //Change color to black
        g.setColor(Color.black);
        //Draw the left eye
        g.drawOval(165+x1,190+y1,30,30);
        g.fillOval(165+x1,190+y1,30,30);
        //Draw the right eye
        g.drawOval(255+x1,190+y1,30,30);
        g.fillOval(255+x1,190+y1,30,30);
        //Draw the Left Eyebrow
        g.drawLine(165+x1,175+y1,200+x1,185+y1);
        //Draw the Right Eyebrow
        g.drawLine(250+x1,185+y1,285+x1,175+y1);
       //Draw the smile
        g.drawArc(200+x1,270+y1,50,50,-180,-180);
    

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
             y1 -= ty;
                if(y1 < 50 )
                    ty = 10; 
        }
            if(e.getSource()==b2)
        {
            x1 -= tx;
            if(x1 < 150 )
                    tx = 5;
        }
        
            if(e.getSource()==b3)
        {
           y1 += ty;
            if(y1 > 250)
                    ty = -10;
        }
            if(e.getSource()==b4)
        {
             x1 += tx;
                if(x1 > 250)
                    tx = -5;
        }
        repaint();
        }
}

