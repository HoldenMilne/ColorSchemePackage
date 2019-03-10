package v0;

import java.awt.Color;

public class Colour extends Color
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4362000561280996574L;
	
	private Color colour;
	private String name;

	/**
	 * @param name
	 * The name of the colour.  Used for assigning specific colours to schemes.
	 * @param colour
	 * The built-in Java color type representing the physical colour.
	 */
	public Colour(String name, Color colour)
	{
		super(colour.getRGB());
		this.name = name;
		this.colour = colour;
	}
	/**
	 * @param name
	 * The name of the colour.  Used for assigning specific colours to schemes.
	 * @param hex
	 * The string hex value of the colour.
	 */
	public Colour(String name, String hex)
	{
		this(name,ConstructColorFromHex(hex));
		
	}

	/**
	 * @param name
	 * The name of the colour.  Used for assigning specific colours to schemes.
	 * @param hex
	 * The integer hex value of the colour.
	 */
	public Colour(String name, int hex)
	{
		this(name,new Color(hex));
	}

	/**
	 * @param name
	 * The name of the colour.  Used for assigning specific colours to schemes.
	 * @param r
	 * The red component of the colour
	 * @param g
	 * The green component of the colour
	 * @param b
	 * The blue component of the colour
	 * @param a
	 * The alpha component of the colour
	 */
	public Colour(String name, int r,int g, int b, int a)
	{
		this(name,new Color(r,g,b,a));
	}
	
	/**
	 * @param name
	 * The name of the colour.  Used for assigning specific colours to schemes.
	 * @param r
	 * The red component of the colour
	 * @param g
	 * The green component of the colour
	 * @param b
	 * The blue component of the colour
	 */
	public Colour(String name, float r,float g, float b)
	{
		this(name,r,g,b,1f);
	}
	
	/**
	 * @param name
	 * The name of the colour.  Used for assigning specific colours to schemes.
	 * @param r
	 * The red component of the colour
	 * @param g
	 * The green component of the colour
	 * @param b
	 * The blue component of the colour
	 */
	public Colour(String name, int r,int g, int b)
	{
		this(name,r,g,b,255);
	}
	
	/**
	 * @param name
	 * The name of the colour.  Used for assigning specific colours to schemes.
	 * @param r
	 * The red component of the colour
	 * @param g
	 * The green component of the colour
	 * @param b
	 * The blue component of the colour
	 * @param a
	 * The alpha component of the colour
	 */
	public Colour(String name, float r,float g,float b,float a)
	{
		this(name, new Color(r,g,b,a));
	}
	
	public int FNVHash()
	{
		int hash = 0x7fff+0<<8+0<<7+1<<6+1<<5+1<<4+0<<3+1<<2+1<<1+1;
		int FNV_PRIME = 0x93;
		for(char c : name.toCharArray())
		{
			int x = (int)c;
			hash ^= x;
			hash *= FNV_PRIME; 
		}
		
		return hash;
	}
	private static Color ConstructColorFromHex(String hex)
	{
		double y = hex.length()/2.0;
		if(Math.ceil(y)==Math.floor(y))
		{
			int x = (int)y;
			Integer[] ints = new Integer[x];
			int z = 0;
			
			for(int i = 0; i < x; i++)
			{
				System.out.println(i+" : "+x);
				String s = hex.charAt(z)+""+hex.charAt(z+1);
				ints[i] = Integer.parseInt(s,16);
				z+=2;
			}
			
			System.out.println(ints[0]+" "+ints[2]);
			if(ints.length == 3) 
			{
				return new Color(ints[0],ints[1],ints[2]);
			}else if(ints.length == 4)
			{
				return new Color(ints[0],ints[1],ints[2], ints[3]);	
			}else {
				// Throw error
			}
		}

		return null;
			
	}
	
	public Color getColour() {
		return colour;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}

	public String getName() {
		return name;
	}
}
