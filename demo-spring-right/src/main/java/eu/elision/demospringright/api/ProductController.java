package eu.elision.demospringright.api;

import eu.elision.demospringright.dto.ProductDTO;
import eu.elision.demospringright.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> listProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable("id") ObjectId id) {
        return productService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.create(productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") ObjectId id) {
        productService.delete(id);
    }
}