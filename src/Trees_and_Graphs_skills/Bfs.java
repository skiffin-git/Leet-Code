package Trees_and_Graphs_skills;
import java.util.*;
public class Bfs {
    public void printGraph(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap<>();
        queue.add(node);
        node.visited = true;
        visited.put(node, true);
        while(!queue.isEmpty()){
            Node current = queue.remove(0);
            System.out.println(current.val);
            for(Node neighbor : current.neighbors){
                if(!visited.containsKey(neighbor)) {
                    queue.add(neighbor);
                    visited.put(neighbor, true);

                }
            }
        }
    }

    // TEST
    public static void main(String[] args) {
        // create nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // create edges
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node4);

        // create graph
        Node graph = node1;

        // test printGraph method
        Bfs bfs = new Bfs();
        bfs.printGraph(graph);
    }

}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public boolean visited = false;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
