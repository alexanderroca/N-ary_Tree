import java.util.ArrayList;

public class NaryNode {
    static int DIMENSION_NODE;
    private Object object;
    private int key;
    private ArrayList<NaryNode> sons;

    public NaryNode(int key, Object object){
        this.key = key;
        this.object = object;
        sons = new ArrayList<>(DIMENSION_NODE);
    }

    public static int getDimensionNode() {
        return DIMENSION_NODE;
    }

    public static void setDimensionNode(int dimensionNode) {
        DIMENSION_NODE = dimensionNode;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public ArrayList<NaryNode> getSons() {
        return sons;
    }

    public void setSons(ArrayList<NaryNode> sons) {
        this.sons = sons;
    }
}
