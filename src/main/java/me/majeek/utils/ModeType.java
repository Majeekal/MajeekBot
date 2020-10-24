package me.majeek.utils;

import java.util.Arrays;
import java.util.List;

public enum ModeType {
    IONIAN("Ionian", Arrays.asList(1,1,0,1,1,1)),
    DORIAN("Dorian", Arrays.asList(1,0,1,1,1,0)),
    PHRYGIAN("Phrygian", Arrays.asList(0,1,1,1,0,1)),
    LYDIAN("Lydian", Arrays.asList(1,1,1,0,1,1)),
    MIXOLYDIAN("Mixolydian", Arrays.asList(1,1,0,1,1,0)),
    AEOLIAN("Aeolian", Arrays.asList(1,0,1,1,0,1)),
    LOCRIAN("Locrian", Arrays.asList(0,1,1,0,1,1));

    private String name;
    private List<Integer> steps;

    ModeType(String name, List<Integer> steps){
        this.name = name;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getSteps() {
        return steps;
    }
}
