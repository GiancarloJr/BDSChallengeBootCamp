package com.devsuperior.bds04.service;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public CityDTO insert(CityDTO cityDTO){
        City obj = new City();
        convertDtoToEntity(cityDTO, obj);
        return new CityDTO(cityRepository.save(obj));
    }

    public List<CityDTO> findAll() {
        List<CityDTO> listDTO = new ArrayList<>();
        for (City entity : cityRepository.findAllByOrderByName()) {
            listDTO.add(new CityDTO(entity));
        }
        return listDTO;
    }

    public void convertDtoToEntity(CityDTO dto,City entity){
        entity.setName(dto.getName());
    }
}
