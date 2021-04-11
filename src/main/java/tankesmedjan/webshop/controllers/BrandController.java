package tankesmedjan.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import tankesmedjan.webshop.models.Brand;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.services.BrandService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.findAll();
    }

    @PostMapping
    public Brand addBrand(@RequestBody Brand brand) {
        return brandService.saveBrand(brand);
    }

    //  "/{id}"
    @GetMapping("/id")
    public List<SKU> getAllProductsFromBrand(@Param("id") Long id) {
        return brandService.getProductsByBrandId(id);
    }

    //  "/brand/{id}"
    @GetMapping("/brand")
    public List<Brand> getBrand(@Param("id") Long id) {
        return brandService.getBrand(id);
    }
}