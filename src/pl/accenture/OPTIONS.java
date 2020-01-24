package pl.accenture;

import java.util.NoSuchElementException;

public enum OPTIONS {

    //menu order bellow
    EXIT (0, "Exit"),
    OPEN_FIRST_TYPE_LOG_FILE(1, "Open log file: proc-ciamtoomnidataload-api"),
    OPEN_SECOND_TYPE_LOG_FILE(2, "Open log file: unknown-type"),
    OPEN_THIRD_TYPE_LOG_FILE(3, "Open log file: unknown-type");


    private final int shortcut;
    private final String description;

    OPTIONS(int shortcut, String description) {
        this.shortcut = shortcut;
        this.description = description;
    }

    public int getShortcut() {
        return shortcut;
    }

    @Override
    public String toString() {
        return shortcut + "-" + description;
    }

    public static OPTIONS convertToOption(int option){
        if(option < 0 || option >=OPTIONS.values().length){
            throw new NoSuchElementException();
        }
        return OPTIONS.values()[option];
    }
}
