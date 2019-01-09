package sky.god.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import sky.god.model.Thing;

public interface ThingRepository extends PagingAndSortingRepository<Thing, Long> {

}