package com.booking.app.dao;

import com.booking.app.domain.BookingDto;
import com.booking.app.domain.CustomerDto;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BookingDaoTest {

    @Autowired
    BookingDao bookingDao;
    @Test
    public void BookingInsert() throws Exception {
        CustomerDto customerDto = new CustomerDto("이름","1");
        assertTrue(bookingDao.CustomerInsert(customerDto)==1);
        String s = "2023-01-08 15:30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        java.util.Date date = sdf.parse(s);
        BookingDto bookingDto = new BookingDto(1, 13, 1,  "요구",date, 'n',customerDto);
        assertTrue(bookingDao.BookingInsert(bookingDto)==1);

    }
}