import java.io.*;
import java.util.*;
import java.util.regex.*;

public class lab3 {

    public static void main(String[] args) {

        String text = readFile("input.txt");
        Pattern pattern = Pattern.compile("\\b([a-z0-9._-]+@[a-z0-9.-]+)\\b");

        Matcher matcher = pattern.matcher(text);
        List phones = new ArrayList();
        while (matcher.find()) {
            int start=matcher.start();
            int end=matcher.end();
            phones.add(text.substring(start,end));
            System.out.println("Найдено совпадение " + text.substring(start,end) + " с "+ start + " по " + (end-1) + " позицию");
        }
        Collections.sort(phones);
        System.out.println(phones);
        writeHtml(phones, "output.txt");
    }

    public static String readFile(String emailPath) {
        try (FileReader reader = new FileReader(emailPath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String text = "";
            while(bufferedReader.ready()) {
                text = text.concat(bufferedReader.readLine());
            }
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeHtml(List emailPath, String htmlPath) {
        try (FileWriter writer = new FileWriter(htmlPath);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(String.valueOf(emailPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}