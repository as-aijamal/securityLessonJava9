package peakosft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(
            generator = "company_id",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "company_id",
            sequenceName = "company_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String country;
    private String address;


}
