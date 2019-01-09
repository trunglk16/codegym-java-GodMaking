package sky.god.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sky.god.model.Thing;

public interface ThingService {

    Page<Thing> findAll(Pageable pageable);

    void save(Thing thing);

    Thing findById(Long id);
}
