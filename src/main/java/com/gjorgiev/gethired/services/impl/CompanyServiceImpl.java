package com.gjorgiev.gethired.services.impl;

import com.gjorgiev.gethired.dto.request.CompanyRequest;
import com.gjorgiev.gethired.exceptions.ApiRequestException;
import com.gjorgiev.gethired.models.Company;
import com.gjorgiev.gethired.repositories.CompanyRepository;
import com.gjorgiev.gethired.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

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
    public Company createCompany(CompanyRequest companyRequest) {
        Company company = this.modelMapper.map(companyRequest, Company.class);
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Long companyId, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ApiRequestException("Company not found", HttpStatus.NOT_FOUND));
        company.setName(companyRequest.getName());
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
