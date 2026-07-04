You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.

The score of a path between two cities is defined as the minimum distance of a road in this path.

Return the minimum possible score of a path between cities 1 and n.

Note:

    A path is a sequence of roads between two cities.
    It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
    The test cases are generated such that there is at least one path between 1 and n.


Intuition

The key idea for this question is to find the minimum edge weights in the connected components from the given graph that are containing node 1 and node n.
Approach

1-create an adjacency list with the help of map for which the key denotes the current node and the value denotes the pair of adjacent neighbours along with the cost required to reach them.
2-do the thing above for the edges 1 to n.
3-create a boolean flag array that will be used to keep the track of all the visited nodes.
4-implement the bfs algorithm on the given graph.
5-find the minimum edge weight among all roads in the connected component containing node 1. Since the problem guarantees that a path exists from 1 to n, node n belongs to the same connected component.
Complexity

    Time complexity:

O(V+E)

    Space complexity:

O(V+E)

class Solution {
    public int minScore(int n, int[][] roads) {
       boolean[] flag = new boolean[n+1];
       Arrays.fill(flag,false);
       Map<Integer,ArrayList<int[]>> map = new HashMap<>();
       while(n>0){
        map.put(n,new ArrayList<int[]>());
        n--;
       }
       for(int[] arr:roads){
        map.get(arr[0]).add(new int[] {arr[1],arr[2]});
        map.get(arr[1]).add(new int[] {arr[0],arr[2]});
       }
       int min = Integer.MAX_VALUE;
       Queue<Integer> queue = new LinkedList<>();
       queue.offer(1);
       flag[1] = true;
       while(!queue.isEmpty()){
        int val = queue.poll();
        for(int[] aa:map.get(val)){
            min = Math.min(aa[1],min);
            if(!flag[aa[0]]){
                queue.offer(aa[0]);
                flag[aa[0]] = true;
            }
        }
       }
       return min;
    }
};
