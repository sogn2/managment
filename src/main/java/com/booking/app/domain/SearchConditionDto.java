package com.booking.app.domain;

import java.util.Date;

public class SearchConditionDto {
    private Integer page =1;              //페이지
    private Integer pageSize =10;         //페이지 사이즈
    private Integer offset=0;
    private String customerName;          //고객명
    private String customerPhone;         // 휴대폰
    private String reservationDate;       //예약일

    public SearchConditionDto() {
    }


    public SearchConditionDto(Integer page, Integer pageSize, String customerName, String customerPhone, String reservationDate) {
        this.page = page;
        this.pageSize = pageSize;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.reservationDate = reservationDate;
    }

    public SearchConditionDto(String customerName) {
        this.customerName = customerName;
    }

//    public SearchConditionDto(String customerName, String customerPhone) {
//        this.customerName = customerName;
//        this.customerPhone = customerPhone;
//    }

//    public SearchConditionDto(Date reservationDate) {
//        this.reservationDate = reservationDate;
//    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
