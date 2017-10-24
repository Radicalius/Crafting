import java.util.HashMap;

/**
 * Created by zachary on 10/22/17.
 */
public class Trie {

    static class Node{
        Recipe recipe;
        HashMap<Character, Node> child = new HashMap<>();

        public Node(Recipe r){
            recipe = r;
        }

        public Recipe get(String table){
            if (table.equals("")){
                return recipe;
            }
            char first = table.charAt(0);
            if (child.containsKey(first)){
                String subs = table.substring(1);
                return child.get(first).get(subs);
            }else{
                return null;
            }
        }

        public void put(String rep, Recipe r){
            char first = rep.charAt(0);
            String subs = rep.substring(1);
            if (rep.length() == 1) {
                child.put(first, new Node(r));
            } if (rep.length() > 1){
                if (child.containsKey(first)){
                    child.get(first).put(subs,r);
                }else{
                    child.put(first, new Node(r));
                    child.get(first).put(subs, r);
                }
            }
        }
    }

    private Node master;

    public Trie() {
        master = new Node(null);
    }

    public Recipe get(String table){
        return master.get(table);
    }

    public void put(Recipe r){
        master.put(r.rep, r);
    }
}
