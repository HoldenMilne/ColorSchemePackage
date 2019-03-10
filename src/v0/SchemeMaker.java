package v0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

public class SchemeMaker extends JFrame implements ActionListener {

	Color[] colours;
	int[] clickModifier = new int[] {33,33,44};
	
	/**
	 * Creates the builder window for the user to construct or change schemes.  The scheme passed in will determine
	 * what colours the user can change.  The schemes cannot be renamed as the programmer will need to set the 
	 * colours by name to each component, and on update will depend on those colours.
	 * @param style
	 * @param scheme
	 */
	public SchemeMaker(int style, ColorScheme scheme)
	{
		Container contentPane = this.getContentPane();
		switch(style)
		{
			case ColorScheme.MAKER:
				super.setName("Colour Scheme Maker");
				int windowWidth = 250;
				Dimension tandb_dim = new Dimension(windowWidth,40);
				Dimension main_dim = new Dimension(windowWidth,200);
				
				JButton b1 = new JButton("Hello");
					b1.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));
					b1.setBackground(scheme.GetColour("Bar"));
					b1.setForeground(scheme.GetColour("Font"));
					b1.setPreferredSize(new Dimension(40,20));
					b1.setFocusable(false);
				JPanel top = new JPanel();
					top.setPreferredSize(tandb_dim);
					top.add(b1);
					
				JPanel bottom = new JPanel();
					bottom.setPreferredSize(tandb_dim);
					
				int i = 0;
				String[] names = new String[scheme.length];
				Colour[] colors = new Colour[scheme.length];

				JPanel colorPanel = new JPanel();
					colorPanel.setLayout(new GridLayout(scheme.length,1));
				Dimension bars_dim =new Dimension(windowWidth,40);
				Dimension palette_dim = new Dimension(26,26);

				for(HashList c : scheme.table)
				{
					if(c==null||c.root==null)continue;
					
					HashNode temp = c.root;
					while(temp!=null)
					{
						System.out.println(scheme.length+" "+i);
						colors[i] = temp.value;
						names[i] = temp.value.getName();
						JPanel cpan = new JPanel();
							cpan.setLayout(new GridLayout(1,2));
							cpan.setBackground(scheme.GetColour("Accent 1"));
						JLabel lab = new JLabel(names[i]);
							cpan.add(lab);
						JPanel palCover = new JPanel();
						JPanel pal = new JPanel();
							pal.setBackground(colors[i]);
							pal.addMouseListener(new PaletteListener(pal));
							pal.setPreferredSize(palette_dim);
							pal.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
						palCover.add(pal);
						cpan.add(palCover);
						cpan.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),BorderFactory.createEmptyBorder(0,4,0,0)));
						cpan.setPreferredSize(bars_dim);
						colorPanel.add(cpan);
						temp = temp.next;
						i++;
					}
				}
				
		
				JScrollPane main = new JScrollPane(colorPanel);
					main.setPreferredSize(main_dim);
					//main.setBackground(scheme.GetColour("Main 1"));
					main.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					//main.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				BevelBorder b = new BevelBorder(BevelBorder.RAISED,scheme.GetColour("Accent 1"),scheme.GetColour("Accent 2"));
					
				top.setBorder(b);
				bottom.setBorder(b);
				contentPane.add(top, BorderLayout.NORTH);
				contentPane.add(bottom, BorderLayout.SOUTH);
				contentPane.add(main, BorderLayout.CENTER);
			
			break;
			case ColorScheme.MODIFIER:
				super.setName("Colour Scheme Modifier");
				
				
				
				break;
		}
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
