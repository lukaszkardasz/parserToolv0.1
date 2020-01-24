package pl.accenture.app;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class LogsParserToolController {

    private Scanner sc = new Scanner(System.in);

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

    private void openFirstTypeLogFile() {
        System.out.println("Enter relative path to file: ");
        String pathFromUser = sc.nextLine();
        System.out.println(pathFromUser);
    }

    private void openSecondTypeLogFile() {
        System.out.println("not implemented yet :/");
    }

    private void openThirdTypeLogFile() {
        System.out.println("not implemented yet :/");
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

    private void close() {
        System.out.println("Bye bye!");
        sc.close();
        System.exit(0);
    }
}
