package my.learn.mireaffjpractice11.repository;

import my.learn.mireaffjpractice11.DTO.response.NoteDTO;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<NoteDTO,Long> {
}
