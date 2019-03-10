package v0;

public class HashList
{
	HashNode root;
	
	public HashList()
	{
		root = null;
	}
	
	public HashList(HashNode root)
	{
		this.root = root;
	}
	
	public boolean Add(Colour c)
	{
		if(root == null) 
			root = new HashNode(c);
		else if(root.value.getName().equals(c.getName())) // Other chunk skips over the check if length is 1
			{
				try
				{
					throw new DuplicateObjectException(); 
					
				}catch(DuplicateObjectException e)
				{
					e.printStackTrace();
					return false;
				}
			}
		else 
		{
			HashNode temp = root;
			
			while(temp.next!=null)
			{
				if(temp.value.getName().equals(c.getName())) {
					try
					{
						throw new DuplicateObjectException(); // TODO: Update for Specific Exception
						
					}catch(DuplicateObjectException e)
					{
						e.printStackTrace();
						return false;
					}
				}
				temp = temp.next;
			}
			temp.next = new HashNode(c);
		}
		return true;
	}
	
	public Colour Find(String name)
	{
		if(root == null) return null;
		
		HashNode temp = root;
		while(temp!=null)
		{
			if(temp.Compare(name))
				return temp.value;
			temp = temp.next;
		}
		return null;
	}
}
