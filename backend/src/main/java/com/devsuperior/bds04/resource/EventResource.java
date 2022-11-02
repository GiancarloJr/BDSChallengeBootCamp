package com.devsuperior.bds04.resource;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.service.CityService;
import com.devsuperior.bds04.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventResource {

    @Autowired
    private EventService eventService;

    @GetMapping()
    public ResponseEntity<Page<EventDTO>> findAllPaged(Pageable pageable){
        Page<EventDTO> list = eventService.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }
//    @PostMapping("/")
//    public ResponseEntity<EventDTO> insert(@RequestBody EventDTO eventDTO){
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(eventDTO.getId()).toUri();
//        return ResponseEntity.ok().body(eventService.insert(eventDTO));
//    }

}
