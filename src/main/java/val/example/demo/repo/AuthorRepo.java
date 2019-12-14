package val.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import val.example.demo.model.Author;

public interface AuthorRepo extends CrudRepository<Author, Long> {
}
