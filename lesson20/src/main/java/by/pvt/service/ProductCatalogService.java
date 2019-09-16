package by.pvt.service;

import by.pvt.pojo.ProductCatalogItem;
import by.pvt.repository.ProductCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//сервис организует логику ( проверку чего-нибудь например) и дергает потом хранилище
@Service
public class ProductCatalogService {

    @Autowired
    ProductCatalogRepository productCatalogRepository;

    public List<ProductCatalogItem> getFirstTopTenProducts(){

        List<ProductCatalogItem> allProducts = productCatalogRepository.findAll(10);
        return allProducts;

    }

    public ProductCatalogItem findItem(Long id) {
        return productCatalogRepository.findItemById(id);
        }

    public List<ProductCatalogItem> searchByProductName(String str) {
        return productCatalogRepository.findByProductName(str,5);
    }

    //добавляет продукт в хранилище
    public boolean addItem(ProductCatalogItem item){
        if(item.getPrice()== null || item.getPrice()<=0 || item.getItemName()== null || item.getItemName().isEmpty()) {
            return false;
        }
        if(item.getId() == null){
            item.setId(generateProductItemId());
        }
        return productCatalogRepository.add(item);
    }

    private Long generateProductItemId() {
        Long maxId = productCatalogRepository.getMaxId();
        return ++maxId;
    }
}
