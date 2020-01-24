package pl.accenture;

import pl.accenture.entity.firstCase.FirstCaseLogLineJobStartEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogsParserToolController {

    public static final String MUST_CONTAIN_1 = "INFO";
    public static final String JOB_START = "jobStart";
    public static final String JOB_FINISHED = "jobFinished";
    public static final String MUST_NOT_CONTAIN_1 = "There are no records to retrieve";
    public static final String MUST_NOT_CONTAIN_2 = "No records to process";
    public static final String MUST_NOT_CONTAIN_3 = "|aggregateConsumers|";
    private Scanner sc = new Scanner(System.in);

    private void openFirstTypeLogFile() {
        System.out.println("Enter relative path to file: ");
        //String pathFromUser = sc.nextLine(); //TODO uncomment to retrieve path from user
        String pathFromUser = "c:\\logs\\5c94eebe96349e13c7ade73c.5e1f4d8c9076570d0707a603-0.log";
        ArrayList<String> originalLinesListBeforeFilter = new ArrayList<>();                                            //original lines list from file as Strings

                                                                                                                        // READ FROM FILE SECTION
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(pathFromUser));
            String line = reader.readLine();

            while (line != null) {
                originalLinesListBeforeFilter.add(line);
                //read next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Incorrect file path, try again!");
            return;
        }

                                                                                                                        //MARKET STRING INPUT SECTION
        System.out.println("Enter market to search as String [example: \"us\"]");
        //String marketFromUser = sc.nextLine(); //TODO uncomment to retrieve market from user
        String marketFromUser = "us";
        String market = biuldSearchMarketString(marketFromUser);

                                                                                                                        //FILTER ADD LINES TO LIST SECTION
        ArrayList<String> afterFilterLinesListJobStart = originalLinesListBeforeFilter
                .stream()
                .filter(l -> l.contains(market))
                .filter(l -> l.contains(MUST_CONTAIN_1))
                .filter(l -> l.contains(JOB_START))
                .filter(l -> !l.contains(MUST_NOT_CONTAIN_1))
                .filter(l -> !l.contains(MUST_NOT_CONTAIN_2))
                .filter(l -> !l.contains(MUST_NOT_CONTAIN_3))
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<String[]> afterSplitLinesList = new ArrayList<>();
        for (String line : afterFilterLinesListJobStart) {
            String[] splitedLine = line.split(Pattern.quote("|"));
            afterSplitLinesList.add(splitedLine);
        }


        System.out.println("-------------------------------------------------------------");


                                                                                                                        // list of string tables after split

        //-------------------------------------

        ArrayList<FirstCaseLogLineJobStartEntity> entityList = new ArrayList();
        for (String[] lineFromSplitedList : afterSplitLinesList) {
            int lineCounter = 0;
            FirstCaseLogLineJobStartEntity firstCaseLogLineJobStartEntity = new FirstCaseLogLineJobStartEntity();
            //IF WANT CHANGE ORDER OR DELIMITER ELEMENTS IN LINE CHANGE HERE!!
            firstCaseLogLineJobStartEntity.setDate(lineFromSplitedList[0]);
            firstCaseLogLineJobStartEntity.setMarket(lineFromSplitedList[1]);
            firstCaseLogLineJobStartEntity.setJobStatus(lineFromSplitedList[2]);
            firstCaseLogLineJobStartEntity.setBatchId(lineFromSplitedList[3]);
            firstCaseLogLineJobStartEntity.setEntity(lineFromSplitedList[4]);
            firstCaseLogLineJobStartEntity.setProcessedCount(lineFromSplitedList[5]);

            entityList.add(firstCaseLogLineJobStartEntity);
            lineCounter++;
        }

        for (FirstCaseLogLineJobStartEntity firstCaseLogLineJobStartEntity : entityList) {
            //TODO uncomment if want to see entity elements
            System.out.println(firstCaseLogLineJobStartEntity.toString());
        }

        //-------------------------------------

        //PRINT INFO SECTION
        System.out.print("Original list of log elements count: ");
        System.out.println(originalLinesListBeforeFilter.size() + " lines");

        System.out.print("Elements count after filter: ");
        System.out.println(afterFilterLinesListJobStart.size());

        //System.out.println("List with startJob sequence: ");
        //afterFilterLinesListJobStart.forEach(System.out::println);
        System.out.println("-----------------------------");
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
