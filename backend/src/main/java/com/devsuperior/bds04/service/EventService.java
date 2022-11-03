package com.devsuperior.bds04.service;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repository.CityRepository;
import com.devsuperior.bds04.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CityRepository cityRepository;

    public Page<EventDTO> findAll(Pageable pageable) {
        Page<Event> list = eventRepository.findAll(pageable);
        return list.map(event -> new EventDTO(event));
    }

    public EventDTO insert(EventDTO eventDTO){
        Event obj = new Event();
        obj.setName(eventDTO.getName());
        obj.setDate(eventDTO.getDate());
        obj.setUrl(eventDTO.getUrl());
        obj.setCity(cityRepository.getReferenceById(eventDTO.getCityId()));
        return new EventDTO(eventRepository.save(obj));
    }

    public void convertDtoToEntity(EventDTO eventDTO,Event entity){
        entity.setName(eventDTO.getName());
        entity.setDate(eventDTO.getDate());
        entity.setUrl(eventDTO.getUrl());
        entity.setCity(cityRepository.getReferenceById(eventDTO.getCityId()));
    }
}
