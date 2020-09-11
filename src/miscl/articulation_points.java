package miscl;

import java.util.*;

// Reference Link: https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory/ArticulationPointsAdjacencyList.java
// Video Link: https://www.youtube.com/watch?v=aZXi1unBdJA

public class articulation_points {

    private static int id, rootNodeOutcomingEdgeCount;
    private static int[] ids, low;
    private static boolean[] visited, isArticulationPoint;

    private static int[] getCriticalRouters(int numNodes, int numEdges, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < numNodes; i++){
            map.put(i, new HashSet<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            map.get(u).add(v);
            map.get(v).add(u);
        }

        id = 0;
        ids = new int[numNodes];
        low = new int[numNodes];
        visited = new boolean[numNodes];
        isArticulationPoint = new boolean[numNodes];
//        isArticulationPoint = new int[numNodes];

        for(int i = 0; i < numNodes; i++){
            if(!visited[i]){
                rootNodeOutcomingEdgeCount = 0;
                dfs(i, i, -1, map);
                isArticulationPoint[i] = (rootNodeOutcomingEdgeCount > 1);
//                if(rootNodeOutcomingEdgeCount > 1)
//                    isArticulationPoint[i] = 1;
            }
        }

//        List<Integer> result = new ArrayList<>();
//        for(int i: isArticulationPoint)
//            result.add(Integer.valueOf(i));
//        return result;
//        return isArticulationPoint;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < isArticulationPoint.length; i++){
            if(isArticulationPoint[i])
                result.add(i);
        }
        int[] output = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            output[i] = result.get(i);
        }
        return output;
    }

    private static void dfs(int root, int at, int parent,  Map<Integer, Set<Integer>> map){
        if(parent == root)
            rootNodeOutcomingEdgeCount++;
        visited[at] = true;
        low[at] = ids[at] = id++;
        for(Integer to: map.get(at)){
            if(to == parent)
                continue;
            if(!visited[to]){
                dfs(root, to, at, map);
                low[at] = Math.min(low[at], low[to]);
                if(ids[at] <= low[to]){
                    isArticulationPoint[at] = true;
//                    isArticulationPoint[at] = 1;
                }
            }else {
                low[at] = Math.min(low[at], ids[to]);
            }
        }
    }

    public static void main(String[] args) {
        int numNodes = 7;
        int numEdges = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};

        int[] result = getCriticalRouters(numNodes, numEdges, edges);
        for(int b: result)
            System.out.println(b);
//        List<Integer> result = getCriticalRouters(numNodes, numEdges, edges);
//        System.out.println(result);
    }
}
