
package assignment;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Graph extends Map{

    private Node[] nodes;
    private int start;

    public Graph(int size, int b) {
        super(size);
        nodes= new Node[b];
        
        
    }
    
   
    private void createNodes(){
        for(int i=0;i<nodes.length;i++){
            Node node= new Node(i);
            nodes[i]= node;
            nodes[i].lastNode=nodes[i];
        }
        
        for(int row=0;row<nodes.length;row++){
            for(int col=0;col<nodes.length;col++){
                if(adjacencyMatrix[row][col]!=0){
                    nodes[row].addNeighbour(nodes[col]);
                }
            }
        }
        
    }
    
    public void setStartingNode(int num){
        this.start=num;
    }
    
    public void runDijkstra()
    {
        nodes[start].distance = 0;                                

        PriorityQueue<Node> queue = new PriorityQueue<Node>(Arrays.asList(nodes));      
        while (!queue.isEmpty()) {                                
            Node current = queue.poll();                         

            for (Node neighbor : current.neighbours)               
            {
                int weight = weight(current, neighbor);            
                int newDistance =
                        (current.distance == Integer.MAX_VALUE ?   
                                0 :
                                current.distance
                        )
                                + weight;

                if (newDistance < neighbor.distance) {             
                    neighbor.distance = newDistance;               
                    neighbor.lastNode = current;                
                }
            }
        }
    }
    private int weight(Node a,Node b){
        return adjacencyMatrix[a.id][b.id];
    }
    
     public void printOutput()
    {
        for (Node nd : nodes) {
            System.out.print(String.format("Node %s | Distance %-2d | Last Visited %s | ",
                                            nd.alphaID(),
                                                         nd.distance,
                                                                        nd.lastNode.alphaID()));

            getPathOfNode(nd.id);
        }
    }
     

    public void getPathOfNode(int index)
    {
      
        if (index >= nodes.length) { System.err.println("Invalid Node"); return; }

        System.out.print("The shortest path between [Node " + nodes[index].alphaID() +
                "] and [The Starting Node (" + nodes[start].alphaID() + ")] is [");

        Node dest = nodes[index];
        System.out.print(dest.alphaID());

        while (true) {
            if (dest == dest.lastNode) {
                
                break;
            }

           
            dest = dest.lastNode;

            System.out.print("-" + dest.alphaID());
        }
        System.out.println("].");
    }
}

