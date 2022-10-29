package practice23_24.n24;

import org.jsoup.Jsoup;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class main {
    public static void main(String[] args) {
        try {
            String[] substr;
            InputStream in;
            org.jsoup.nodes.Document document = Jsoup.connect("https://www.mirea.ru/").get();
            org.jsoup.select.Elements titleElements = document.select("img");
            for (org.jsoup.nodes.Element element : titleElements) {
                String srcelem = element.attr("abs:src");
                if (srcelem != "" && (srcelem.contains(".png") || srcelem.contains(".svg") || srcelem.contains(".jpg") || srcelem.contains(".webp"))) {
                    System.out.println(srcelem);
                    substr = srcelem.split("/");
                    URL url = new URL(srcelem);
                    in = url.openStream();
                    Files.copy(in, Paths.get("C:\\Users\\semey\\IdeaProjects\\java2\\src\\main\\java\\practice23_24\\n24\\images\\" + substr[substr.length - 1]), StandardCopyOption.REPLACE_EXISTING);
                    in.close();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
