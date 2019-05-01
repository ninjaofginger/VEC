package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class line {
    private double x1;
    private double x2;
    private double y1;
    private double y2;

   void lineConstuctor(lineEnum.Type line,double x1 , double y1, double x2, double y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }
    public double getX1() {
        return x1;
    }
    public double getY1() {
        return y1;
    }
    public double getX2() { return x2; }
    public double getY2() { return y2; }

    String toString(double val){
       String v = String.valueOf(val);
       return  v;
    }

    double returnline(){

       return 0;
    }

    void toVEC() {
        String line = toString(getX1())+","+toString(getY1())+","+toString(getX2())+","+toString(getY2())+"/n";

        if (!Files.exists(Paths.get("C:\\cab302\\assignment2\\VEC.TXT"))) {

            // Step #1. Create a file object.
            File file = new File("C:\\cab302\\assignment2\\VEC.TXT");
            // Step #2. Create a file writer object with above file.
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Step #3. Create a file object with above file writer.
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Step #4. Prepare data to be stored in above file.


            // Step #5. Perform write operation.
            try {
                writer.write(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Step #6. free the resources.
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Path path = Paths.get("C:\\cab302\\assignment2\\VEC.TXT");

            try {
                Files.write(path, line.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    void  readVEC(){
        String fileName = "C:\\cab302\\assignment2\\VEC.TXT";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(//finish);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
