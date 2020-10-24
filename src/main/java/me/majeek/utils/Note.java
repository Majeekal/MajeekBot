package me.majeek.utils;

import java.util.Arrays;
import java.util.List;

public class Note {
    private static final List<NoteType> chromatic = Arrays.asList(NoteType.A, NoteType.A_SHARP, NoteType.B, NoteType.C, NoteType.C_SHARP, NoteType.D, NoteType.D_SHARP, NoteType.E, NoteType.F, NoteType.F_SHARP, NoteType.G, NoteType.G_SHARP);

    public static NoteType getHalfStep(NoteType note){
        int index = 0;
        if(!chromatic.contains(note)){
            index = chromatic.indexOf(Note.getHarmonic(note));
        } else{
            index = chromatic.indexOf(note);
        }

        if(index + 1 >= chromatic.size()){
            return chromatic.get(0);
        } else{
            return chromatic.get(index + 1);
        }
    }

    public static NoteType getWholeStep(NoteType note){
        return getHalfStep(getHalfStep(note));
    }

    public static NoteType getHarmonic(NoteType note){
        switch (note){
            case A_FLAT:
                return NoteType.G_SHARP;
            case A_SHARP:
                return NoteType.B_FLAT;
            case B_FLAT:
                return NoteType.A_SHARP;
            case B:
                return NoteType.C_FLAT;
            case B_SHARP:
                return NoteType.C;
            case C_FLAT:
                return NoteType.B;
            case C:
                return NoteType.B_SHARP;
            case C_SHARP:
                return NoteType.D_FLAT;
            case D_FLAT:
                return NoteType.C_SHARP;
            case D_SHARP:
                return NoteType.E_FLAT;
            case E_FLAT:
                return NoteType.D_SHARP;
            case E:
                return NoteType.F_FLAT;
            case E_SHARP:
                return NoteType.F;
            case F_FLAT:
                return NoteType.E;
            case F:
                return NoteType.E_SHARP;
            case F_SHARP:
                return NoteType.G_FLAT;
            case G_FLAT:
                return NoteType.F_SHARP;
            case G_SHARP:
                return NoteType.A_FLAT;
            default:
                return null;
        }
    }

    public static boolean hasHarmonic(NoteType note){
        return getHarmonic(note) != null;
    }

    public static boolean isFlat(NoteType note){
        switch (note){
            case A_FLAT:
            case B_FLAT:
            case C_FLAT:
            case D_FLAT:
            case E_FLAT:
            case F_FLAT:
            case G_FLAT:
                return true;
            default:
                return false;
        }
    }

    public static boolean isSharp(NoteType note){
        switch (note){
            case A_SHARP:
            case B_SHARP:
            case C_SHARP:
            case D_SHARP:
            case E_SHARP:
            case F_SHARP:
            case G_SHARP:
                return true;
            default:
                return false;
        }
    }

    public static boolean isNatural(NoteType note){
        switch (note){
            case A:
            case B:
            case C:
            case D:
            case E:
            case F:
            case G:
                return true;
            default:
                return false;
        }
    }

    public static NoteType stringToNote(String name){
        for(NoteType note : NoteType.values()){
            if(note.getName().equalsIgnoreCase(name)){
                return note;
            }
        }

        return null;
    }
}
