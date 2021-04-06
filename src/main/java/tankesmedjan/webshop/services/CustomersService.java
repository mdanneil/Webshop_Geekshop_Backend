package tankesmedjan.webshop.services;

import org.springframework.stereotype.Service;
import tankesmedjan.webshop.models.Customers;
import tankesmedjan.webshop.models.Vat;
import tankesmedjan.webshop.repos.CustomersRepo;
import tankesmedjan.webshop.repos.VatRepo;

import java.util.List;

@Service
public class CustomersService {

    private final CustomersRepo customersRepo;

    CustomersService(CustomersRepo customersRepo){
        this.customersRepo = customersRepo;
    }

    public List<Customers> getCustomerAccount(String id) {
        return customersRepo.findByAccount_Id(id);
    }
}