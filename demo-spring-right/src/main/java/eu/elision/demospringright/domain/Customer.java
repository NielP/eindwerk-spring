package eu.elision.demospringright.domain;

import eu.elision.demospringright.dto.CustomerDTO;
import jakarta.persistence.*;
import lombok.*;
import org.bson.types.ObjectId;

import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.ALL;

@jakarta.persistence.Entity
@Table(name = "Customers")
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private ObjectId id;

    private String firstName;
    private String lastName;
    private String postalCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @ToString.Exclude
    private Set<Order> orders;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public CustomerDTO toCustomerDTO() {
        return CustomerDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .postalCode(postalCode)
                .build();
    }

    public static Customer fromCustomerDTO(CustomerDTO customerDTO) {
        return Customer.builder()
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .postalCode(customerDTO.getPostalCode())
                .build();
    }
}
