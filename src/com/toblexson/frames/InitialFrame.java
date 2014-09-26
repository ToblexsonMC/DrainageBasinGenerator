package com.toblexson.frames;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toblexson.reference.Values;
import com.toblexson.util.FrameHelper;

public class InitialFrame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JLabel maxXLabel = new JLabel("Width"), maxYLabel = new JLabel("Height"), scaleLabel = new JLabel("Scale");
	private JTextField maxXField = new JTextField(3), maxYField = new JTextField(3), scaleField = new JTextField(3);
	private JButton button = new JButton("Generate Drainage Basin");
	
	private int maxX, maxY, scale;
	
	public InitialFrame()
	{		
		genFrame();		
	}
	
	private void genFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setTitle("Drainage Basin Generator");
		add(maxXLabel);
		add(maxXField);
		add(maxYLabel);
		add(maxYField);
		add(scaleLabel);
		add(scaleField);
		add(button);
		button.addActionListener(this);
		
		pack();
		FrameHelper.centreFrame(getWidth(), getHeight(), this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent action) 
	{
		try 
		{
			maxX = Integer.parseInt(maxXField.getText());
			maxY = Integer.parseInt(maxYField.getText());
			scale = Integer.parseInt(scaleField.getText());
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		
		if(maxX != 0 && maxY != 0 && scale != 0) 
		{
			Values.maxX = this.maxX;
			Values.maxY = this.maxY;;
			Values.scale = this.scale;
			setVisible(false);
		}
	}
}
