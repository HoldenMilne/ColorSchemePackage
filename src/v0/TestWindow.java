package v0;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TestWindow extends JFrame {

	public TestWindow()
	{
		Container contentPane = this.getContentPane();
		JButton button = new JButton("STRING");
		button.setBackground(new Colour("buttonA",0xFFb2d3));
		button.setPreferredSize(new Dimension(100,30));
		contentPane.add(button);
		JMenuBar bar = new JMenuBar();
		JMenuItem file = new JMenuItem("File");
		file.setBackground(new Colour("menu_bar","f2b3ee22"));
		bar.add(file);
		this.setJMenuBar(bar);
		pack();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
