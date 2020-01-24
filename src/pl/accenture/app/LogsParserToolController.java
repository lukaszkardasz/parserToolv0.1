package pl.accenture.app;

import pl.accenture.LineToSplit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LogsParserToolController {

    public static final String MUST_CONTAIN_1 = "INFO";
    public static final String MUST_NOT_CONTAIN_1 = "There are no records to retrieve";
    public static final String MUST_NOT_CONTAIN_2 = "No records to process";
    private Scanner sc = new Scanner(System.in);

    private void openFirstTypeLogFile() {
        System.out.println("Enter relative path to file: ");
        String pathFromUser = sc.nextLine();
        ArrayList<String> originalLinesList = new ArrayList<>();                                                        //original lines list from file as Strings

                                                                                                                        // READ FROM FILE SECTION
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(pathFromUser));
            String line = reader.readLine();

            while (line != null) {
                originalLinesList.add(line);
                //read next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Incorrect file path, try again!");
            return;
        }

                                                                                                                        //MARKET STRING INPUT SECTION
        System.out.println("Enter market to search as String [example: \"us\"]");
        String marketFromUser = sc.nextLine();
        String market = biuldSearchMarketString(marketFromUser);

                                                                                                                        //FILTER ADD LINES TO LIST SECTION
        ArrayList<String> afterFilterLinesList = originalLinesList.stream()
                .filter(l -> l.contains(market))
                .filter(l -> l.contains(MUST_CONTAIN_1))
                .filter(l -> !l.contains(MUST_NOT_CONTAIN_1))
                .filter(l -> !l.contains(MUST_NOT_CONTAIN_2))
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("-------------------------------------------------------------");
        int lineCounter = 0;
        for (String line : afterFilterLinesList) {
            System.out.println(line);
                                                                                                                        //operation on single element
            String[] splitedLine = line.split("|");
            LineToSplit line1 = new LineToSplit();


            lineCounter++;
        }
                                                                                                                        //PRINT INFO SECTION
        System.out.print("Original list of log elements count: ");
        System.out.println(originalLinesList.size() + " lines");

        System.out.print("Elements count after filter: ");
        System.out.println(afterFilterLinesList.size());
    }

    static private String biuldSearchMarketString(String marketFromUser) {
        String market;
        market = "|" + marketFromUser + "|";
        return market;
    }
    private void openSecondTypeLogFile() {
        System.out.println("not implemented yet :P");
    }
    private void openThirdTypeLogFile() {  System.out.println("not implemented yet :P"); }
    public void loop() {
        OPTIONS option = null;
        while (option != OPTIONS.EXIT){
            try {
                showOptions();
                OPTIONS chooseOption = chooseOption();
                executeOption(chooseOption);
            } catch (NoSuchElementException e) {
                System.out.println("Illegal operation, try again!");
            }
        }
    }
    private void showOptions() {
        System.out.println(">>>>>>> Options:");
        for (OPTIONS option : OPTIONS.values()) {
            System.out.println(option);
        }
    }
    private OPTIONS chooseOption() {
        int option = sc.nextInt();
        sc.nextLine();
        return OPTIONS.convertToOption(option);
    }
    private void executeOption(OPTIONS options) {
        switch(options){
            case OPEN_FIRST_TYPE_LOG_FILE : openFirstTypeLogFile();
                break;
            case OPEN_SECOND_TYPE_LOG_FILE : openSecondTypeLogFile();
                break;
            case OPEN_THIRD_TYPE_LOG_FILE : openThirdTypeLogFile();
                break;
            case EXIT : close();
            default : throw new NoSuchElementException();
        }
    }
    private void close() {
        System.out.println("Bye bye!");
        sc.close();
        System.exit(0);
    }
}
