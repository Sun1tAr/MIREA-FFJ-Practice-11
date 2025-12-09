package my.learn.mireaffjpractice11.service.impl;

import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice11.DTO.request.CreateNoteRequest;
import my.learn.mireaffjpractice11.DTO.request.PatchNoteRequest;
import my.learn.mireaffjpractice11.DTO.request.PutNoteRequest;
import my.learn.mireaffjpractice11.entity.Note;
import my.learn.mireaffjpractice11.repository.NoteRepository;
import my.learn.mireaffjpractice11.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceV1Impl  implements NoteService {

    private final NoteRepository noteRepository;


    @Override
    public Note addNote(CreateNoteRequest request) {
        return null;
    }

    @Override
    public Note patchNote(PatchNoteRequest req, Long id) {
        return null;
    }

    @Override
    public Note putNote(PutNoteRequest req, Long id) {
        return null;
    }

    @Override
    public Note deleteNote(Long id) {
        return null;
    }

    @Override
    public List<Note> getAllNotes() {
        return List.of();
    }

    @Override
    public Note findById(Long id) {
        return null;
    }
}
