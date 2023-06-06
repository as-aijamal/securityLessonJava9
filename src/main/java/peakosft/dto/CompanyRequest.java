package peakosft.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CompanyRequest {
    private String name;
    private String country;
    private String address;
}
