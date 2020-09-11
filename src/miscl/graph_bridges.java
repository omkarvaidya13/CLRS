package miscl;

import java.util.*;

// Reference Link: https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory/BridgesAdjacencyList.java
// Video Link: https://www.youtube.com/watch?v=aZXi1unBdJA

public class graph_bridges {

    private static int id;
    private static int[] low, ids;
    private static boolean[] visited;
    private static List<List<Integer>> bridges;

    private static List<List<Integer>> findBridges(int numNodes, int[][] edges){
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i <= numNodes; i++){
            map.put(i, new HashSet<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            map.get(u).add(v);
            map.get(v).add(u);
        }

        id = 0;
        low = new int[numNodes+1];
        ids = new int[numNodes+1];
        visited = new boolean[numNodes+1];
        bridges = new ArrayList<>();

        for(int i = 0; i < numNodes; i++){
            if(!visited[i])
                dfs(i, -1, bridges, map);
        }
        return bridges;
    }

    private static void dfs(int at, int parent, List<List<Integer>> bridges, Map<Integer, Set<Integer>> map){
        visited[at] = true;
        low[at] = ids[at] = ++id;

        for(Integer to: map.get(at)){
            if(to == parent)
                continue;
            if(!visited[to]){
                dfs(to, at, bridges, map);
                low[at] = Math.min(low[at], low[to]);
                if(ids[at] < low[to]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(at);
                    temp.add(to);

                    bridges.add(temp);
                }
            }else{
                low[at] = Math.min(low[at], ids[to]);
            }
        }
    }


    public static void main(String[] args) {
        int numNodes = 6;
//        int[][] edges = {{0,1}, {0,2}, {1,2}, {2,3}, {3,4}, {2,5}, {5,6}, {6,7}, {7,8}, {8,5}};
//        int[][] edges = {{1, 2}, {1, 3}, {3, 2}, {3, 4}};
//        int[][] edges = {{9, 1},{9, 8},{1, 2},{1, 3},{1, 7},{1, 8},{2, 3},{2, 6},{2, 7},{3, 4},{3, 5},{4, 5},{4, 6},{6, 7},{7, 8}};
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {2, 5}, {4, 6}, {5, 6}};

        List<List<Integer>> result = findBridges(numNodes, edges);
        System.out.println(result);
    }
}
