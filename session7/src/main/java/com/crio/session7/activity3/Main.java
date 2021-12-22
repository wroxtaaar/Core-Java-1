package com.crio.session7.activity3;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Main {
    
    public static final String FILE_SLUG = "ULTRA_LOW";
    public static final String FILE_EXTENSION = ".jpg";
    

    public static void main(String[] args) throws IOException, URISyntaxException {

        FileResourcesUtils app = new FileResourcesUtils();
        File file = app.getFileFromResource(FILE_SLUG + FILE_EXTENSION);

        BufferedImage originalImage = ImageIO.read(file);
        BufferedImage resultImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        long startTime = System.currentTimeMillis();
        recolorSingleThreaded(originalImage, resultImage);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        File outputFile = new File(FILE_SLUG + "-INVERT" + "-" + 1 + FILE_EXTENSION);
        ImageIO.write(resultImage, "jpg", outputFile);

        System.out.println("Single Thread Duration: " + String.valueOf(duration));

        startTime = System.currentTimeMillis();
        int numberOfThreads = 12; // Should be strictly > 0
        recolorMultithreaded(originalImage, resultImage, numberOfThreads);
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;

        outputFile = new File(FILE_SLUG + "-INVERT" + "-" + numberOfThreads + FILE_EXTENSION);
        ImageIO.write(resultImage, "jpg", outputFile);

        System.out.println("Number of Threads: " + numberOfThreads + " Multi Thread Duration: " + String.valueOf(duration));
 
    }

    public static void recolorMultithreaded(BufferedImage originalImage, BufferedImage resultImage, int numberOfThreads) {
        List<Thread> threads = new ArrayList<>();
        int width = originalImage.getWidth();
        int height = originalImage.getHeight() / numberOfThreads;

        for(int i = 0; i < numberOfThreads ; i++) {
            final int threadMultiplier = i;

            Thread thread = new Thread(() -> {
                int xOrigin = 0 ;
                int yOrigin = height * threadMultiplier;

                invertImage(originalImage, resultImage, xOrigin, yOrigin, width, height);
            });

            threads.add(thread);
        }

        for(Thread thread : threads) {
            thread.start();
        }

        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
        }
    }

    public static void recolorSingleThreaded(BufferedImage originalImage, BufferedImage resultImage) {
        invertImage(originalImage, resultImage, 0, 0, originalImage.getWidth(), originalImage.getHeight());
    }

    public static void invertImage(BufferedImage originalImage, BufferedImage resultImage, int leftCorner, int topCorner,
    int width, int height){
        for(int x = leftCorner ; x < leftCorner + width && x < originalImage.getWidth() ; x++) {
            for(int y = topCorner ; y < topCorner + height && y < originalImage.getHeight() ; y++) {
                int in = originalImage.getRGB(x, y);
                resultImage.setRGB(x,y,(in & 0xff000000) | ((~in) & 0x00ffffff));
            }
        }
    }
}
