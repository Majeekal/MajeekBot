package me.majeek.utils;

public enum NoteType {
    A_FLAT("Ab", 0),
    A("A", 1),
    A_SHARP("A#", 1),
    B_FLAT("Bb", 0),
    B("B", 1),
    B_SHARP("B#", 1),
    C_FLAT("Cb", 0),
    C("C", 0),
    C_SHARP("C#", 1),
    D_FLAT("Db", 0),
    D("D", 1),
    D_SHARP("D#", 1),
    E_FLAT("Eb", 0),
    E("E", 1),
    E_SHARP("E#", 1),
    F_FLAT("Fb", 0),
    F("F", 0),
    F_SHARP("F#", 1),
    G_FLAT("Gb", 0),
    G("G", 1),
    G_SHARP("G#", 1);

    private String name;
    private int type;

    NoteType(String name, int type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }
}
