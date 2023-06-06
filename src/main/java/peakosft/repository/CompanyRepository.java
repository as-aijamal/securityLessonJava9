package peakosft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peakosft.dto.CompanyResponse;
import peakosft.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select new peakosft.dto.CompanyResponse(c.id,c.name,c.country,c.address) from Company c")
    List<CompanyResponse> getAllCompanies();


    Optional<CompanyResponse> findCompanyById(Long id);
}