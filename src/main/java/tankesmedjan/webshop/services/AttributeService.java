package tankesmedjan.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tankesmedjan.webshop.dto.AttributeDTO;
import tankesmedjan.webshop.dto.AttributeOptionDTO;
import tankesmedjan.webshop.mappers.AttributeMapper;
import tankesmedjan.webshop.mappers.AttributeOptionMapper;
import tankesmedjan.webshop.models.Attribute;
import tankesmedjan.webshop.models.AttributeOption;
import tankesmedjan.webshop.models.SKU;
import tankesmedjan.webshop.repos.AttributeOptionRepo;
import tankesmedjan.webshop.repos.AttributeRepo;

import java.util.List;

@Service
public class AttributeService {

    @Autowired
    private AttributeRepo attributeRepo;

    @Autowired
    private AttributeOptionRepo attributeOptionRepo;

    public AttributeDTO saveAttribute(AttributeDTO attributeDTO) {
        Attribute addNewAttribute = AttributeMapper.INSTANCE.DtoToAttribute(attributeDTO);
        attributeRepo.save(addNewAttribute);
        return attributeDTO;
    }

    public AttributeOptionDTO addAttributeOption(AttributeOptionDTO attributeOptionDTO) {
        AttributeOption addNewAttributeOption =
                AttributeOptionMapper.INSTANCE.DtoToAttributeOption(attributeOptionDTO);
        attributeOptionRepo.save(addNewAttributeOption);

        return attributeOptionDTO;
    }

    public List<SKU> getAttributesListForProductId(Long id) {
        return attributeOptionRepo.findAllAttributesForProduct(id);
    }
}
