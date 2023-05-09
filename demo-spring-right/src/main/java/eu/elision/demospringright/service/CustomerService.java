package eu.elision.demospringright.service;

import eu.elision.demospringright.dto.CustomerDTO;
import eu.elision.demospringright.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream()
                .map(eu.elision.demospringright.domain.Customer::toCustomerDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO findById(Long id) {
        return customerRepository.findById(id)
                .map(eu.elision.demospringright.domain.Customer::toCustomerDTO)
                .orElseThrow();
    }

    @Transactional
    public CustomerDTO create(CustomerDTO customerDTO) {
        return customerRepository.save(eu.elision.demospringright.domain.Customer.fromCustomerDTO(customerDTO))
                .toCustomerDTO();
    }

    @Transactional
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
