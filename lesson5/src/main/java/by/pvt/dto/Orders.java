package by.pvt.dto;

public class Orders {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.order_id
     *
     * @mbg.generated Mon Jul 22 19:51:03 MSK 2019
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.client_id
     *
     * @mbg.generated Mon Jul 22 19:51:03 MSK 2019
     */
    private Integer clientId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.product_id
     *
     * @mbg.generated Mon Jul 22 19:51:03 MSK 2019
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.number
     *
     * @mbg.generated Mon Jul 22 19:51:03 MSK 2019
     */
    private Integer number;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.order_id
     *
     * @return the value of orders.order_id
     *
     * @mbg.generated Mon Jul 22 19:51:03 MSK 2019
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.order_id
     *
     * @param orderId the value for orders.order_id
     *
     * @mbg.generated Mon Jul 22 19:51:03 MSK 2019
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.client_id
     *
     * @return the value of orders.client_id
     *
     * @mbg.generated Mon Jul 22 19:51:03 MSK 2019
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.client_id
     *
     * @param clientId the value for orders.client_id
     *
     * @mbg.generated Mon Jul 22 19:51:03 MSK 2019
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.product_id
     *
     * @return the value of orders.product_id
     *
     * @mbg.generated Mon Jul 22 19:51:03 MSK 2019
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.product_id
     *
     * @param productId the value for orders.product_id
     *
     * @mbg.generated Mon Jul 22 19:51:03 MSK 2019
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.number
     *
     * @return the value of orders.number
     *
     * @mbg.generated Mon Jul 22 19:51:03 MSK 2019
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.number
     *
     * @param number the value for orders.number
     *
     * @mbg.generated Mon Jul 22 19:51:03 MSK 2019
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
}