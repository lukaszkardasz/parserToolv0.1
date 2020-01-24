package pl.accenture.app;

import java.util.NoSuchElementException;

public enum OPTIONS {

    OPEN_FIRST_TYPE_LOG_FILE(0, "Open log file: proc-ciamtoomnidataload-api"),
    OPEN_SECOND_TYPE_LOG_FILE(1, "Open log file: unknown-type"),
    OPEN_THIRD_TYPE_LOG_FILE(2, "Open log file: unknown-type"),
    EXIT (3, "Exit");

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
