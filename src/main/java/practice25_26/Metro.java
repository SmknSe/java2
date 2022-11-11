package practice25_26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Metro {
    ArrayList<Line> lines = new ArrayList<>();
    ArrayList<Station> stations = new ArrayList<>();

    public void addLine(Line line){
        lines.add(line);
    }

    public void addSt(Station station){
        stations.add(station);
    }

    @Override
    public String toString() {
        return "Metro{" +
                "lines=" + lines +
                ", stations=" + stations +
                '}';
    }
}
