package me.majeek.utils;

public enum Note {
    A_FLAT("Ab"), // Finished
    A("A"), // Finished
    A_SHARP("A#"), // Finished
    B_FLAT("Bb"), // Finished
    B("B"), // Finished
    B_SHARP("B#"), // Finished
    C_FLAT("Cb"), // Finished
    C("C"), // Finished
    C_SHARP("C#"), // Finished
    D_FLAT("Db"), // Finished
    D("D"), // Finished
    D_SHARP("D#"), // Finished
    E_FLAT("Eb"), // Finished
    E("E"), // Finished
    E_SHARP("E#"), // Finished
    F_FLAT("Fb"), // Finished
    F("F"), // Finished
    F_SHARP("F#"), // Finished
    G_FLAT("Gb"), // Finished
    G("G"), // Finished
    G_SHARP("G#"); // Finished

    private String name;

    Note(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
