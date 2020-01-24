package pl.accenture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import pl.accenture.LineToSplit;

public class Main {
    public static final String PATH = "c:\\logs\\5c94eebe96349e13c7ade73c.5e1f4d8c9076570d0707a603-0.log";

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(PATH));
            String line = reader.readLine();

            while (line != null) {
                list.add(line);
                //read next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Elements count: ");
        System.out.println(list.size());
        //printOriginalList(list);

        ArrayList<String> afterFilterLines = list.stream()
                .filter(l -> l.contains("|us|"))
                .filter(l -> l.contains("INFO"))
                .filter(l -> !l.contains("There are no records to retrieve"))
                .filter(l -> !l.contains("No records to process"))
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("-------------------Filtered collection-----------------------");
        int lineCounter = 0;
        for (String line : afterFilterLines) {
            System.out.println(line);
            //operation on single element
            String[] splitedLine = line.split("|");
            LineToSplit line1 = new LineToSplit();


            lineCounter++;
        }
        System.out.print("Elements count after filter: ");
        System.out.println(afterFilterLines.size());
    }

    private static void printOriginalList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

