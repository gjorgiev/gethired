package com.gjorgiev.gethired.services;

import com.gjorgiev.gethired.dto.request.CompanyRequest;
import com.gjorgiev.gethired.models.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    Page<Company> getCompanies(Pageable pageable);
    Company getCompanyById(Long companyId);
    Company createCompany(CompanyRequest companyRequest);
    Company updateCompany(Long companyId, CompanyRequest companyRequest);
    void deleteCompany(Long companyId);
}
