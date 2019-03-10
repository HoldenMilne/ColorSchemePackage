package v0;

public class HashNode {

	Colour value;
	HashNode next;
	
	public HashNode(Colour c)
	{
		value = c;
		next = null;
	}
	
	public HashNode(Colour c, HashNode n)
	{
		value = c;
		next = n;
	}
	
	public boolean Compare(String in)
	{
		if(in.equals(value.getName()))
			return true;
		return false;
	}
	
}
