package review;

import java.util.ArrayList;

public class Wombats implements Cloneable {
    private ArrayList<String> names;

    public static void main(String[] args) throws CloneNotSupportedException {
        Wombats original = new Wombats();
        original.names = new ArrayList<>();
        Wombats cloned = (Wombats) original.clone();
        System.out.println(original.getNames() == cloned.getNames());
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }
}
