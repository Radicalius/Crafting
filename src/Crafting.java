import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by zachary on 10/22/17.
 */
public class Crafting {

    static HashMap<String, Item> vars = new HashMap<>();
    static RecipeTrie recipes = new RecipeTrie();
    static int lc = 1;

    public static void main(String[] args){
        vars.put("+",new Item("wood"));
        vars.put("s", new Item("stone"));
        vars.put(";", new Item("seed"));
        vars.put(" ",new Item(""));

        System.out.println("Crafting Interpreter Version 1.0.0");
        System.out.println("Type h for help and q to quit\n");
        System.out.println("Loaded "+recipes.size()+" recipes");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String ps = "> ";
        String table = "";

        while (true){
            System.out.print(ps);
            try {
                String inp = in.readLine();
                if (inp.equals("q")) {
                    System.exit(0);
                }else if (inp.equals("h")){
                    System.out.println("help: not implemented yet...");
                } else if (!inp.equals("")){
                    if (vars.containsKey(inp)) {
                        System.out.println(vars.get(inp));
                    } else if (inp.length() >= 3) {
                        table += inp+"\n";
                        if (table.length() < 12) {
                            ps = "- ";
                        }else{
                            try {
                                String[] tab = new String[9];
                                String[] g = table.split("\n");
                                for (int i = 0; i < 3; i++) {
                                    for (int j = 0; j < 3; j++) {
                                        String chari = Character.toString(g[i].charAt(j));
                                        if (!vars.containsKey(chari)) {
                                            throw new Exception(chari);
                                        }
                                        tab[i*3+j] = vars.get(chari).toString();
                                    }
                                }
                                Recipe r = recipes.get(tab);
                                if (r != null) {
                                    if (g[1].length() == 4){
                                        vars.put(Character.toString(g[1].charAt(3)), r.exec(table));
                                    }else {
                                        System.out.println(r.exec(table));
                                    }
                                } else {
                                    System.out.println("Error line " + (lc - 2) + ": invalid recipe");
                                }
                            } catch (Exception e){
                                System.out.println("Error line "+lc+": unrecognized symbol in recipe"+e);
                            }
                            ps = "> ";
                            table = "";
                        }
                    }else{
                        System.out.println("Error line "+lc+": unrecognized symbol");
                        ps = "> ";
                        table = "";
                    }
                }
                lc ++;
            } catch (IOException e){}
        }
    }
}
