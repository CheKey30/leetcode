/*
There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
*/
class Solution {
    int T=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // use a timestamp, for each node, check the smallest timestamp that can reach from the node
        // construct the graph
        List[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(List<Integer> conn:connections){
            graph[conn.get(0)].add(conn.get(1));
            graph[conn.get(1)].add(conn.get(0));
        }
        // to save the timestamp we meet each node
        int[] timestamp = new int[n];

        // for each node, run dfs and return the smallest timestamp in all its children except its parent
        List<List<Integer>> criticalConns = new ArrayList<>();
        dfs(n,graph,timestamp,0,-1,criticalConns);
        return criticalConns;
    }

    // return the minimum timestamp it ever visited in all the neighbors
    public int dfs(int n, List[] graph, int[] timestamps, int i, int parent, List<List<Integer>> criticalConns){
        if(timestamps[i]!=0){
            return timestamps[i];
        }
        timestamps[i] = T++;
        int minTimestamp = Integer.MAX_VALUE;
        for(int neighbor:(List<Integer>)graph[i]){
            // no need to check parent
            if(neighbor == parent){
                continue;
            }
            int neighborTimeStamp = dfs(n,graph,timestamps,neighbor,i,criticalConns);
            minTimestamp = Math.min(minTimestamp,neighborTimeStamp);
        }
        
        if(minTimestamp>=timestamps[i]){
            if(parent>=0){
                criticalConns.add(Arrays.asList(parent,i));
            }
        }
        return Math.min(timestamps[i],minTimestamp);
    }
}