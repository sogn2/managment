package com.booking.app.dao;

import com.booking.app.domain.BookingDto;
import com.booking.app.domain.CustomerDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
    public class GraphDaoTest {

        @Autowired
        GraphDao graphDao;
    @Test
    public void vipCustomerTen() {
        BookingDto bookingDto = new BookingDto();
        CustomerDto customerDto = new CustomerDto();
        bookingDto.setReservationDate("2023-01-05 14:30");
        System.out.println("bookingDto.getReservationDate() = " + bookingDto.getReservationDate());
        graphDao.vipCustomerTen(bookingDto.getReservationDate());
    }
}