package main;
import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter total vertices:");
        int t = scan.nextInt();
        int adjMat[][] = new int[t][t];

        System.out.println("Enter the adjacency matrix (separate elements with spaces): ");
        for (int q = 0; q < t; q++) {
            for (int z = 0; z < t; z++) {
                adjMat[q][z] = scan.nextInt();
            }
        }

        while (true) {
            System.out.println("0. printall");
            System.out.println("1. source to destination");
            int command = scan.nextInt();

            switch (command) {
                case 0:
                    printAllShortestDistances(adjMat);
                    break;

                case 1:
                    findShortestPathFromSourceToDestination(adjMat);
                    break;
            }
        }
    }

    public static void printAllShortestDistances(int[][] adjMat) {
        System.out.println("Enter source vertex: ");
        int source = new Scanner(System.in).nextInt();
        int[] distances = dijkstra(adjMat, source);

        for (int i = 0; i < adjMat.length; i++) {
            System.out.println("Vertex : " + i + " & Distance from Source : " + distances[i]);
        }
    }

    public static void findShortestPathFromSourceToDestination(int[][] adjMat) {
        System.out.println("Enter source vertex: ");
        int source = new Scanner(System.in).nextInt();

        System.out.println("Enter destination vertex: ");
        int destination = new Scanner(System.in).nextInt();

        int[] shortestDistances = dijkstra(adjMat, source);
        int distanceToDestination = shortestDistances[destination];

        if (distanceToDestination == Integer.MAX_VALUE) {
            System.out.println("There is no path from source to destination.");
        } else {
            System.out.println("Shortest distance from source to destination: " + distanceToDestination);
        }
    }

    public static int findMinDistVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static int[] dijkstra(int[][] adjMat, int source) {
        int vertices = adjMat.length;
        int[] distances = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = findMinDistVertex(distances, visited);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && adjMat[u][v] != 0 && distances[u] != Integer.MAX_VALUE
                        && distances[u] + adjMat[u][v] < distances[v]) {
                    distances[v] = distances[u] + adjMat[u][v];
                }
            }
        }
        return distances;
    }
}
