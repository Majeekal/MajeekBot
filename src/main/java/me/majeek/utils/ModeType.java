package me.majeek.utils;

import java.util.Arrays;
import java.util.List;

public enum ModeType {
    IONIAN("Ionian", Arrays.asList(1,1,0,1,1,1), Arrays.asList(0,0,0,0,0,0)),
    DORIAN("Dorian", Arrays.asList(1,0,1,1,1,0), Arrays.asList(0,1,0,0,0,1)),
    PHRYGIAN("Phrygian", Arrays.asList(0,1,1,1,0,1), Arrays.asList(1,1,0,0,1,1)),
    LYDIAN("Lydian", Arrays.asList(1,1,1,0,1,1), Arrays.asList(0,0,1,0,0,0)),
    MIXOLYDIAN("Mixolydian", Arrays.asList(1,1,0,1,1,0), Arrays.asList(0,0,0,0,0,1)),
    AEOLIAN("Aeolian", Arrays.asList(1,0,1,1,0,1), Arrays.asList(0,1,0,0,1,1)),
    LOCRIAN("Locrian", Arrays.asList(0,1,1,0,1,1), Arrays.asList(1,1,0,1,1,1));

    private String name;
    private List<Integer> steps;
    private List<Integer> pitch;

    ModeType(String name, List<Integer> steps, List<Integer> pitch){
        this.name = name;
        this.steps = steps;
        this.pitch = pitch;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getSteps() {
        return steps;
    }

    public List<Integer> getPitch(){
        return pitch;
    }
}
