package me.majeek.utils;

public enum NoteType {
    A_FLAT("Ab"),
    A("A"),
    A_SHARP("A#"),
    B_FLAT("Bb"),
    B("B"),
    B_SHARP("B#"),
    C_FLAT("Cb"),
    C("C"),
    C_SHARP("C#"),
    D_FLAT("Db"),
    D("D"),
    D_SHARP("D#"),
    E_FLAT("Eb"),
    E("E"),
    E_SHARP("E#"),
    F_FLAT("Fb"),
    F("F"),
    F_SHARP("F#"),
    G_FLAT("Gb"),
    G("G"),
    G_SHARP("G#");

    private String name;

    NoteType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
