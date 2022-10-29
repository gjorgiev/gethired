package com.gjorgiev.gethired.services.impl;

import com.gjorgiev.gethired.exceptions.ApiRequestException;
import com.gjorgiev.gethired.models.Company;
import com.gjorgiev.gethired.repositories.CompanyRepository;
import com.gjorgiev.gethired.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private final CompanyRepository companyRepository;

    @Override
    public Page<Company> getCompanies(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Override
    public Company getCompanyById(Long companyId) {
        return companyRepository.findCompanyById(companyId)
                .orElseThrow(() -> new ApiRequestException("Company with id = " + companyId + " not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public Company createCompany(Company company) {
        if (company.getName() == null)
            throw new ApiRequestException("Company name can't be null", HttpStatus.BAD_REQUEST);
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company companyInfo) {
        if (companyInfo.getId() == null)
            throw new ApiRequestException("Company id can't be null", HttpStatus.BAD_REQUEST);
        if (companyInfo.getName() == null)
            throw new ApiRequestException("Company name can't be null", HttpStatus.BAD_REQUEST);
        Company company = companyRepository.findById(companyInfo.getId())
                .orElseThrow(() -> new ApiRequestException("Company not found", HttpStatus.NOT_FOUND));
        company.setName(companyInfo.getName());
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
