package com.project.organizationservice.controller;

import com.project.organizationservice.dto.OrganisationDto;
import com.project.organizationservice.service.OrganisationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/organisation")

@Tag(
        name = "Organisation Service REST APIS",
        description = "Spring Boot REST Controller for Organisation Service"
)
public class OrganisationController {

    @Autowired
    public OrganisationService organisationService;

    @Operation(
            summary = "Create Organisation REST API",
            description = "Used to save organisation in Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status  201 created "

    )
    @PostMapping()
    public ResponseEntity<OrganisationDto> createOrganisation(@RequestBody OrganisationDto organisationDto){
        OrganisationDto organisation = organisationService.createOrganisation(organisationDto);
        return new ResponseEntity<>(organisation, HttpStatus.CREATED);

    }

    @Operation(
            summary = "Get Organisation REST API",
            description = "Used to get organisation from Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status  200 created "

    )
    @GetMapping("{org-code}")
    public ResponseEntity<OrganisationDto> createOrganisation(@PathVariable("org-code") String orgCode){
        OrganisationDto organisation = organisationService.getOrganisationByCode(orgCode);
        return new ResponseEntity<>(organisation, HttpStatus.OK);

    }
}
