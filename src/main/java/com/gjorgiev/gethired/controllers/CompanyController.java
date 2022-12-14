package com.gjorgiev.gethired.controllers;

import com.gjorgiev.gethired.dto.request.CompanyRequest;
import com.gjorgiev.gethired.models.Company;
import com.gjorgiev.gethired.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<Page<Company>> getCompanies(@PageableDefault(size = 10) Pageable pageable){
        return ResponseEntity.ok(companyService.getCompanies(pageable));
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId){
        return ResponseEntity.ok(companyService.getCompanyById(companyId));
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@Valid @RequestBody CompanyRequest companyRequest){
        return ResponseEntity.ok(companyService.createCompany(companyRequest));
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long companyId, @Valid @RequestBody CompanyRequest companyRequest){
        return ResponseEntity.ok(companyService.updateCompany(companyId, companyRequest));
    }

    @DeleteMapping("/{companyId}")
    public void deleteCompany(@PathVariable Long companyId){
        companyService.deleteCompany(companyId);
    }

}
