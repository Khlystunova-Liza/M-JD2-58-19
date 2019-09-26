package by.pvt.repository;

import by.pvt.pojo.ProductCatalogItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//репозиторий это и есть dao(create,read,update,delete,find(их много)), репозитарий дергает уже непосредсвенно бд
@Repository
public class ProductCatalogRepository {

    @Autowired
    SessionFactory sessionFactory;

   public List<ProductCatalogItem> findAll(int count){
       Session currentSession = sessionFactory.getCurrentSession();

       List<ProductCatalogItem> productCatalogItem =
               currentSession.createQuery("from ProductCatalogItem",ProductCatalogItem.class)
                       .setMaxResults(count)
                       .list();

       return productCatalogItem;

    }

    public ProductCatalogItem findItemById(Long id) {

        return sessionFactory.getCurrentSession()
                .get(ProductCatalogItem.class,id);
    }

    public List<ProductCatalogItem> findByProductName(String str, int count) {
        return sessionFactory.getCurrentSession()
                .createQuery("from ProductCatalogItem where itemName like %:searchStr%",ProductCatalogItem.class)
                .setParameter("searchStr","%"+str+"%")
                .setMaxResults(count)
                .list();

    }

    public boolean add(ProductCatalogItem item) {
        sessionFactory.getCurrentSession()
                .persist(item);
        return true;
    }

    public Long getMaxId(){

        return sessionFactory.getCurrentSession()
                .createQuery("select max(id) from ProductCatalogItem", Long.class)
                .getSingleResult();
    }
}
