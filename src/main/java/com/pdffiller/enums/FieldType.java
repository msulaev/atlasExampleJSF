package com.pdffiller.enums;

public enum FieldType {

    TEXT("Text"),
    NUMBER("Number"),
    DATE("Date"),
    DROPDOWN("Dropdown"),
    CHECKBOX("Checkbox"),
    SIGNATURE("Signture"),
    INITIALS("Initials"),
    IMAGE("Image"),
    FORMULA("Formula"),
    RADIO_BUTTON("Radio Button");

    private String textOnButton;

    FieldType(String textOnButton) {
        this.textOnButton = textOnButton;
    }

    @Override
    public String toString() {
        return "FieldType{" +
                "textOnButton='" + textOnButton + '\'' +
                '}';
    }
}
