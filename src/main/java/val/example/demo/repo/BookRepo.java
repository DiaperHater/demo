package val.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import val.example.demo.model.Book;

public interface BookRepo extends CrudRepository<Book, Long> {
}
