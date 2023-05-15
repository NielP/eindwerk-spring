package eu.elision.demospringright.domain;

import eu.elision.demospringright.dto.OrderDTO;
import jakarta.persistence.*;
import lombok.*;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private ObjectId id;

    private LocalDateTime createTime;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    @Builder.Default
    private List<Product> products = new ArrayList<>();

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public OrderDTO toOrderDTO() {
        return OrderDTO.builder()
                .createTime(this.createTime)
                .build();
    }

    public static Order fromOrderDTO(OrderDTO orderDTO) {
        return Order.builder()
                .createTime(orderDTO.getCreateTime())
                .build();
    }
}
