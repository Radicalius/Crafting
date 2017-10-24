/**
 * Created by zachary on 10/23/17.
 */
public class Item {
    String type;

    public Item(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }
}
