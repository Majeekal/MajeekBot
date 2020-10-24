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

        for(int i = 0; i < ModeType.IONIAN.getSteps().size(); i++){
            if(ModeType.IONIAN.getSteps().get(i) == 0){
                NoteType raised = Note.raiseHalfStep(scale.get(scale.size() - 1));

                if(root.getType() == 0 && Note.isSharp(raised)){
                    raised = Note.getHarmonic(raised);
                } else if(root.getType() == 1 && Note.isFlat(raised)){
                    raised = Note.getHarmonic(raised);
                }

                scale.add(raised);
            } else{
                NoteType raised = Note.raiseWholeStep(scale.get(scale.size() - 1));

                if(root.getType() == 0 && Note.isSharp(raised)){
                    raised = Note.getHarmonic(raised);
                } else if(root.getType() == 1 && Note.isFlat(raised)){
                    raised = Note.getHarmonic(raised);
                }

                scale.add(raised);
            }
        }

        for(int i = 1; i < scale.size(); i++){
            if(mode.getPitch().get(i - 1) == 1){
                scale.set(i, Note.decreaseHalfStep(scale.get(i)));
            } else if(mode.getPitch().get(i - 1) == 2){
                scale.set(i, Note.raiseHalfStep(scale.get(i)));
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

        for(int i = 0; i < ModeType.IONIAN.getSteps().size(); i++){
            if(ModeType.IONIAN.getSteps().get(i) == 0){
                NoteType raised = Note.raiseHalfStep(scale.get(scale.size() - 1));

                if(root.getType() == 0 && Note.isSharp(raised)){
                    raised = Note.getHarmonic(raised);
                } else if(root.getType() == 1 && Note.isFlat(raised)){
                    raised = Note.getHarmonic(raised);
                }

                scale.add(raised);
            } else{
                NoteType raised = Note.raiseWholeStep(scale.get(scale.size() - 1));

                if(root.getType() == 0 && Note.isSharp(raised)){
                    raised = Note.getHarmonic(raised);
                } else if(root.getType() == 1 && Note.isFlat(raised)){
                    raised = Note.getHarmonic(raised);
                }

                scale.add(raised);
            }
        }

        for(int i = 1; i < scale.size(); i++){
            if(mode.getPitch().get(i - 1) == 1){
                scale.set(i, Note.decreaseHalfStep(scale.get(i)));
            } else if(mode.getPitch().get(i - 1) == 2){
                scale.set(i, Note.raiseHalfStep(scale.get(i)));
            }
        }

        notes = scale;
    }
}
