package com.example;

public class Line {
    private static final String COMMA = ",";

    private ActionEnum action;
    private String startIndex;
    private String endIndex;

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }

    public String getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(String startIndex) {
        this.startIndex = startIndex;
    }

    public String getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(String endIndex) {
        this.endIndex = endIndex;
    }

    public int getXFor(String index) {
        return Integer.parseInt(index.split(COMMA)[0]);
    }

    public int getYFor(String index) {
        return Integer.parseInt(index.split(COMMA)[1]);
    }
}
