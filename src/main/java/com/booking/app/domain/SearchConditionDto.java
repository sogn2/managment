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

    public SearchConditionDto(String customerName, String customerPhone, String reservationDate) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.reservationDate = reservationDate;
    }

    public SearchConditionDto(Integer page, Integer pageSize, Integer offset, String customerName, String customerPhone, String reservationDate) {
        this.page = page;
        this.pageSize = pageSize;
        this.offset = offset;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.reservationDate = reservationDate;
    }

    public SearchConditionDto(String customerName) {
        this.customerName = customerName;
    }

    public SearchConditionDto(Integer pageSize, Integer offset, String customerName, String customerPhone, String reservationDate) {
        this.pageSize = pageSize;
        this.offset = offset;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.reservationDate = reservationDate;
    }

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

    public Integer getOffset() {
        return (page-1)*pageSize;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
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

    @Override
    public String toString() {
        return "SearchConditionDto{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", reservationDate='" + reservationDate + '\'' +
                '}';
    }
}
