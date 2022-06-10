package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Door extends JFrame /*La clase principal es una ventana (JFrame)*/
{
	/** Ancho de la ventana*/
	private int widht = 640;
	/** Alto de la ventana*/
	private int height = 480;
	
	boolean change = false;
	
	public Door()
	{
		setTitle("Door");       /*Nombre de la ventana*/
		this.setSize(widht, height); /*Tamano de la ventana*/
		this.setBounds(500, 100, 600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setContentPane(new Panel());
		getContentPane().setLayout(null);
		JButton btnImage = new JButton("");
		btnImage.setEnabled(false);
		JButton btnOpenClose = new JButton("Open - Close");
		
		btnOpenClose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				change = !change;
				if(change)
				{
					ImageIcon icon2 =new ImageIcon(getClass().getResource("/imgs/Backround2.png"));
					btnImage.setIcon(icon2);
				}
				else
				{
					ImageIcon icon2 =new ImageIcon(getClass().getResource("/imgs/Backround1.png"));
					btnImage.setIcon(icon2);
				}
			}
		});
		btnOpenClose.setBounds(438, 310, 136, 40);
		btnOpenClose.setFocusable(false);
		getContentPane().add(btnOpenClose);
		btnImage.setBounds(85, 11, 390, 287);
		getContentPane().add(btnImage);
		
		
		ImageIcon icon =new ImageIcon(getClass().getResource("/imgs/Door.png"));
		Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		setIconImage(image);
		
		ImageIcon icon2 =new ImageIcon(getClass().getResource("/imgs/Backround1.png"));
		btnImage.setIcon(icon2);
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
			g2.drawLine(1, 1, 800, 1);
			g2.setStroke(new BasicStroke());
		}
	}
}