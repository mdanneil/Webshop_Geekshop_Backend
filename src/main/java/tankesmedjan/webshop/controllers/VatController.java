package tankesmedjan.webshop.controllers;

import tankesmedjan.webshop.models.Vat;
import tankesmedjan.webshop.repos.VatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vat")
public class VatController {

    @Autowired
    private VatRepo vatRepo;

    @PostMapping
    public Vat addBrand(@RequestBody Vat vat) {
        vatRepo.save(vat);
        return vat;
    }
}