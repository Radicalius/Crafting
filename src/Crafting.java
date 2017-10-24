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

        System.out.println("Crafting Interpreter Version 1.0.0");
        System.out.println("Type h for help and q to quit\n");
        System.out.println(recipes.get("xxx x  x "));

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
                        table += inp;
                        if (table.length() < 9) {
                            ps = "- ";
                        }else{
                            Recipe r = recipes.get(table);
                            if (r != null){
                                System.out.println(r.exec(table));
                            }else{
                                System.out.println("Error line "+(lc-2)+": invalid recipe");
                            }
                            ps = "> ";
                            table = "";
                        }
                    }else{
                        System.out.println("Error line "+lc+": unrecognized symbol");
                        ps = "> ";
                    }
                }
                lc ++;
            } catch (IOException e){}
        }
    }
}
