package eu.elision.demospringright.dto;

import eu.elision.demospringright.domain.Order;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String postalCode;
    private Set<Order> orders;
}
