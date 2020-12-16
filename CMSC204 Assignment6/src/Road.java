
public class Road implements Comparable<Road> {
	
	private Town source;
	private Town destination;
	private int distance;
	private String name;

	public Road(Town source, Town destination, int degrees, String name)
	{
		this.name = name;
		this.source = source;
		this.distance = degrees;
		this.destination = destination;
		
	}
	
	public Road(Town source, Town destination, String name)
	{
		this.name = name;
		this.source = source;
		this.distance = 1;
		this.destination = destination;
		
	}
	
	
	public boolean equals(Object r)
	{
		Road temp = (Road) r;
		if(this.source.getName().equals(temp.source.getName()) && 
		   this.destination.getName().equals(temp.destination.getName()))
		{
			return true;
		}
		else if(this.source.getName().equals(temp.destination.getName()) && 
				this.destination.getName().equals(temp.source.getName())) 
		{
			return true;
		
		}
		else
			return false;
	}
	
	
	public boolean contains(Town town)
	{
		if(source.compareTo(town) == 0 || destination.compareTo(town) == 0)
			return true;
		else
			return false;	
	}
	
	
	@Override
	public int compareTo(Road o)
	{
		if(this.name.equals(o.name))
		{
			return 0;
		}
		else
			return -1;
	}
	
	
	public String toString()
	{
		return name;
	}
	
	public String getName() {
		return name;
	}
	
	public Town getDestination()
	{
		return destination;
	}
	
	public Town getSource()
	{
		return source;
	}
	
	public int getWeight()
	{
		return distance;
	}

}
