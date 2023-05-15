package eu.elision.demospringright.service;

import eu.elision.demospringright.dto.ProductDTO;
import eu.elision.demospringright.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream()
                .map(eu.elision.demospringright.domain.Product::toProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findById(ObjectId id) {
        return productRepository.findById(id)
                .map(eu.elision.demospringright.domain.Product::toProductDTO)
                .orElseThrow();
    }

    @Transactional
    public ProductDTO create(ProductDTO productDTO) {
        return productRepository.save(eu.elision.demospringright.domain.Product.fromProductDTO(productDTO))
                .toProductDTO();
    }

    @Transactional
    public void delete(ObjectId id) {
        productRepository.deleteById(id);
    }
}
