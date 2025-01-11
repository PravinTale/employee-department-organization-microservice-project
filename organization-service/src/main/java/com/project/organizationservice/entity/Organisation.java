package com.project.organizationservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organisation")
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String organisationName;

    private String organisationDescription;

    @Column(nullable = false, unique = true)
    private String organisationCode;

    @CreatedDate
    private LocalDateTime createdDate;

}
