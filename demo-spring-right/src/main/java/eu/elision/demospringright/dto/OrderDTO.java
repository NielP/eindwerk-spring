package eu.elision.demospringright.dto;

import eu.elision.demospringright.domain.Customer;
import eu.elision.demospringright.domain.Product;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderDTO {
    private LocalDateTime createTime;
    private Customer customer;
    private List<Product> products;
}
