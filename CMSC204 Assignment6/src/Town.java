
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Town implements Comparable<Town> {
	private String name;
	private Map<Town,Integer> adjacentTowns = new HashMap();
	private Integer distance = Integer.MAX_VALUE;
	private LinkedList<Town> shortestPath = new LinkedList<Town>();
	
	public Town(String name) 
	{
		this.name = name;
	}
	public Town(Town templateTown)
	{
		this.name = templateTown.name;
		this.adjacentTowns =  new HashMap(templateTown.adjacentTowns);
		
	}
	
	public Map<Town, Integer> getAdjacentTowns()
	{
		return adjacentTowns;
	}
	
	public void setDistance(int distance)
	{
		this.distance = distance;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void addAdjacentTown(Town townName, int distance)
	{
		this.adjacentTowns.put(townName, distance);
	}
	
	public String getName(){
		return name;
	}
	
	
	public LinkedList<Town> getShortestPath()
	{
	    return shortestPath;
	}
	
	public void setShortestPath(LinkedList<Town> shortestPath)
	{
	    this.shortestPath = shortestPath;
	}
	
	public String toString() {
		return name; 
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	public boolean equals(Object obj) {
		Town temp = (Town) obj;
		if(name.equals(temp.name)) {
			return true;
		}
		else
			return false;
	}
	@Override
	public int compareTo(Town o) {
		if(name.equals(o.name)) {
			return 0;
		}
		else
			return -1;
	}

}
