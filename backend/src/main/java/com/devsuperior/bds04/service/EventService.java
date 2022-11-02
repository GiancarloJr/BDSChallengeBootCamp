package com.devsuperior.bds04.service;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repository.CityRepository;
import com.devsuperior.bds04.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<EventDTO> findAll(Long id) {
        List<EventDTO> listDTO = new ArrayList<>();
        for (Event entity : eventRepository.findAll()) {
            listDTO.add(new EventDTO(entity));
        }
        return listDTO;
    }
}
