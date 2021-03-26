package tankesmedjan.webshop.controllers;

import tankesmedjan.webshop.models.Brands;
import tankesmedjan.webshop.repos.BrandsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    @Autowired
    private BrandsRepo brandsRepo;

    @PostMapping
    public Brands addBrand(@RequestBody Brands brand) {
        brandsRepo.save(brand);
        return brand;
    }
}