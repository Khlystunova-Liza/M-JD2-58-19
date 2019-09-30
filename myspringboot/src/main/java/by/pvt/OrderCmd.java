package by.pvt;

import java.io.Serializable;
import java.util.Date;

public class OrderCmd implements Serializable {

    Long id;
    Long productId;
    Double productPrice;
    Integer itemCount;
    String comment;
    Date createDate;

    public OrderCmd() {
    }

    public OrderCmd(Long id, Long productId, Double productPrice, Integer itemCount, String comment, Date createDate) {
        this.id = id;
        this.productId = productId;
        this.productPrice = productPrice;
        this.itemCount = itemCount;
        this.comment = comment;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderCmd order = (OrderCmd) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (productId != null ? !productId.equals(order.productId) : order.productId != null) return false;
        if (productPrice != null ? !productPrice.equals(order.productPrice) : order.productPrice != null) return false;
        if (itemCount != null ? !itemCount.equals(order.itemCount) : order.itemCount != null) return false;
        if (comment != null ? !comment.equals(order.comment) : order.comment != null) return false;
        return createDate != null ? createDate.equals(order.createDate) : order.createDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (itemCount != null ? itemCount.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
