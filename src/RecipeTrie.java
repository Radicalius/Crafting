/**
 * Created by zachary on 10/22/17.
 */
public class RecipeTrie extends Trie {

    static class Pickaxe extends Recipe{
        public Pickaxe(){
            rep = "xxx x  x ";
        }
        public Item exec(String table){
            return new Item("pickaxe");
        }
    }

    public RecipeTrie(){
        super();

        Pickaxe p = new Pickaxe();
        put(p);
    }
}
