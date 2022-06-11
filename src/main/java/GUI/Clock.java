package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import microwave.Microwave;


@SuppressWarnings("serial")
public class Clock extends JFrame /*La clase principal es una ventana (JFrame)*/
{
	private JTextField textField;
	protected Microwave mw;
	
	public Clock()
	{
		setTitle("Clock");       /*Nombre de la ventana*/
		this.setSize(300, 190); /*Tamano de la ventana*/
		this.setBounds(100, 500, 300, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(new Panel());
		getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 29, 264, 109);
		getContentPane().add(textField);
		textField.setColumns(10);/* Para apagar el programa cuando cierre la ventana*/
		
		ImageIcon icon =new ImageIcon(getClass().getResource("/imgs/Relog.png"));
		Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		setIconImage(image);
	}
	
	public Clock(Microwave mw2)
	{
		this();
		mw = mw2;
		Momento momento = new Momento();
		Thread trid = new Thread(momento);
		trid.start();
	}
	
	public class Momento extends Thread
	{
		public void run()
		{
			while(true)
			{
				try
				{
					textField.setText(Integer.toString(mw.getTime()));
					Thread.sleep(100);
					
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public class Panel extends JPanel
	{
		protected void paintComponent(Graphics g)
		{
			this.setSize(600,400);
			super.paintComponent(g);
			
			g.setColor(new Color(0,100,250));
			Graphics2D g2 = (Graphics2D) g;
			float thickness = 4;
			g2.setStroke(new BasicStroke(thickness));
			g2.drawLine(1, 1, 400, 1);
			g2.setStroke(new BasicStroke());
		}
	}
}