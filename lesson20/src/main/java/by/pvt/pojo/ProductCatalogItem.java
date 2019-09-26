package by.pvt.pojo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.logging.Logger;

@Entity
@SequenceGenerator(name="catalog_item_seq")
public class ProductCatalogItem implements Serializable {


    @Transient
    private static Logger Log = Logger.getLogger("ProductCatalogItem");

    @Id
    @GeneratedValue(generator = "catalog_item_seq" ,strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String itemName;

    @Column
    private Double price;

    @Column
    @Lob
    private byte[] productImage;

    public ProductCatalogItem() {
    }

    public ProductCatalogItem(Long id, String itemName, Double price) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    @Override
    public String toString() {
        return "ProductCatalogItem{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", productImage=" + Arrays.toString(productImage) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCatalogItem item = (ProductCatalogItem) o;

        if (!id.equals(item.id)) return false;
        if (itemName != null ? !itemName.equals(item.itemName) : item.itemName != null) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        return Arrays.equals(productImage, item.productImage);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(productImage);
        return result;
    }
}



