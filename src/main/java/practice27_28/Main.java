package practice27_28;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main
{
    public static void main(String[] args)
    {
        String srcFolder = "src/main/java/practice27_28/images";
        String dstFolder = "src/main/java/practice27_28/dst";
        int threadNum=0,c=0;
        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        try
        {
            if (!Files.exists(Paths.get(dstFolder)))
            {
                Files.createDirectories(Paths.get(dstFolder));
            }

            for(File file : files)
            {
                if (Runtime.getRuntime().availableProcessors() - threadNum >0){
                    threadNum+=1;
                    new Thread(
                            new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        System.out.println(Thread.currentThread().getName());
                                        reduce(file,dstFolder);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                    ).start();
                    threadNum-=1;
                }
                else {
                    reduce(file,dstFolder);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }

    public static void reduce(File file, String dstFolder) throws IOException {
        System.out.println("|"+Thread.currentThread().getName());
        BufferedImage image = ImageIO.read(file);
        if(image == null) {
            return;
        }

        int newWidth = image.getWidth() / 2;
        int newHeight = (int) Math.round(
                image.getHeight() / (image.getWidth() / (double) newWidth)
        );
        BufferedImage newImage = new BufferedImage(
                newWidth, newHeight, BufferedImage.TYPE_INT_RGB
        );

        int widthStep = image.getWidth() / newWidth;
        int heightStep = image.getHeight() / newHeight;

        for (int x = 0; x < newWidth; x++)
        {
            for (int y = 0; y < newHeight; y++) {
                int rgb = image.getRGB(x * widthStep, y * heightStep);
                newImage.setRGB(x, y, rgb);
            }
        }

        File newFile = new File(dstFolder + "/" + file.getName());
        ImageIO.write(newImage, "jpg", newFile);
    }
}
