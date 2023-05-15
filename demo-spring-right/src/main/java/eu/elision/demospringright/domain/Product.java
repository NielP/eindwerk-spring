package eu.elision.demospringright.domain;

import eu.elision.demospringright.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Products")
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private ObjectId id;
    private String name;
    private Double price;
    private String ean;

    @ManyToMany(mappedBy = "products")
    @ToString.Exclude
    @Builder.Default
    private List<Order> orders = new ArrayList<>();


    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public ProductDTO toProductDTO() {
        return ProductDTO.builder()
                .name(this.name)
                .price(this.price)
                .ean(this.ean)
                .build();
    }

    public static Product fromProductDTO(ProductDTO productDTO) {
        return Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .ean(productDTO.getEan())
                .build();
    }
}
