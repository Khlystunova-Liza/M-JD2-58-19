package by.pvt.dto;

public class Products {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.product_id
     *
     * @mbg.generated Thu Jul 25 18:38:05 MSK 2019
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.product_name
     *
     * @mbg.generated Thu Jul 25 18:38:05 MSK 2019
     */
    private String productName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.price
     *
     * @mbg.generated Thu Jul 25 18:38:05 MSK 2019
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column products.exists
     *
     * @mbg.generated Thu Jul 25 18:38:05 MSK 2019
     */
    private Boolean exists;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.product_id
     *
     * @return the value of products.product_id
     *
     * @mbg.generated Thu Jul 25 18:38:05 MSK 2019
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.product_id
     *
     * @param productId the value for products.product_id
     *
     * @mbg.generated Thu Jul 25 18:38:05 MSK 2019
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.product_name
     *
     * @return the value of products.product_name
     *
     * @mbg.generated Thu Jul 25 18:38:05 MSK 2019
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.product_name
     *
     * @param productName the value for products.product_name
     *
     * @mbg.generated Thu Jul 25 18:38:05 MSK 2019
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.price
     *
     * @return the value of products.price
     *
     * @mbg.generated Thu Jul 25 18:38:05 MSK 2019
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.price
     *
     * @param price the value for products.price
     *
     * @mbg.generated Thu Jul 25 18:38:05 MSK 2019
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column products.exists
     *
     * @return the value of products.exists
     *
     * @mbg.generated Thu Jul 25 18:38:05 MSK 2019
     */
    public Boolean getExists() {
        return exists;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column products.exists
     *
     * @param exists the value for products.exists
     *
     * @mbg.generated Thu Jul 25 18:38:05 MSK 2019
     */
    public void setExists(Boolean exists) {
        this.exists = exists;
    }
}