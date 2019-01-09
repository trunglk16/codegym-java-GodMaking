package sky.god.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sky.god.model.Thing;
import sky.god.repository.ThingRepository;
import sky.god.service.ThingService;

public class ThingServiceImpl implements ThingService {
    @Autowired
    private ThingRepository thingRepository;

    @Override
    public Page<Thing> findAll(Pageable pageable) {
        return thingRepository.findAll(pageable);
    }

    @Override
    public void save(Thing thing) {
        thingRepository.save(thing);
    }

    @Override
    public Thing findById(Long id) {
       return thingRepository.findOne(id);
    }
}
