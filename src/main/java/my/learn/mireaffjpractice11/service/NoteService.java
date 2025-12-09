package my.learn.mireaffjpractice11.service;

import my.learn.mireaffjpractice11.DTO.request.CreateNoteRequest;
import my.learn.mireaffjpractice11.DTO.request.PatchNoteRequest;
import my.learn.mireaffjpractice11.DTO.request.PutNoteRequest;
import my.learn.mireaffjpractice11.entity.Note;

import java.util.List;

public interface NoteService {

    Note addNote(CreateNoteRequest request);
    Note patchNote(PatchNoteRequest req, Long id);
    Note putNote(PutNoteRequest req, Long id);
    Note deleteNote(Long id);
    List<Note> getAllNotes();
    Note findById(Long id);

}
