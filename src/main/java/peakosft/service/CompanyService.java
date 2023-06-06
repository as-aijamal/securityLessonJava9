package peakosft.service;

import peakosft.dto.CompanyRequest;
import peakosft.dto.CompanyResponse;
import peakosft.dto.SimpleResponse;

import java.util.List;

public interface CompanyService {

    SimpleResponse saveCompany(CompanyRequest companyRequest);
    List<CompanyResponse> getAllCompanies();
    CompanyResponse getById(Long id);
    SimpleResponse updateCompany(Long id, CompanyRequest companyRequest);
    SimpleResponse deleteCompany(Long id);

}
