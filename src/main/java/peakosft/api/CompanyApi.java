package peakosft.api;

import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peakosft.dto.CompanyRequest;
import peakosft.dto.CompanyResponse;
import peakosft.dto.SimpleResponse;
import peakosft.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyApi {

    private final CompanyService companyService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public SimpleResponse saveCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','INSTRUCTOR','STUDENT')")
    @GetMapping
    public List<CompanyResponse> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PermitAll
    @GetMapping("/{id}")
    public CompanyResponse getById(@PathVariable Long id) {
        return companyService.getById(id);
    }


    @PreAuthorize("hasAnyAuthority('ADMIN','INSTRUCTOR')")
    @PutMapping("/{id}")
    public SimpleResponse updateCompany(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(id, companyRequest);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public SimpleResponse deleteCompany(@PathVariable Long id) {
        return companyService.deleteCompany(id);
    }
}
