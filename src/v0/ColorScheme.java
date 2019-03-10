package v0;

import java.awt.Color;
import java.util.ArrayList;


public class ColorScheme {

	public static ArrayList<ColorScheme> schemes = new ArrayList<ColorScheme>();
	HashList[] table = new HashList[23];
	String name;
	public int length = 0;
	private static boolean loaded = false;
	
	public static void LoadDefaultSchemes()
	{
		loaded = true;
		ColorScheme def = new ColorScheme("Default",new Colour[] {
			new Colour("Main 1",0x363636),
			new Colour("Main 2",0xF1F1F1),
			new Colour("Accent 1",0xffb73a),
			new Colour("Accent 2",0xffb73a),
			new Colour("Bar",0x404044),
			new Colour("Font",0xFFFFFF)
		});
		
		schemes.add(def);
		
		ColorScheme shoe = new ColorScheme("Shoelace",new Colour[] {
				new Colour("Main 1",0xD2DD7E),
				new Colour("Main 2",0x75C7B2),
				new Colour("Accent 1",0x304463),
				new Colour("Accent 2",0xF0948B),
				new Colour("Bar",0xFAE9C7),
				new Colour("Font",0xFFFFFF)
			});
		
		schemes.add(shoe);
		
		ColorScheme roy = new ColorScheme("Royalty",new Colour[] {
				new Colour("Main 1",0xA31F1F),
				new Colour("Main 2",0xF1F1F1),
				new Colour("Accent 1",0xefea45),
				new Colour("Accent 2",0xF1F1F1),
				new Colour("Bar",0x376087),
				new Colour("Font",0xF1F1F1)
			});
		schemes.add(roy);
		
		ColorScheme dark = new ColorScheme("Dark",new Colour[] {
				new Colour("Main 1",0x212121),
				new Colour("Main 2",0x363636),
				new Colour("Accent 1",0xF2F2F2),
				new Colour("Accent 2",0xEE4444),
				new Colour("Bar",0x404048),
				new Colour("Font",0xEE4444)
			});
		
		schemes.add(dark);
		
		ColorScheme arch = new ColorScheme("D-Arch",new Colour[] {
				new Colour("Main 1",0x212121),
				new Colour("Main 2",0x363636),
				new Colour("Accent 1",0x0192DD),
				new Colour("Accent 2",0x0092DD),
				new Colour("Bar",0x404048),
				new Colour("Font",0x0092DD)
			});
		
		schemes.add(arch);
		
		ColorScheme syr = new ColorScheme("Syrup",new Colour[] {
				new Colour("Main 1",0xe42643),
				new Colour("Main 2",0x0766c0),
				new Colour("Accent 1",0xffe934),
				new Colour("Accent 2",0xe2b03d),
				new Colour("Bar",0xe2b03d),
				new Colour("Font",0x000000)
			});
			
		for(HashList h : syr.table)
		{
			if(h == null) continue;
			HashNode temp = h.root;
			while(temp!=null)
			{
				temp = temp.next;
			}
		}
		schemes.add(syr);
	}
	
	public ColorScheme(String name)
	{
		this(name, 23,new Colour[0]);
	}
	
	public ColorScheme(String name, int length)
	{
		this(name, length,new Colour[0]);
	}
	
	public ColorScheme(String name, Colour[] colors)
	{	
		this(name,23,colors);
	}
	
	public ColorScheme(String name, int length, Colour[] colors)
	{
		if(!loaded)
			LoadDefaultSchemes();
		table = new HashList[length];
		this.name = name;
		
		for(Colour c : colors)
		{
			AddColour(c);
		}
		
		
	}
	
	public static void main(String[] args) 
	{
		///new TestWindow();
		ColorScheme.LoadDefaultSchemes();
		SchemeMaker();
	}
	
	public void AddColour(Colour c)
	{
		Hash(c);
		
	}
	
	public void SwapColor(String ColorName, Color c)
	{
		Colour col = GetColour(ColorName);
		col.setColour(c);
	}
	
	public void AddColour(String name, Color c)
	{
		AddColour(new Colour(name,c));
	}
	
	public Colour GetColour(String name)
	{
		int hash = Math.abs(new Colour(name,0xFFFFFF).FNVHash())%table.length;
		
		if(table[hash]==null)
		{
			try {
				throw new Exception();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		} else
		{
			HashNode h = table[hash].root;
			while(h!=null)
			{
				if(h.value.getName().equals(name))
				{
					return h.value;
				}
				h = h.next;
			}
		}
		return null;
		//return table[hash].;
	}
	
	private void Hash(Colour c)
	{
		int hash = Math.abs(c.FNVHash())%table.length;
		
		// Create a new hash list if no hash list actuall exists
		if(table[hash]==null)
		{
			table[hash] = new HashList(new HashNode(c));
			length += 1;
			
		}else
		{
			
			if(table[hash].Add(c))
				length += 1;
		}
	}
	
	static ColorScheme FindScheme(String name)
	{
		for(ColorScheme s : schemes)
		{
			if(s.name.equals(name)) 
			{
				return s;
			}
		}
		
		return schemes.get(0);
	}
	
	public static final int MAKER = 0;
	public static final int MODIFIER = 1;
	
	public static void SchemeMaker() 
	{
		SchemeMaker(MAKER, schemes.get(0));
	}
	
	public static void SchemeMaker(int style, ColorScheme scheme)
	{
		new SchemeMaker(style,scheme);
	}
}
