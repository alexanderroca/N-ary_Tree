import java.util.ArrayList;

public class NaryTree {
    public NaryNode root;
    public boolean inserted;

    public boolean insert_T(int key){
        try {
            inserted = false;
            root = insert(root, key);
            return true;
        } catch (NodeAlreadyExists nodeAlreadyExists) {
            System.out.println(nodeAlreadyExists.getMessage() + key);
            return false;
        }
    }

    // Insertion of a new Node to the N-ary Tree
    public NaryNode insert(NaryNode n_ary, int key) throws NodeAlreadyExists {
        if(n_ary == null)
            return new NaryNode(new Node(key, null));   //TODO: Insert type of Object to use
        else{
            root = goNode(n_ary, key);
        }   //else
        return root;
    }

    // Travel the N-Node
    public NaryNode goNode(NaryNode n_ary, int key) throws NodeAlreadyExists{
        int i = 0;
        while(!inserted){
            if (key == n_ary.getNodes().get(i).getKey())
                throw new NodeAlreadyExists();
            else {
                if(n_ary.getSons() != null){
                    choseBestSon(n_ary, key);
                }   //if
                if (n_ary.getNodes().size() == NaryNode.DIMENSION_NODE) {
                    n_ary.addNode(new Node(key, null));  //TODO: Insert type of Object to use
                    split(n_ary);
                }   //if
                else if(n_ary.getSons() == null){
                    n_ary.addNode(new Node(key, null)); //TODO: Insert type of Object to use
                    inserted = true;
                }   //else
            }   //else
            i++;
        }   //while
        System.out.println("HERE");
        return root;
    }

    // Select best son to check the key
    public void choseBestSon(NaryNode n_ary, int key) throws NodeAlreadyExists {
        for(int i = 0; i < n_ary.getSons().size(); i++){
            try {
                if (key < n_ary.getNodes().get(i).getKey()) {
                    goNode(n_ary.getSons().get(i), key);
                }   //if
            }catch(IndexOutOfBoundsException e){
                goNode(n_ary.getSons().get(n_ary.getSons().size() - 1), key);
            }
        }   //for
    }

    // Split the actual Node
    public void split(NaryNode n_ary){
        Node candidate = n_ary.getNodes().get(n_ary.getNodes().size() / 2);
        NaryNode new_parent_n_ary = new NaryNode();
        NaryNode new_right_n_ary = new NaryNode();
        NaryNode new_left_n_ary = new NaryNode();
        new_parent_n_ary.setSons(new ArrayList<>());
        new_parent_n_ary.addNode(candidate);
        for(int i = 0; i < (n_ary.getNodes().size() / 2); i++){
            new_left_n_ary.addNode(n_ary.getNodes().get(i));
        }   //for
        for(int i = (n_ary.getNodes().size() / 2) + 1; i < n_ary.getNodes().size(); i++){
            new_right_n_ary.addNode(n_ary.getNodes().get(i));
        }   //for
        new_parent_n_ary.getSons().add(new_left_n_ary);
        new_parent_n_ary.getSons().add(new_right_n_ary);
        new_parent_n_ary.setHeight(n_ary.getHeight() + 1);
        new_left_n_ary.setParent(new_parent_n_ary);
        new_right_n_ary.setParent(new_parent_n_ary);
        setRoot(new_parent_n_ary);    //TODO: Comprovar casos
        inserted = true;
    }

    public NaryNode getRoot() {
        return root;
    }

    public void setRoot(NaryNode root) {
        this.root = root;
    }
}
