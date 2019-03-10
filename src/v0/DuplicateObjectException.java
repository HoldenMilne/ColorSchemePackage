package v0;

public class DuplicateObjectException extends Exception {

	
	@Override
	public void printStackTrace()
	{
		super.printStackTrace();
		System.out.println("Did you attempt to add an object of the same name as one that already exists?");
	}
}
