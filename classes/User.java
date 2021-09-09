package classes;

public class User{

	private int id;
	private String name;
	private int level;

	public User( int id ){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setLevel( int level ){
		this.level = level;
	}
	public int getId(){ return id; }
	public int getLevel(){ return level; }
	public String getName(){ return name; }
}