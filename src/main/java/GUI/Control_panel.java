package GUI;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import microwave.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




@SuppressWarnings("serial")
public class Control_panel extends JFrame
{
	private JTextField textField;
	protected Microwave mw = new Microwave();
	private boolean changed = false;
	
	public Control_panel()
	{
		setTitle("Control_panel");
		this.setBounds(100, 100, 337, 325);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setContentPane(new Panel());
		this.getContentPane().setLayout(null);
		
		JButton btnPowerIncr = new JButton("Power Increment");
		btnPowerIncr.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mw.power_inc();
				textField.setText(mw.getDisplayComponent().getDisplay());
			}
		});
		btnPowerIncr.setFocusable(false);
		btnPowerIncr.setBounds(179, 78, 132, 23);
		getContentPane().add(btnPowerIncr);
		
		JButton btnPowerDecr = new JButton("Power Decrement");
		btnPowerDecr.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mw.power_dec();
				textField.setText(mw.getDisplayComponent().getDisplay());
			}
		});
		btnPowerDecr.setFocusable(false);
		btnPowerDecr.setBounds(10, 78, 142, 23);
		getContentPane().add(btnPowerDecr);
		
		JButton btnTimerIcrm = new JButton("Timer Increment");
		btnTimerIcrm.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mw.timer_inc();
				textField.setText(mw.getDisplayComponent().getDisplay());
			}
		});
		btnTimerIcrm.setFocusable(false);
		btnTimerIcrm.setBounds(179, 159, 132, 23);
		getContentPane().add(btnTimerIcrm);
		
		JButton btnTimerDecr = new JButton("Timer Decrement");
		btnTimerDecr.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mw.timer_dec();
				textField.setText(mw.getDisplayComponent().getDisplay());
			}
		});
		btnTimerDecr.setFocusable(false);
		btnTimerDecr.setBounds(10, 159, 142, 23);
		getContentPane().add(btnTimerDecr);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 26, 301, 41);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnPowerReset = new JButton("Reset Power");
		btnPowerReset.setFocusable(false);
		btnPowerReset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mw.power_reset();
				textField.setText(mw.getDisplayComponent().getDisplay());
			}
		});
		btnPowerReset.setBounds(89, 112, 151, 23);
		getContentPane().add(btnPowerReset);
		
		JButton btnResetTimer = new JButton("Reset Timer");
		btnResetTimer.setFocusable(false);
		btnResetTimer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mw.timer_reset();
				textField.setText(mw.getDisplayComponent().getDisplay());
			}
		});
		btnResetTimer.setBounds(89, 193, 151, 23);
		getContentPane().add(btnResetTimer);
		
		JButton btnStartStop = new JButton("Start-Stop Microwave");
		btnStartStop.setFocusable(false);
		btnStartStop.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(mw.getState().getClass().equals(MW_ClosedWithItem.class))
				{				
					try
					{
						mw.cooking_start();
						changed = true;
					}
					catch(Exception ex)
					{
						
					}
				}
				if(mw.getState().getClass().equals(MW_Cooking.class) && !changed)
				{
					try
					{
						mw.cooking_stop();
					}
					catch(Exception ex)
					{
						
					}
				}
				changed = false;
				
			}
		});
		btnStartStop.setBackground(new Color(255, 99, 71));
		btnStartStop.setBounds(79, 252, 161, 23);
		getContentPane().add(btnStartStop);
		
		Door D = new Door(mw);
    	D.setVisible(true);
    	
    	Clock C = new Clock(mw);
    	C.setVisible(true);
    	
    	ImageIcon icon =new ImageIcon(getClass().getResource("/imgs/microwave.png"));
		Image image = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		setIconImage(image);
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
	
 	public static void main(String[] args)
      {
		Control_panel t = new Control_panel();
     	t.setVisible(true);
      }
}