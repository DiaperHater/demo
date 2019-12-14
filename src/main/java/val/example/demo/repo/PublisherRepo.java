package val.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import val.example.demo.model.Publisher;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}
