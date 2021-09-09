package classes;

public class Route{

	private int id;
	private int medium;
	private String name;
	private int src;
	private int dest;

	public Route(int i,String n){
		id=i;
		name=n;
	}

	public void setMedium(int m){medium=m;}
	public void setSrc(int s){src=s;}
	public void setDest(int d){dest=d;}

	public int getId(){return id;}
	public String getName(){return name;}
	public int getMedium(){return medium;}
	public int getSrc(){return src;}
	public int getDest(){return dest;}

}