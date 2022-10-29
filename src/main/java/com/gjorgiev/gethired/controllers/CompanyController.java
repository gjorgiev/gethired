package com.gjorgiev.gethired.controllers;

import com.gjorgiev.gethired.models.Company;
import com.gjorgiev.gethired.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        return ResponseEntity.ok(companyService.createCompany(company));
    }

    @PutMapping
    public ResponseEntity<Company> updateCompany(@RequestBody Company company){
        return ResponseEntity.ok(companyService.updateCompany(company));
    }

    @DeleteMapping("/{companyId}")
    public void deleteCompany(@RequestBody Long companyId){
        companyService.deleteCompany(companyId);
    }
}
