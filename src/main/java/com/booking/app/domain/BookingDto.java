package com.booking.app.domain;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookingDto {
    private int reservationNumber;   //예약번호

    private Integer customerNumber;     //고객번호
    private Integer companyNumber;      //사업장번호
    private Integer personnel;              //인원수
    private String requirements;        //요구사항
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm")
    private String reservationDate;       //예약일
    private char visitStatus;           //방문여부(Y:방문,N:방문안함,C:고객임의취소)
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm")
    private Date createDate;        //요청일


    public BookingDto() {
    }

    public BookingDto(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public BookingDto(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public BookingDto(Integer customerNumber, Integer companyNumber, Integer personnel, String requirements, String reservationDate, char visitStatus) {
        this.customerNumber = customerNumber;
        this.companyNumber = companyNumber;
        this.personnel = personnel;
        this.requirements = requirements;
        this.reservationDate = reservationDate;
        this.visitStatus = visitStatus;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Integer getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(Integer companyNumber) {
        this.companyNumber = companyNumber;
    }

    public Integer getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Integer personnel) {
        this.personnel = personnel;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public char getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(char visitStatus) {
        this.visitStatus = visitStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "reservationNumber=" + reservationNumber +
                ", customerNumber=" + customerNumber +
                ", companyNumber=" + companyNumber +
                ", personnel=" + personnel +
                ", requirements='" + requirements + '\'' +
                ", reservationDate='" + reservationDate + '\'' +
                ", visitStatus=" + visitStatus +
                ", createDate=" + createDate +
                '}';
    }
}
