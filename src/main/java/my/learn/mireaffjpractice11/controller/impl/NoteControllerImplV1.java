package my.learn.mireaffjpractice11.controller.impl;

import lombok.RequiredArgsConstructor;
import my.learn.mireaffjpractice11.DTO.request.CreateNoteRequest;
import my.learn.mireaffjpractice11.DTO.request.PatchNoteRequest;
import my.learn.mireaffjpractice11.DTO.request.PutNoteRequest;
import my.learn.mireaffjpractice11.DTO.response.NoteDTO;
import my.learn.mireaffjpractice11.controller.NoteController;
import my.learn.mireaffjpractice11.entity.Note;
import my.learn.mireaffjpractice11.service.NoteService;
import my.learn.mireaffjpractice11.util.NoteMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
@RequiredArgsConstructor
public class NoteControllerImplV1 implements NoteController {

    private final NoteService noteService;
    private final NoteMapper mapper;

    @Override
    public ResponseEntity<NoteDTO> addNote(CreateNoteRequest createNoteRequest) {
        NoteDTO noteDTO = mapper.toNoteDTO(noteService.addNote(createNoteRequest));
        return new ResponseEntity<>(noteDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<NoteDTO> patchNote(PatchNoteRequest patchNoteRequest, Long id) {
        NoteDTO noteDTO = mapper.toNoteDTO(noteService.patchNote(patchNoteRequest, id));
        return new ResponseEntity<>(noteDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NoteDTO> putNote(PutNoteRequest putNoteRequest, Long id) {
        NoteDTO noteDTO = mapper.toNoteDTO(noteService.putNote(putNoteRequest, id));
        return new ResponseEntity<>(noteDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NoteDTO> deleteNote(Long id) {
        NoteDTO noteDTO = mapper.toNoteDTO(noteService.deleteNote(id));
        return new ResponseEntity<>(noteDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<NoteDTO>> getAllNotes() {
        List<NoteDTO> list = noteService.getAllNotes().stream()
                .map(mapper::toNoteDTO)
                .toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NoteDTO> getNoteById(Long id) {
        Note byId = noteService.findById(id);
        return new ResponseEntity<>(mapper.toNoteDTO(byId), HttpStatus.OK);
    }



}
