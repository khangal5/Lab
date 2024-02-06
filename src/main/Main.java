package main;

import java.util.*;
public class Main {
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		//oroin too
		System.out.println("Enter total vertices:");
        int t = scan.nextInt();
		int adjMat [][] = new int[t][t];
		
		//oroinuudiin urtiig bichne
		 System.out.println("Enter the adjacency matrix (separate elements with spaces): ");
	        for (int q = 0; q < t; q++) 
	        {
	            for (int z = 0; z < t; z++) 
	            {
	                adjMat[q][z] = scan.nextInt();
	            }
	        }
	    
	    while(true)
	    {
	    	System.out.println("0. printall");
	    	System.out.println("1. source to destination");
	    	int command = scan.nextInt();
	    	switch(command)
	    	{
	    	case 0:
	    		
		    		//zaig burtgeh massive(oroi tus bur deer temdeglehiin tuld massive iin urtaar avsn)
		    		int [] distance = new int[adjMat.length];
		    		
		    		//eh oroig songono
		    		System.out.println("Enter source vertex: ");
		    		int source = scan.nextInt();
		    	
		    		//dairsan esehiig temdeglene(oroi tus bur deer temdeglehiin tuld massive iin urtaar avsn)
		    		boolean [] visited = new boolean[adjMat.length];
		    		
		    		//eh oroi hurtl 0 gedgiig temdeglene
		    		distance[source] = 0;
		    		
		    		//eh oroigoos busd oroinuudad hyzgaargui utga ogn
		    		for (int i = 0; i < adjMat.length; i++) 
		    		{
		    			if( i == source) continue;
		    			distance[i] = Integer.MAX_VALUE;
		    		}
		    		
		    		for(int i = 0; i < adjMat.length; i++) 
		    		{
		    			int minDistVertex = findMinDistVertex(distance, visited);
		    			
		    			//oroig dairsn gdge temdeglene
		    			visited[minDistVertex] = true;
		    			
		    			//busad oroitoi haritsuulj zaig shinechlene
		    			for(int j = 0; j < adjMat.length; j++) 
		    			{
		    				if(adjMat[minDistVertex][j] != 0 && visited[j] == false && distance[minDistVertex] != Integer.MAX_VALUE) {
		    					int newDist = distance[minDistVertex] + adjMat[minDistVertex][j];
		    					if(newDist < distance[j]) {
		    						distance[j] = newDist;
		    					}
		    				}
		    			}
		    		}
		    		
		    		for(int i = 0; i < adjMat.length; i++) 
		    		{
		    			System.out.println("Vertex : " + i + " & Distance from Source : " +distance[i]);
		    		}
		    		break;
		    		
	    	case 1:
	    		System.out.println("Enter source vertex: ");
	            int source1 = scan.nextInt();

	            System.out.println("Enter destination vertex: ");
	            int destination = scan.nextInt();
	            
	            int[] shortestDistances = dijkstra(adjMat, source1);
	            int distanceToDestination = shortestDistances[destination];

	            if (distanceToDestination == Integer.MAX_VALUE) 
	            {
	                System.out.println("There is no path from source to destination.");
	            } 
	            else 
	            {
	                System.out.println("Shortest distance from source to destination: " + distanceToDestination);
	            }
	       break;
	    		}
	    	
	    	}
	    }   
	
	public static int findMinDistVertex(int[] distance, boolean [] visited) 
	{
		//oroi songoogui bga tul -1-g ogsn
		int minVertex = -1;
		
		//ochoogui oroinuud bolon (minVertex-g tohiruulaagui esvel i oroin zai n minVertex-in zainaas baga baigaa esehiig shalgana) 
		for(int i = 0; i < distance.length; i++) {
			if(visited[i] == false && (minVertex == -1 || distance[i] < distance[minVertex])) {
				minVertex = i;
			}
		}
		return minVertex;
	}

    public static int[] dijkstra(int[][] adjMath, int source1) 
    {
        int vertices = adjMath.length;
        int[] distances = new int[vertices];
        boolean[] visited1 = new boolean[vertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source1] = 0;

        for (int count = 0; count < vertices - 1; count++) 
        {
            int u = findMinDistVertex(distances, visited1);
            visited1[u] = true;

            for (int v = 0; v < vertices; v++) 
            {
                if (!visited1[v] && adjMath[u][v] != 0 && distances[u] != Integer.MAX_VALUE && distances[u] + adjMath[u][v] < distances[v]) 
                {
                    distances[v] = distances[u] + adjMath[u][v];
                }
            }
        }
        return distances;
    }
	
}
