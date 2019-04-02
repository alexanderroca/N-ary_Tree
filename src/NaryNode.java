import java.util.ArrayList;

public class NaryNode {
    static int DIMENSION_NODE;
    private ArrayList<Node> sons;
    private NaryNode parent;

    public NaryNode(){
        sons = new ArrayList<>(DIMENSION_NODE);
    }

    public boolean addChild(Node n){
        boolean ok = false;
        if(sons.size() < DIMENSION_NODE) {
            sons.add(n);
            ok = true;
        }   //if
        return ok;
    }

    public static int getDimensionNode() {
        return DIMENSION_NODE;
    }

    public static void setDimensionNode(int dimensionNode) {
        DIMENSION_NODE = dimensionNode;
    }

    public ArrayList<Node> getSons() {
        return sons;
    }

    public void setSons(ArrayList<Node> sons) {
        this.sons = sons;
    }

    public NaryNode getParent() {
        return parent;
    }

    public void setParent(NaryNode parent) {
        this.parent = parent;
    }
}
