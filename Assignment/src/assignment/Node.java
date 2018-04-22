package assignment;

import java.util.ArrayList;


public class Node implements Comparable<Node>{
//public class Node{
    int id;
    ArrayList<Node> neighbours;
    int distance = Integer.MAX_VALUE;
    Node lastNode;
    
    @Override
    public int compareTo(Node node) {
      return Integer.valueOf(distance).compareTo(node.distance);
    }
    
    public Node(int id){
        this.id=id;
        this.neighbours= new ArrayList<Node>();
    }
    
    public void addNeighbour(Node node){
        this.neighbours.add(node);
    }
    
//     public String alphaID()
//    {
//        return new Character((char)('A' + id)).toString();
//    }
   
    public int alphaID(){
        return id+1;
    }
}
