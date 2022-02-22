package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LightsShow {

    private final boolean[][] LIGHT_MATRIX = new boolean[1000][1000];

    public int startShow(String input) throws IOException {
        FileReader reader = new FileReader(input);
        BufferedReader buffer = new BufferedReader(reader);

        initialState();
        String currentLine = buffer.readLine();

        while (currentLine != null) {
            Line line = parseLine(currentLine);
            applyAction(
                    line.getXFor(line.getStartIndex()),
                    line.getYFor(line.getStartIndex()),
                    line.getXFor(line.getEndIndex()),
                    line.getYFor(line.getEndIndex()),
                    line.getAction()
            );
            currentLine = buffer.readLine();
        }

        return getResult();
    }

    private Line parseLine(String input) {
        ActionEnum action = findAction(input);
        String restOfLine = input.substring(input.indexOf(action.value()) + action.value().length() + 1);
        String[] indexes = restOfLine.split(" ");
        Line line = new Line();
        line.setAction(action);
        line.setStartIndex(indexes[0]);
        line.setEndIndex(indexes[2]);
        return line;
    }

    private ActionEnum findAction(String line) {
        boolean isTurnOn = line.contains(ActionEnum.TURN_ON.value());
        boolean isTurnOff = line.contains(ActionEnum.TURN_OFF.value());

        if (isTurnOn) {
            return ActionEnum.TURN_ON;
        }

        if (isTurnOff) {
            return ActionEnum.TURN_OFF;
        }
        return ActionEnum.TOGGLE;
    }

    private void initialState() {
        for (int i = 0; i < LIGHT_MATRIX.length; i++) {
            for (int j = 0; j < LIGHT_MATRIX.length; j++) {
                LIGHT_MATRIX[i][j] = false;
            }
        }
    }

    private void applyAction(int startX, int startY, int endX, int endY, ActionEnum action) {
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (action == ActionEnum.TOGGLE) {
                    LIGHT_MATRIX[i][j] = !LIGHT_MATRIX[i][j];
                } else {
                    LIGHT_MATRIX[i][j] = action == ActionEnum.TURN_ON;
                }
            }
        }
    }

    private int getResult() {
        int lightsOn = 0;

        for (int i = 0; i < LIGHT_MATRIX.length; i++) {
            for (int j = 0; j < LIGHT_MATRIX.length; j++) {
                if (LIGHT_MATRIX[i][j]) {
                    lightsOn++;
                }
            }
        }
        System.out.println("Lights on: " + lightsOn);
        return lightsOn;
    }
}
