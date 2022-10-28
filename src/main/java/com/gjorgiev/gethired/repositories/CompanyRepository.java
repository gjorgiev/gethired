package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("SELECT company FROM Company company WHERE company.id = :companyId")
    Optional<Company> findCompanyById(Long companyId);
}
