package me.majeek.utils;

import java.util.Arrays;
import java.util.List;

public class NoteUtil {
    private static final List<Note> chromatic = Arrays.asList(Note.A_SHARP, Note.B, Note.C, Note.C_SHARP, Note.D, Note.D_SHARP, Note.E, Note.F, Note.F_SHARP, Note.G, Note.G_SHARP, Note.A);

    public static Note halfStepUp(Note note, int amount){
        int index = 0;
        for(int i = 0; i < NoteUtil.chromatic.size(); i++){
            if(note == NoteUtil.chromatic.get(i)){
                index = i;
                break;
            }
        }

        int count = 0;
        while(true){
            if(count == amount){
                return NoteUtil.chromatic.get(index);
            }

            if(index + 1 > NoteUtil.chromatic.size() - 1){
                index = 0;
            } else{
                index++;
            }

            count++;
        }
    }

    public static Note halfStepDown(Note note, int amount){
        int index = 0;
        for(int i = 0; i < NoteUtil.chromatic.size(); i++){
            if(note == NoteUtil.chromatic.get(i)){
                index = i;
                break;
            }
        }

        int count = 0;
        while(true){
            if(count == amount){
                return NoteUtil.chromatic.get(index);
            }

            if(index - 1 < 0){
                index = NoteUtil.chromatic.size() - 1;
            } else{
                index--;
            }

            count++;
        }
    }

    public static int halfStepDifference(Note from, Note to){
        if(!NoteUtil.chromatic.contains(from)){
            from = NoteUtil.getHarmonic(from);
        }

        if(!NoteUtil.chromatic.contains(to)){
            to = NoteUtil.getHarmonic(to);
        }

        int first_index = 0;
        int second_index = 0;
        for(int i = 0; i < NoteUtil.chromatic.size(); i++){
            if(from == NoteUtil.chromatic.get(i)){
                first_index = i;
            } else if(to == NoteUtil.chromatic.get(i)){
                second_index = i;
            }
        }

        int count = 0;
        int index = first_index;
        while(true){
            if(index == second_index){
                return count;
            }

            if(index + 1 > NoteUtil.chromatic.size() - 1){
                index = 0;
            } else{
                index++;
            }

            count++;
        }
    }

    public static List<Note> getChromatic(){
        return NoteUtil.chromatic;
    }

    public static List<Note> getScale(Note note){
        if(note == Note.G_SHARP || note == Note.A_FLAT){
            return Arrays.asList(Note.A_FLAT, Note.B_FLAT, Note.C, Note.D_FLAT, Note.E_FLAT, Note.F, Note.G);
        } else if(note == Note.A){
            return Arrays.asList(Note.A, Note.B, Note.C_SHARP, Note.D, Note.E, Note.F_SHARP, Note.G_SHARP);
        } else if(note == Note.A_SHARP || note == Note.B_FLAT){
            return Arrays.asList(Note.B_FLAT, Note.C, Note.D, Note.E_FLAT, Note.F, Note.G, Note.A);
        } else if(note == Note.B || note == Note.C_FLAT){
            return Arrays.asList(Note.B, Note.C_SHARP, Note.D_SHARP, Note.E, Note.F_SHARP, Note.G_SHARP, Note.A_SHARP);
        } else if(note == Note.B_SHARP || note == Note.C){
            return Arrays.asList(Note.C, Note.D, Note.E, Note.F, Note.G, Note.A, Note.B);
        } else if(note == Note.C_SHARP || note == Note.D_FLAT){
            return Arrays.asList(Note.D_FLAT, Note.E_FLAT, Note.F, Note.G_FLAT, Note.A_FLAT, Note.B_FLAT, Note.C);
        } else if(note == Note.D){
            return Arrays.asList(Note.D, Note.E, Note.F_SHARP, Note.G, Note.A, Note.B, Note.C_SHARP);
        } else if(note == Note.D_SHARP || note == Note.E_FLAT){
            return Arrays.asList(Note.E_FLAT, Note.F, Note.G, Note.A_FLAT, Note.B_FLAT, Note.C, Note.D);
        } else if(note == Note.E || note == Note.F_FLAT){
            return Arrays.asList(Note.E, Note.F_SHARP, Note.G_SHARP, Note.A, Note.B, Note.C_SHARP, Note.D_SHARP);
        } else if(note == Note.E_SHARP || note == Note.F){
            return Arrays.asList(Note.F, Note.G, Note.A, Note.B_FLAT, Note.C, Note.D, Note.E);
        } else if(note == Note.F_SHARP || note == Note.G_FLAT){
            return Arrays.asList(Note.G_FLAT, Note.A_FLAT, Note.B_FLAT, Note.C_FLAT, Note.D_FLAT, Note.E_FLAT, Note.F);
        } else if(note == Note.G){
            return Arrays.asList(Note.G, Note.A, Note.B, Note.C, Note.D, Note.E, Note.F_SHARP);
        } else{
            return null;
        }
    }

    public static Note getHarmonic(Note note){
        if(note == Note.A_FLAT){
            return Note.G_SHARP;
        } else if(note == Note.A){
            return Note.A;
        } else if(note == Note.A_SHARP){
            return Note.B_FLAT;
        } else if(note == Note.B_FLAT){
            return Note.A_SHARP;
        } else if(note == Note.B){
            return Note.C_FLAT;
        } else if(note == Note.B_SHARP){
            return Note.C;
        } else if(note == Note.C_FLAT){
            return Note.B;
        } else if(note == Note.C){
            return Note.C;
        } else if(note == Note.C_SHARP){
            return Note.D_FLAT;
        } else if(note == Note.D_FLAT){
            return Note.C_SHARP;
        } else if(note == Note.D){
            return Note.D;
        } else if(note == Note.D_SHARP){
            return Note.E_FLAT;
        } else if(note == Note.E_FLAT){
            return Note.D_SHARP;
        } else if(note == Note.E){
            return Note.F_FLAT;
        } else if(note == Note.E_SHARP){
            return Note.F;
        } else if(note == Note.F_FLAT){
            return Note.E;
        } else if(note == Note.F){
            return Note.E_SHARP;
        } else if(note == Note.F_SHARP){
            return Note.G_FLAT;
        } else if(note == Note.G_FLAT){
            return Note.F_SHARP;
        } else if(note == Note.G){
            return Note.G;
        } else if(note == Note.G_SHARP){
            return Note.A_FLAT;
        } else{
            return null;
        }
    }

    public static Note stringToNote(String name){
        for(Note note : Note.values()){
            if(note.getName().equalsIgnoreCase(name)){
                return note;
            }
        }

        return null;
    }
}
