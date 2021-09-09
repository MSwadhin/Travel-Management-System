package classes;

public class Station{

	private int id;
	private int medium;
	private String  name;

	public Station(int i,String n){
		id=i;
		name=n;
	}
	public void setMedium( int m ){ medium=m; }
	public int getId(){ return id; }
	public String getName(){ return name; }
	public int getMedium(){ return medium; }
}