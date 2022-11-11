package practice25_26;

import java.util.ArrayList;

public class Station {
    String number;
    ArrayList<String> names;

    public Station(String number, ArrayList<String> names) {
        this.number = number;
        this.names = names;
    }

    @Override
    public String toString() {
        return number+" "+names;
    }
}
