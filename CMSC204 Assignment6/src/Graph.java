import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Graph implements GraphInterface<Town,Road> {
	private Set<Town> towns;
	private Set<Road> roads;
	
	public Graph() 
	{
		towns = new HashSet<Town>();
		roads = new HashSet<Road>();
	}
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		if(sourceVertex == null || destinationVertex == null)
			return null;
		
		for (Road road : roads)
		{
			if(((road.getSource().compareTo(sourceVertex)==0)&&(road.getDestination().compareTo(destinationVertex)==0))||
				((road.getDestination().compareTo(sourceVertex)==0 && (road.getSource().compareTo(destinationVertex)==0))))
			{
				return road;
			}
		}
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws IllegalArgumentException,NullPointerException {
		if (sourceVertex == null || destinationVertex == null)
			throw new NullPointerException();
		if(towns.add(sourceVertex) == true || towns.add(destinationVertex) == true)
			throw new IllegalArgumentException();
		Road road = new Road(sourceVertex,destinationVertex,weight,description);
		if(roads.add(road))
		{	
			sourceVertex.addAdjacentTown(destinationVertex, weight);
			destinationVertex.addAdjacentTown(sourceVertex, weight);
			return road;
		}
		else
			return null;
	}

	@Override
	public boolean addVertex(Town v) {
		return towns.add(v);
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for (Road road:roads)
		{
			if(road.contains(sourceVertex) && road.contains(destinationVertex))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		for (Town town: towns)
		{
			if(town.compareTo(v) == 0)
				return true;
		}
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		return roads;

	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> touching = new HashSet<Road>();
		for (Road road: roads)
		{
			if(road.contains(vertex))
				touching.add(road);
		}
		return touching;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road tempRoad = new Road(sourceVertex,destinationVertex,weight,description);
		for(Road road : roads)
		{
			if(road.equals(tempRoad))
			{
				roads.remove(road);
				return road;
			}
		}
		return null;

			
	
	}

	@Override
	public boolean removeVertex(Town v) {
		if(towns.remove(v))
		{
			Set<Road> touching = edgesOf(v);
			for(Road road: touching)
				removeEdge(road.getSource(), road.getDestination(), road.getWeight(), road.getName());
			return towns.remove(v);
		}
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		return towns;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		dijkstraShortestPath(sourceVertex);
		
		ArrayList<String> sp = new ArrayList<String>();
		LinkedList<Town> listTowns = destinationVertex.getShortestPath();
		for(int i =0; i<listTowns.size();i++)
		{
			sp.add(listTowns.get(i).toString()+" via" + destinationVertex.getName());
		}
		sp.add(destinationVertex.toString());
		return sp;
		
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		sourceVertex.setDistance(0);
		Set<Town>setTown1 = new HashSet<>();
		Set<Town>setTown2 = new HashSet<>();
		setTown2.add(sourceVertex);
		
		while(setTown2.size()!= 0)
		{
			Town lowTown =null;
			int lowDist = Integer.MAX_VALUE;
			for(Town town : setTown2)
			{
				int townDistance = town.getDistance();
				if(townDistance < lowDist)
				{
					lowDist = townDistance;
					lowTown = town;
				}
			}
			Town current = lowTown; 
			setTown2.remove(current);
			for(Entry<Town,Integer>entry : current.getAdjacentTowns().entrySet())
			{
				Town adj = entry.getKey();
				Integer edgeDist = entry.getValue();
				
				if(!setTown1.contains(adj))
				{
					findMinDistance(adj,edgeDist,current);
					setTown2.add(adj);
				}
			}
			setTown1.add(current);
		}
	}
	
	private static void findMinDistance(Town evaluationTown, Integer edgeWeigh, Town sourceTown)
	{
	    Integer sourceTownDistance = sourceTown.getDistance();
	    if (sourceTownDistance + edgeWeigh < evaluationTown.getDistance())
	    {
	        evaluationTown.setDistance(sourceTownDistance + edgeWeigh);
	        LinkedList<Town> sp = new LinkedList<>(sourceTown.getShortestPath());
	        sp.add(sourceTown);
	        evaluationTown.setShortestPath(sp);
	        
	    }
	}
}