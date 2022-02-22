package com.example;

public enum ActionEnum {

    TOGGLE("toggle"),
    TURN_OFF("turn off"),
    TURN_ON("turn on");

    private String value;

    ActionEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
