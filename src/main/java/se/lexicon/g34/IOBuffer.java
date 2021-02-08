package se.lexicon.g34;

import java.io.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOBuffer {
    public static void main(String[] args){
        List<String> text= Arrays.asList("A","text","Written");

    File path = new File("E:\\JavaProjekt\\IOBuffer\\text.txt)");
    writeText(path,text);
    for (String string:readText(path)) {
        System.out.println(string);
    }
    }

    public static List<String> writeText(File destination,List<String> src) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String toWrite:src){
                writer.write(toWrite);
                writer.newLine();
            }
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return src;
    }

    public static List<String> readText(File source) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

}
