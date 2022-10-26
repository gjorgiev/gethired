package com.gjorgiev.gethired.repositories;

import com.gjorgiev.gethired.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
