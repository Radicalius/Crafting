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

    static class Cobblestone extends Recipe {
        public Cobblestone(){
            rep = new String[] {"stone","","","","pickaxe","","","",""};
        }
        public Item exec(String table){
            return new Item("cobblestone");
        }
    }

    static class Furnace extends Recipe {
        public Furnace(){
            rep = new String[] {"cobblestone","cobblestone","cobblestone","cobblestone","","cobblestone","cobblestone","cobblestone","cobblestone"};
        }
        public Item exec(String table){
            return new Item("furnace");
        }
    }

    static class Charcoal extends Recipe {
        public Charcoal(){
            rep = new String[] {"wood","","","","furnace","","","",""};
        }

        public Item exec(String table) {
            return new Item("charcoal");
        }
    }

    static class Switch extends Recipe {
        public Switch(){
            rep = new String[] {"","","","","stick","","cobblestone","cobblestone","cobblestone"};
        }
        public Item exec(String table){
            return new Item("switch");
        }
    }

    static class Torch extends Recipe{
        public Torch(){
            rep = new String[] {"charcoal","","","stick","","","","",""};
        }
        public Item exec(String table){
            return new Item("torch");
        }
    }

    static class Button extends Recipe{
        public Button(){
            rep = new String[] {"","","","","wood","","","",""};
        }
        public Item exec(String table){
            return new Item("button");
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

        Cobblestone cs = new Cobblestone();
        put(cs);

        Furnace f = new Furnace();
        put(f);

        Charcoal c = new Charcoal();
        put(c);

        Torch t = new Torch();
        put(t);

        Switch sw = new Switch();
        put(sw);

        Button b = new Button();
        put(b);
    }
}
