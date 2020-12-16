import java.util.ArrayList;
import java.util.Collections;

public class TownGraphManager implements TownGraphManagerInterface {
	
	Graph graph = new Graph();
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town tempOne = new Town(town1);
		Town tempTwo = new Town(town2);
		Road tempRoad = new Road(tempOne,tempTwo,weight,roadName);
		if(graph.addEdge(tempOne, tempTwo, weight, roadName).equals(tempRoad))
		{

			return true;
		}
		else
			return false;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town tempOne = new Town(town1);
		Town tempTwo = new Town(town2);
		Road tempRoad = new Road(tempOne,tempTwo,"temp");
		for(Road road : graph.edgeSet())
		{
			if(road.equals(tempRoad))
				return road.getName();
		}
		return null;
	
	}

	@Override
	public boolean addTown(String v) {
		Town tempTown = new Town(v);
		if(graph.addVertex(tempTown))
		{
			return graph.addVertex(tempTown);
		}
		else
			return false;
	}

	@Override
	public Town getTown(String name) {
		Town tempTown = new Town(name);
		for(Town town : graph.vertexSet())
		{
			if(town.compareTo(tempTown) == 0)
				return town;
		}
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		Town tempTown = new Town(v);
		return graph.containsVertex(tempTown);
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town townOne = getTown(town1);
		Town townTwo = getTown(town2);
		return graph.containsEdge(townOne, townTwo);
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> roadSorted = new ArrayList<String>();
		for(Road road : graph.edgeSet())
			roadSorted.add(road.getName());
		Collections.sort(roadSorted);
		return roadSorted;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town tempOne = new Town(town1);
		Town tempTwo = new Town(town2);
		Road tempRoad = new Road(tempOne,tempTwo,road);
		for(Road roads : graph.edgeSet())
		{
			if(roads.equals(tempRoad))
			{	
				graph.removeEdge(roads.getSource(), roads.getDestination(), roads.getWeight(), roads.getName());
				return true;
					
			}
		}
		return false;
	
	}

	@Override
	public boolean deleteTown(String v) {
		Town temp = getTown(v);
		for(Town town : graph.vertexSet())
		{
			if(town.equals(temp))
			{
				return graph.removeVertex(town);
			}
			
				
		}
		return false;
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> townSorted = new ArrayList<String>();
		for(Town town : graph.vertexSet())
			townSorted.add(town.getName());
		Collections.sort(townSorted);
		return townSorted;
			
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town townOne = getTown(town1);
		Town townTwo = getTown(town2);
		return graph.shortestPath(townOne, townTwo);
		
	}
	
}
