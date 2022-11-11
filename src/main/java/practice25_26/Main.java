package practice25_26;

import com.google.gson.Gson;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            String[] substr;
            InputStream in;
            Metro metro = new Metro();
            org.jsoup.nodes.Document document = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
            org.jsoup.select.Elements lines = document.select("span[data-line]");
            for (org.jsoup.nodes.Element element : lines) {
//                String srcelem = element.attr("abs:src");
//                if (srcelem != "" && (srcelem.contains(".png") || srcelem.contains(".svg") || srcelem.contains(".jpg") || srcelem.contains(".webp"))) {
//                    System.out.println(srcelem);
//                    substr = srcelem.split("/");
//                    URL url = new URL(srcelem);
//                    in = url.openStream();
//                    Files.copy(in, Paths.get("C:\\Users\\semey\\IdeaProjects\\java2\\src\\main\\java\\practice23_24\\n24\\images\\" + substr[substr.length - 1]), StandardCopyOption.REPLACE_EXISTING);
//                    in.close();
//                }
                metro.addLine(new Line(element.attr("data-line"),element.text()));
                ArrayList<String> arr_st = new ArrayList<>();
                org.jsoup.select.Elements stations = document.select("div[data-line='"+element.attr("data-line")+"'] span.name");
                for (org.jsoup.nodes.Element st : stations){
                    arr_st.add(st.text());
                }
                metro.addSt(new Station(element.attr("data-line"),arr_st));
            }
            Gson gson = new Gson();
            System.out.println(gson.toJson(metro));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
