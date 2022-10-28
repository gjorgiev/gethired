package com.gjorgiev.gethired.controllers;

import com.gjorgiev.gethired.models.Company;
import com.gjorgiev.gethired.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
