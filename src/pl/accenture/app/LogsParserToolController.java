package pl.accenture.app;

import java.util.Scanner;

public class LogsParserToolController {

    private Scanner sc = new Scanner(System.in);

    public void loop() {
        OPTIONS option = null;
        while (option != OPTIONS.EXIT){
            showOptions();
            OPTIONS chooseOption = chooseOption();
            executeOption(chooseOption);
        }
    }

    private void executeOption(OPTIONS options) {
        switch(options){
            case OPEN_FIRST_TYPE_LOG_FILE -> openFirstTypeLogFile();
            case OPEN_SECOND_TYPE_LOG_FILE -> openSecondTypeLogFile();
            case OPEN_THIRD_TYPE_LOG_FILE -> openThirdTypeLogFile();
            case EXIT -> close();
        }
    }

    private void openFirstTypeLogFile() {
        
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
