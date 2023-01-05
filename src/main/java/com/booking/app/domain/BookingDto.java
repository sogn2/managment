package com.booking.app.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookingDto {
    private int reservationNumber;   //예약번호

    private int customerNumber;     //고객번호
    private int companyNumber;      //사업장번호
    private int personnel;              //인원수
    private String Requirements;        //요구사항
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date reservationDate;       //예약일
    private char visitStatus;           //방문여부(Y:방문,N:방문안함,C:고객임의취소)

    private     CustomerDto customerDto;

    public BookingDto() {
    }

    public BookingDto(int customerNumber, int companyNumber, int personnel, String requirements, Date reservationDate, char visitStatus, CustomerDto customerDto) {
        this.customerNumber = customerNumber;
        this.companyNumber = companyNumber;
        this.personnel = personnel;
        Requirements = requirements;
        this.reservationDate = reservationDate;
        this.visitStatus = visitStatus;
        this.customerDto = customerDto;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    public int getPersonnel() {
        return personnel;
    }

    public void setPersonnel(int personnel) {
        this.personnel = personnel;
    }

    public String getRequirements() {
        return Requirements;
    }

    public void setRequirements(String requirements) {
        Requirements = requirements;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public char getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(char visitStatus) {
        this.visitStatus = visitStatus;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }
}
