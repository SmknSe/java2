package practice29_30;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static List<String> UsingStream(String str){
        List<String> res = new ArrayList<>();
        Stream
                .of(str.split("[\\p{Punct}\\s]+"))
                .collect(Collectors.groupingBy(String::toLowerCase,Collectors.counting()))
                .entrySet().stream()
                .sorted(new Comparator<Map.Entry<String, Long>>() {
                    @Override
                    public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                        if (o1.getValue().equals(o2.getValue())) return o1.getKey().compareTo(o2.getKey());
                        else return o2.getValue().compareTo(o1.getValue());
                    }
                })
                .limit(10)
                .forEach(s -> res.add(s.getKey()));
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(UsingStream(str));
    }
}
