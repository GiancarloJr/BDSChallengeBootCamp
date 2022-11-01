package com.devsuperior.bds04.service;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<CityDTO> findAll(Long id) {
        List<CityDTO> listDTO = new ArrayList<>();
        for (City entity : cityRepository.findAll()) {
            listDTO.add(new CityDTO(entity));
        }
        return listDTO;
    }
}
