package eu.elision.demospringright.service;

import eu.elision.demospringright.dto.OrderDTO;
import eu.elision.demospringright.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<OrderDTO> findAll() {
        return orderRepository.findAll().stream()
                .map(eu.elision.demospringright.domain.Order::toOrderDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO findById(Long id) {
        return orderRepository.findById(id)
                .map(eu.elision.demospringright.domain.Order::toOrderDTO)
                .orElseThrow();
    }

    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        return orderRepository.save(eu.elision.demospringright.domain.Order.fromOrderDTO(orderDTO))
                .toOrderDTO();
    }

    @Transactional
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
