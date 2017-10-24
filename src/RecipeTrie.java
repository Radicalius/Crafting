/**
 * Created by zachary on 10/22/17.
 */
public class RecipeTrie extends Trie {

    static class Stick extends Recipe{
        public Stick() {
            rep = new String[] {"wood","","","wood","","","","",""};
        }
        public Item exec(String table){
            return new Item("stick");
        }
    }

    static class Pickaxe extends Recipe{
        public Pickaxe(){
            rep = new String[] {"wood","wood","wood","","stick","","","stick",""};
        }
        public Item exec(String table){
            return new Item("pickaxe");
        }
    }

    static class Axe extends Recipe {
        public Axe(){
            rep = new String[] {"","wood","wood","","stick","wood","","stick",""};
        }
        public Item exec(String table){
            return new Item("axe");
        }
    }

    static class Hoe extends Recipe {
        public Hoe(){
            rep = new String[] {"","wood","wood","","stick","","","stick",""};
        }
        public Item exec(String table){
            return new Item("hoe");
        }
    }

    public RecipeTrie(){
        super();

        Pickaxe p = new Pickaxe();
        put(p);

        Stick s = new Stick();
        put(s);

        Axe a = new Axe();
        put(a);

        Hoe h = new Hoe();
        put(h);
    }
}
