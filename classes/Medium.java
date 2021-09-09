package classes;


public class Medium{

	private int id;
	private String name;
	private String status;
	
	public Medium( int i,String n,String s ){
		id	= i;
		name= n;
		status = s;
	}
	public int getId(){ return id; }
	public String getName(){ return name; }
	public String getStatus(){ return status; }

}