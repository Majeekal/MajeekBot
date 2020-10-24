package me.majeek.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scale {
    private NoteType root;
    private ModeType mode;

    private List<NoteType> notes;

    public Scale(NoteType root, ModeType mode){
        this.root = root;
        this.mode = mode;

        construct();
    }

    public void construct(NoteType root, ModeType mode){
        List<NoteType> scale = new ArrayList<>(Collections.singletonList(root));

        for(int i = 0; i < mode.getSteps().size(); i++){
            if(mode.getSteps().get(i) == 0){
                scale.add(Note.getHalfStep(scale.get(scale.size() - 1)));
            } else{
                scale.add(Note.getWholeStep(scale.get(scale.size() - 1)));
            }
        }

        notes = scale;
    }

    public NoteType getRoot(){
        return root;
    }

    public ModeType getMode(){
        return mode;
    }

    public List<NoteType> getNotes(){
        return notes;
    }

    private void construct(){
        List<NoteType> scale = new ArrayList<>(Collections.singletonList(root));

        for(int i = 0; i < mode.getSteps().size(); i++){
            if(mode.getSteps().get(i) == 0){
                scale.add(Note.getHalfStep(scale.get(scale.size() - 1)));
            } else{
                scale.add(Note.getWholeStep(scale.get(scale.size() - 1)));
            }
        }

        notes = scale;
    }
}
