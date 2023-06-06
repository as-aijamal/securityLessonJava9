package peakosft.dto;

import lombok.Data;

@Data
public class CompanyResponse {

    private Long id;
    private String name;
    private String country;
    private String address;

    public CompanyResponse(Long id, String name, String country, String address) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
    }
}
