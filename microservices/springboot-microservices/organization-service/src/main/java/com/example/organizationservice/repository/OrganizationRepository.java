package com.example.organizationservice.repository;

import com.example.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    public Organization findByOrganizationCode(String organizationCOde);
}
