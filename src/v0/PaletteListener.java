package v0;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class PaletteListener implements MouseListener {

	Color defaultColor;
	Color pressedColor;
	Color hoverColor;
	boolean button; 
	
	public PaletteListener(Component container) 
	{
		this(container, new Color(10,10,10,0),new Color(17,17,17,0), false);
	}
	
	public PaletteListener(Component container, boolean button) 
	{
		this(container, new Color(10,10,10,0),new Color(17,17,17,0), button);
	}
	
	public PaletteListener(Component container, Color pressedColor) 
	{
		this(container, new Color(10,10,10,0), new Color(0,0,0,0),false);
		
	}
	
	public PaletteListener(Component container, Color pressedColor, boolean button) 
	{
		this(container, new Color(10,10,10,0), new Color(0,0,0,0), button);
		
	}
	
	public PaletteListener(Component container, Color pressedColor, Color hoverColor, boolean button) 
	{
		this.defaultColor = container.getBackground();
		this.pressedColor = pressedColor;
		this.hoverColor = hoverColor;
		this.button = button;
	}
	
	private final static int ADDITIVE = 0;
	private final static int SUBTRACTIVE = 1;
	
	private static Color ConstructColor(Component c, Color offset, int type)
	{
		switch(type) 
		{
			case SUBTRACTIVE:
				Color co = c.getBackground();
				int r = co.getRed()-offset.getRed();
				int g = co.getGreen()-offset.getGreen();
				int b = co.getBlue()-offset.getBlue();
				int a = co.getAlpha()-offset.getAlpha();
				return new Color(r,g,b,a);
			case ADDITIVE:
				Color co2 = c.getBackground();
				int r2 = co2.getRed()+offset.getRed();
				int g2 = co2.getGreen()+offset.getGreen();
				int b2 = co2.getBlue()+offset.getBlue();
				int a2 = co2.getAlpha()+offset.getAlpha();
				return new Color(r2,g2,b2,a2);
		}
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() instanceof JComponent)
		{
			((JComponent)arg0.getSource()).setBackground(ConstructColor(arg0.getComponent(),hoverColor,SUBTRACTIVE));
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() instanceof JComponent)
		{
			((JComponent)arg0.getSource()).setBackground(ConstructColor(arg0.getComponent(),hoverColor, ADDITIVE));
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(arg0.getSource() instanceof JComponent)
		{
			((JComponent)arg0.getSource()).setBackground(ConstructColor(arg0.getComponent(),hoverColor, SUBTRACTIVE));
			Border border = ((JComponent)arg0.getSource()).getBorder();
			
			if(border instanceof BevelBorder)
			{
				if(((BevelBorder) border).getBevelType()==BevelBorder.RAISED && button)
				{
					border = new BevelBorder(BevelBorder.LOWERED,
							((BevelBorder) border).getHighlightOuterColor(),
							((BevelBorder) border).getHighlightInnerColor(),
							((BevelBorder) border).getShadowOuterColor(),
							((BevelBorder) border).getShadowInnerColor());
					((JComponent)arg0.getSource()).setBorder(border);
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(arg0.getSource() instanceof JComponent)
		{
			((JComponent)arg0.getSource()).setBackground(ConstructColor(arg0.getComponent(),hoverColor, ADDITIVE));
			Border border = ((JComponent)arg0.getSource()).getBorder();
			
			if(border instanceof BevelBorder)
			{
				if(((BevelBorder) border).getBevelType()==BevelBorder.LOWERED && button)
				{
					border = new BevelBorder(BevelBorder.RAISED,
							((BevelBorder) border).getHighlightOuterColor(),
							((BevelBorder) border).getHighlightInnerColor(),
							((BevelBorder) border).getShadowOuterColor(),
							((BevelBorder) border).getShadowInnerColor());
					((JComponent)arg0.getSource()).setBorder(border);
				}
			}
		}
	}

}
