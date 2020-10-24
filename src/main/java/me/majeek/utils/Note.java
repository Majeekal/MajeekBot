package me.majeek.utils;

import java.util.Arrays;
import java.util.List;

public class Note {
    private static final List<NoteType> sharpChromatic = Arrays.asList(NoteType.A, NoteType.A_SHARP, NoteType.B, NoteType.C, NoteType.C_SHARP, NoteType.D, NoteType.D_SHARP, NoteType.E, NoteType.F, NoteType.F_SHARP, NoteType.G, NoteType.G_SHARP);
    private static final List<NoteType> flatChromatic = Arrays.asList(NoteType.A, NoteType.B_FLAT, NoteType.B, NoteType.C, NoteType.D_FLAT, NoteType.D, NoteType.E_FLAT, NoteType.E, NoteType.F, NoteType.G_FLAT, NoteType.G, NoteType.A_FLAT);


    public static NoteType raiseHalfStep(NoteType note){
        int index = 0;
        if(!sharpChromatic.contains(note)){
            index = sharpChromatic.indexOf(Note.getHarmonic(note));
        } else{
            index = sharpChromatic.indexOf(note);
        }

        if(index + 1 >= sharpChromatic.size()){
            return sharpChromatic.get(0);
        } else{
            return sharpChromatic.get(index + 1);
        }
    }

    public static NoteType raiseWholeStep(NoteType note){
        return raiseHalfStep(raiseHalfStep(note));
    }

    public static NoteType decreaseHalfStep(NoteType note){
        int index;
        if(!flatChromatic.contains(note)){
            index = flatChromatic.indexOf(Note.getHarmonic(note));
        } else{
            index = flatChromatic.indexOf(note);
        }

        if(index - 1 < 0){
            return flatChromatic.get(flatChromatic.size() - 1);
        } else{
            return flatChromatic.get(index - 1);
        }
    }

    public static NoteType decreaseWholeStep(NoteType note){
        return decreaseHalfStep(decreaseHalfStep(note));
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
