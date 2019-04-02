import java.util.ArrayList;

public class NaryNode {
    static int DIMENSION_NODE = 2;      // TODO: Modify it with the dimension you want
    private ArrayList<Node> nodes;
    private NaryNode parent;
    private int height;
    private ArrayList<NaryNode> sons;

    public NaryNode(){
        nodes = new ArrayList<>(DIMENSION_NODE);
        sons = null;
        height = 1;
    }

    public NaryNode(Node n){
        nodes = new ArrayList<>(DIMENSION_NODE);
        height = 1;
        addNode(n);
    }

    // Add Node to N-ary Node
    public void addNode(Node n){
            nodes.add(n);
            sortNaryNode();
    }

    // Sort N-ary Node by SelectionSort Method
    public void sortNaryNode(){
        for(int i = 0; i < nodes.size() - 1; i++){
            int min_index = i;
            for(int j = i + 1; j < nodes.size(); j++){
                if(nodes.get(j).getKey() < nodes.get(min_index).getKey())
                    min_index = j;
            }   //for
            int aux = nodes.get(min_index).getKey();
            nodes.get(min_index).setKey(nodes.get(i).getKey());
            nodes.get(i).setKey(aux);
        }   //for
    }

    public static int getDimensionNode() {
        return DIMENSION_NODE;
    }

    public static void setDimensionNode(int dimensionNode) {
        DIMENSION_NODE = dimensionNode;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public NaryNode getParent() {
        return parent;
    }

    public void setParent(NaryNode parent) {
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<NaryNode> getSons() {
        return sons;
    }

    public void setSons(ArrayList<NaryNode> sons) {
        this.sons = sons;
    }
}
