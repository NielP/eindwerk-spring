package eu.elision.demospringright.dto;

import eu.elision.demospringright.domain.Order;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDTO {
    private String name;
    private Double price;
    private String ean;
    private List<Order> orders;
}
