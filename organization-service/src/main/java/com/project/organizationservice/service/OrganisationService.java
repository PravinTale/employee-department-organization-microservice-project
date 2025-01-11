package com.project.organizationservice.service;

import com.project.organizationservice.dto.OrganisationDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface OrganisationService {
    OrganisationDto createOrganisation(OrganisationDto organisationDto);
    OrganisationDto getOrganisationByCode(String code);
}
