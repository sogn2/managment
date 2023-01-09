package com.booking.app.dao;

import com.booking.app.domain.BookingDto;
import com.booking.app.domain.CustomerDto;
import com.booking.app.domain.SearchConditionDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BookingDaoTest {

    @Autowired
    BookingDao bookingDao;
    @Test
    public void BookingInsert() throws Exception {
        for(int i=0; i<10; i++) {
            CustomerDto customerDto = new CustomerDto(i+"조니뎁", "010-0253-331"+i);
            assertTrue(bookingDao.CustomerInsert(customerDto) == 1);
            String s = "2022-02-09 15:30";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            java.util.Date date = sdf.parse(s);
            BookingDto bookingDto = new BookingDto(1, 13, 1, "요구", "2020-1-0"+i+" 15:30", 'n');
            assertTrue(bookingDao.BookingInsert(bookingDto) == 1);
        }
    }
    @Test
    public void BookingList(){
        BookingDto bookingDto = new BookingDto();
        CustomerDto customerDto = new CustomerDto();
        Map map = new HashMap();
        map.put("bookingDto",bookingDto);
        map.put("customerDto",customerDto);

        List<BookingDto> list = bookingDao.bookingList(map);
        assertTrue(list.size()>50);
    }

    @Test
    public void BookingSearch(){
//        BookingDto bookingDto = new BookingDto();
//        CustomerDto customerDto = new CustomerDto();
        SearchConditionDto sc = new SearchConditionDto("조니");
//        Map map = new HashMap();
//        map.put("customerDto",customerDto);

        List<BookingDto> list = bookingDao.bookingSearch(sc);
        assertTrue(list.size()<=50);
    }
}