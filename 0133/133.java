/*
Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

 

Example:



Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        HashMap<Node,Node> map = new HashMap<>();
        map.put(node,new Node(node.val,new ArrayList<>()));
        while(!queue.isEmpty()){
            Node n = queue.poll();
            for(Node x: n.neighbors){
                if(!map.containsKey(x)){
                    map.put(x,new Node(x.val,new ArrayList<>()));
                    queue.add(x);
                }
                map.get(n).neighbors.add(map.get(x));
            }
        }
        return map.get(node);
    }
}
}