package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.ProductRatingDTO;
import tankesmedjan.webshop.mappers.ProductRatingMapper;
import tankesmedjan.webshop.models.Product;
import tankesmedjan.webshop.models.ProductRating;
import tankesmedjan.webshop.repos.ProductRatingRepo;

import java.util.List;

@Service
public class ProductRatingService {

    private final ProductRatingRepo productRatingRepo;

    @Autowired
    public ProductRatingService(ProductRatingRepo productRatingRepo) {
        this.productRatingRepo = productRatingRepo;
    }

    /**
     * @param productRatingDTO is the input from the user, and maps to the entity ProductRating through mapstruct.
     * @return the input from the user.
     */

    public ProductRatingDTO addProductRating(ProductRatingDTO productRatingDTO) {

        ProductRating addNewRating =
                ProductRatingMapper.INSTANCE.dtoToProductRating(productRatingDTO);
        productRatingRepo.save(addNewRating);

        return productRatingDTO;
    }

    /**
     * Finds all ratings in the database.
     *
     * @return all ratings.
     */
    public List<ProductRating> getAllProductRating(){ return productRatingRepo.findAll();}

    /**
     *
     * @param Id
     * @return list with given rating for specific id.
     */

    //TODO: finsih him!

    public List<ProductRating> getAverageRatingsByProductIds(Long Id) {
        return productRatingRepo.getAverageRatingsByProductId(Id);
    }
}
