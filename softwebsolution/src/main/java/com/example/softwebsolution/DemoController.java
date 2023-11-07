package com.example.softwebsolution;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/softweb")
public class DemoController extends BaseController {

    @Value("classpath:data/data.json")
    Object resourceFile;

    private static List<Product> getProducts() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Resource resource = new ClassPathResource("/data.json");
        return mapper.readValue(resource.getInputStream(), new TypeReference<List<Product>>() {
        });
    }

    @PostMapping("/getJson")
    public ResponseEntity<?> getJson() {

        try {
            List<Product> products = getProducts();
            return okSuccessResponse(products, "Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return okFailResponse(null, "Fail");
    }

    @PostMapping("/filterJson")
    public ResponseEntity<?> filterJson(@RequestBody ProductFilterDTO productFilterDTO) {

        try {
            List<Product> products = getProducts();
            products = products.stream().filter(product -> product.getName().equals(productFilterDTO.getName()))
                    .filter(product -> product.getPrice() > productFilterDTO.getStartPrice() && product.getPrice() < productFilterDTO.getEndPrice())
                    .filter(product -> product.getUpdatedOn().after(productFilterDTO.getStartDate()) && product.getUpdatedOn().before(productFilterDTO.getEndDate()))
                    .collect(Collectors.toList());
            return okSuccessResponse(products, "Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return okFailResponse(null, "Fail");
    }
}
