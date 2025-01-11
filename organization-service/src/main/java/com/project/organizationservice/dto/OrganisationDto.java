package com.project.organizationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationDto {
    private Long id;
    private String organisationName;
    private String organisationDescription;
    private String organisationCode;
    private LocalDateTime createdDate;

}
