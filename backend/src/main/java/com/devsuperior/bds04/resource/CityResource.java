package com.devsuperior.bds04.resource;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityResource {

    @Autowired
    private CityService cityService;

    @GetMapping()
    public ResponseEntity<List<CityDTO>> findAll(){
        List<CityDTO> list = cityService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping()
    public ResponseEntity<CityDTO> insert(@Valid @RequestBody CityDTO cityDTO){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cityDTO.getId()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.insert(cityDTO));
    }

}
