package peakosft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peakosft.dto.CompanyRequest;
import peakosft.dto.CompanyResponse;
import peakosft.dto.SimpleResponse;
import peakosft.entity.Company;
import peakosft.repository.CompanyRepository;
import peakosft.service.CompanyService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    @Override
    public SimpleResponse saveCompany(CompanyRequest companyRequest) {
        Company company=new Company();
        company.setName(companyRequest.getName());
        company.setCountry(companyRequest.getCountry());
        company.setAddress(companyRequest.getAddress());
        companyRepository.save(company);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Company with name: %s is successfully saved",companyRequest.getName()))
                .build();
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
       return companyRepository.getAllCompanies();

    }

    @Override
    public CompanyResponse getById(Long id) {
       return companyRepository.findCompanyById(id).orElseThrow(
               ()->new NullPointerException("Company with id: "+id+" doesn't exist!")
       );
    }

    @Override
    public SimpleResponse updateCompany(Long id, CompanyRequest companyRequest) {
       Company company= companyRepository.findById(id).orElseThrow(
                ()->new NullPointerException("Company with id: "+id+" doesn't exist!"));
        company.setName(companyRequest.getName());
        company.setCountry(companyRequest.getCountry());
        company.setAddress(companyRequest.getAddress());
        companyRepository.save(company);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Company with name: %s is successfully updated",companyRequest.getName()))
                .build();
    }

    @Override
    public SimpleResponse deleteCompany(Long id) {
        Company company= companyRepository.findById(id).orElseThrow(
                ()->new NullPointerException("Company with id: "+id+" doesn't exist!"));
        companyRepository.delete(company);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Company with name: %s is successfully deleted",id))
                .build();
    }
}
