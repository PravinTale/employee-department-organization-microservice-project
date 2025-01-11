package com.project.organizationservice.service.impl;

import com.project.organizationservice.exception.OrganisationAlreadyExistsException;
import com.project.organizationservice.exception.ResourceNotFoundException;
import com.project.organizationservice.dto.OrganisationDto;
import com.project.organizationservice.entity.Organisation;
import com.project.organizationservice.repository.OrganisationRepo;
import com.project.organizationservice.service.OrganisationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {
    private OrganisationRepo organisationRepo;
    @Override
    public OrganisationDto createOrganisation(OrganisationDto organisationDto) {
        Optional<Organisation> organisationOptional = organisationRepo.findByorganisationCode(organisationDto.getOrganisationCode());
        if(organisationOptional.isPresent()){
            throw new OrganisationAlreadyExistsException("Organisation already exists for with code:" + organisationDto.getOrganisationCode());
        }
        ModelMapper modelMapper = new ModelMapper();
        Organisation organisation = modelMapper.map(organisationDto,Organisation.class);
        Organisation saveOrganisation = organisationRepo.save(organisation);

        return modelMapper.map(saveOrganisation,OrganisationDto.class);
    }

    @Override
    public OrganisationDto getOrganisationByCode(String code) {
        Organisation organisation = organisationRepo.findByorganisationCode(code).orElseThrow(
                ()->new ResourceNotFoundException("Organisation","id", code)
        );
;
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(organisation, OrganisationDto.class);
    }
}
