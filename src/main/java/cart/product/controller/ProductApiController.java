package cart.product.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cart.product.dto.ExceptionResponse;
import cart.product.dto.ProductRequest;
import cart.product.dto.ProductResponse;
import cart.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductApiController {

    private final ProductService productService;

    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProducts(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.saveProducts(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProducts(@PathVariable Long id,
                                                          @Valid @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.updateProducts(id, productRequest);

        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProducts(@PathVariable Long id) {
        productService.deleteProductsById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleBindException(Exception exception) {
        final String exceptionMessage = exception.getMessage();
        return ResponseEntity.badRequest().body(new ExceptionResponse(exceptionMessage));
    }
}
