package pl.accenture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();


        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("c:\\logs\\5c94eebe96349e13c7ade73c.5e1f4d8c9076570d0707a603-0part.log"));
            String line = reader.readLine();
            while (line != null) {
                list.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


/*        ArrayList<String> afterFilterLines = list.stream()
                .filter(l -> !(l.contains("|us|")))
                .filter(l -> l.isEmpty())
                .filter(l -> l.contains("WARN"))
                .collect(Collectors.toCollection(ArrayList::new));

        //System.out.println(Arrays.toString(afterFilterLines.toArray()));
        for (String afterFilterLine : afterFilterLines) {
            System.out.println(afterFilterLine);
        }*/
}
}
