package com.booking.app.domain;

public class CustomerDto {

    private int customerNumber2;
    private String customerName;
    private String customerPhone;

    public CustomerDto() {
    }

    public CustomerDto(String customerName) {
        this.customerName = customerName;
    }

    public CustomerDto(String customerName, String customerPhone) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    public int getCustomerNumber2() {
        return customerNumber2;
    }

    public void setCustomerNumber2(int customerNumber2) {
        this.customerNumber2 = customerNumber2;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
