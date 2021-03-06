package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import microwave.MW_ClosedWithItem;
import microwave.MW_ClosedWithNoItem;
import microwave.MW_Cooking;
import microwave.MW_OpenWithItem;
import microwave.MW_OpenWithNoItem;
import microwave.Microwave;

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
	
	private boolean changed = false;
	protected Microwave mw;
	
	private JButton btnImage = new JButton("");
	
	public Door()
	{
		setTitle("Door");       /*Nombre de la ventana*/
		this.setSize(widht, height); /*Tamano de la ventana*/
		this.setBounds(500, 100, 600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setContentPane(new Panel());
		getContentPane().setLayout(null);
		JButton btnOpenClose = new JButton("Open - Close");
		
		btnOpenClose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(mw.getState().getClass().equals(MW_ClosedWithNoItem.class))
				{
					mw.door_opened();
					changed = true;
				}
				if(mw.getState().getClass().equals(MW_OpenWithNoItem.class) && !changed)
				{
					mw.door_closed();
					changed = true;
				}
				if(mw.getState().getClass().equals(MW_OpenWithItem.class) && !changed)
				{
					mw.door_closed();
					changed = true;
				}
				if(mw.getState().getClass().equals(MW_ClosedWithItem.class) && !changed)
				{
					mw.door_opened();
				}
				
				changed = false;
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
		
		JButton btnPutRemove = new JButton("Put - Remove Item");
		btnPutRemove.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(mw.getState().getClass().equals(MW_OpenWithNoItem.class))
				{
					mw.item_placed();
					changed = true;
				}
				if(mw.getState().getClass().equals(MW_OpenWithItem.class) && !changed)
				{
					mw.item_removed();
				}
				changed = false;
			}
		});
		btnPutRemove.setFocusable(false);
		btnPutRemove.setBounds(10, 310, 174, 40);
		getContentPane().add(btnPutRemove);
	}
	
	public Door(Microwave mw)
	{
		this();
		this.mw = mw;
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
//					System.out.println(mw.getState());
					if(mw.getState().getClass().equals(MW_ClosedWithNoItem.class))
					{
							ImageIcon icon2 =new ImageIcon(getClass().getResource("/imgs/Backround1.png"));
							btnImage.setIcon(icon2);
//							System.out.println(mw.getState());
					}
					if(mw.getState().getClass().equals(MW_OpenWithNoItem.class))
					{
							ImageIcon icon2 =new ImageIcon(getClass().getResource("/imgs/Backround2.png"));
							btnImage.setIcon(icon2);
//							System.out.println(mw.getState());
					}
					if(mw.getState().getClass().equals(MW_OpenWithItem.class))
					{
							ImageIcon icon2 =new ImageIcon(getClass().getResource("/imgs/Backround3.png"));
							btnImage.setIcon(icon2);
//							System.out.println(mw.getState());
					}
					if(mw.getState().getClass().equals(MW_ClosedWithItem.class))
					{
							ImageIcon icon2 =new ImageIcon(getClass().getResource("/imgs/Backround4.png"));
							btnImage.setIcon(icon2);
//							System.out.println(mw.getState());
					}
					if(mw.getState().getClass().equals(MW_Cooking.class))
					{
							ImageIcon icon2 =new ImageIcon(getClass().getResource("/imgs/Backround5.png"));
							btnImage.setIcon(icon2);
//							System.out.println(mw.getState());
					}
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
			g2.drawLine(1, 1, 800, 1);
			g2.setStroke(new BasicStroke());
		}
	}
}