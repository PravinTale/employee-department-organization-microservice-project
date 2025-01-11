package com.project.organizationservice.repository;

import com.project.organizationservice.entity.Organisation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganisationRepo extends JpaRepository<Organisation,Long> {
    Optional<Organisation> findByorganisationCode(String code);

}
