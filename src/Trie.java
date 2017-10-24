import java.util.HashMap;

/**
 * Created by zachary on 10/22/17.
 */
public class Trie {

    private int size  = 0;

    static class Node{
        Recipe recipe;
        HashMap<String, Node> child = new HashMap<>();

        public Node(Recipe r){
            recipe = r;
        }

        public Recipe get(String[] table, int ind){
            if (table.length - ind == 0){
                return recipe;
            }
            String first = table[ind];
            if (child.containsKey(first)){
                return child.get(first).get(table, ind+1);
            }else{
                return null;
            }
        }

        public void put(String[] rep,int ind, Recipe r){
            String first = rep[ind];
            if (rep.length - ind == 1) {
                child.put(first, new Node(r));
            } if (rep.length - ind > 1){
                if (child.containsKey(first)){
                    child.get(first).put(rep,ind+1,r);
                }else{
                    child.put(first, new Node(r));
                    child.get(first).put(rep, ind+1, r);
                }
            }
        }
    }

    private Node master;

    public Trie() {
        master = new Node(null);
    }

    public Recipe get(String[] table){
        return master.get(table,0);
    }

    public void put(Recipe r){
        master.put(r.rep, 0, r);
        size++;
    }

    public int size(){
        return size;
    }
}
