import java.util.ArrayList;

public class NaryNode {
    static int DIMENSION_NODE;
    private ArrayList<Node> sons;
    private NaryNode parent;
    private int height;
    private NaryTree right;
    private NaryTree center;
    private NaryTree left;

    public NaryNode(){
        sons = new ArrayList<>(DIMENSION_NODE);
        right = null;
        center = null;
        left = null;
        height = 1;
    }

    // Add Node to N-ary Node
    public boolean addChild(Node n){
        boolean ok = false;
        if(sons.size() < DIMENSION_NODE) {
            sons.add(n);
            sortNaryNode();
            ok = true;
        }   //if
        return ok;
    }

    // Sort N-ary Node by SelectionSort Method
    public void sortNaryNode(){
        for(int i = 0; i < sons.size() - 1; i++){
            int min_index = sons.get(i).getKey();
            for(int j = i + 1; j < sons.size(); j++){
                if(sons.get(j).getKey() < sons.get(min_index).getKey())
                    min_index = j;

            }   //for
            int aux = sons.get(min_index).getKey();
            sons.get(min_index).setKey(sons.get(i).getKey());
            sons.get(i).setKey(sons.get(aux).getKey());
        }   //for
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public NaryTree getRight() {
        return right;
    }

    public void setRight(NaryTree right) {
        this.right = right;
    }

    public NaryTree getCenter() {
        return center;
    }

    public void setCenter(NaryTree center) {
        this.center = center;
    }

    public NaryTree getLeft() {
        return left;
    }

    public void setLeft(NaryTree left) {
        this.left = left;
    }
}
