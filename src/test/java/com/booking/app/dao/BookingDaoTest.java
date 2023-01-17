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
import java.util.Date;
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
            CustomerDto customerDto = new CustomerDto("개정보"+i, "010-"+i+"5-423"+i);
            assertTrue(bookingDao.CustomerInsert(customerDto) == 1);
            String s = "2020-02-09 15:30";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            java.util.Date date = sdf.parse(s);
            BookingDto bookingDto = new BookingDto(1, 13, 1, "요구", "2023-01-16 +0"+i+":30", 'n');
            assertTrue(bookingDao.BookingInsert(bookingDto) == 1);
        }
    }
    @Test
    public void BookingDetail(){
        BookingDto bookingDto = new BookingDto(13);
        CustomerDto customerDto = new CustomerDto();
        SearchConditionDto sc = new SearchConditionDto();
          bookingDto.setReservationNumber(200);

        Map map = new HashMap();
        map.put("BookingDto",bookingDto);

        map.put("customerDto",customerDto);

        bookingDao.bookingDetail(map);
        System.out.println("aaaaa"+map);
    }
    @Test
    public void bookingSearchMap(){
        BookingDto bookingDto = new BookingDto("2023-01");
        CustomerDto customerDto = new CustomerDto();
        SearchConditionDto sc = new SearchConditionDto();
        sc.setCustomerName("정해");
        customerDto.setCustomerName("정해");
        Map map = new HashMap();
        map.put("bookingDto",bookingDto);
        map.put("customerDto",customerDto);
        map.put("sc",sc);

////
//        map.put("offset",0);
//        map.put("pageSize",10);

//            bookingDao.bookingSearchMap(map);
            bookingDao.bookingSearchMap(map);
        System.out.println("과목"+map);
    }
    @Test
    public void BookingSearchDate(){
        BookingDto bookingDto = new BookingDto();
        CustomerDto customerDto = new CustomerDto();

        SearchConditionDto sc = new SearchConditionDto("정해");

        Map map = new HashMap();
        map.put("customerDto",customerDto);

        List<BookingDto> list = bookingDao.bookingSearch(sc);
        assertTrue(list.size()<=50);
    }
    @Test
    public void BookingToday(){
        BookingDto bookingDto = new BookingDto();
        CustomerDto customerDto = new CustomerDto();
        SearchConditionDto sc = new SearchConditionDto(1,10,"","","");
        Map map = new HashMap();
        map.put("bookingDto",bookingDto);
        map.put("customerDto",customerDto);

        List<BookingDto> list = bookingDao.bookingToday(sc);
        assertTrue(list.size()<=50);
    }
    @Test
    public void BookingTodayCount() throws Exception {
        SearchConditionDto sc = new SearchConditionDto(1,10,"","","");

        int count = bookingDao.bookingTodayCount(sc);
        int count1 = bookingDao.bookingTodayVisitCount(sc);
        double count3 = count;
        double count4 = count1;
        System.out.println(count3);
        System.out.println(count);
        System.out.println(count1/count3);
        System.out.println(33.0/100.0);
        System.out.println(100.0/33);
        System.out.println(100.0/33.0);
        System.out.println("count = " + count/6*0.01);
        System.out.println("count33 = " +count+" :"+ count4/count3*100);
        double v = (count1 / count) * 100.0;
        System.out.println("count = " +  v);
        double a =  count1/count3*100;
        System.out.println(a);
    }
   /*   @Test
    public void BookingSearchNameAndPhone(){
//        BookingDto bookingDto = new BookingDto();
//        CustomerDto customerDto = new CustomerDto();
        SearchConditionDto sc = new SearchConditionDto("조니","010-0253-3319");

//        Map map = new HashMap();
//        map.put("customerDto",customerDto);

        List<BookingDto> list = bookingDao.bookingSearch(sc);
        assertTrue(list.size()<=50);
    }
  @Test
    public void BookingSearchPhone(){
//        BookingDto bookingDto = new BookingDto();
//        CustomerDto customerDto = new CustomerDto();
        SearchConditionDto sc = new SearchConditionDto("조니","010-0253-3319");

//        Map map = new HashMap();
//        map.put("customerDto",customerDto);

        List<BookingDto> list = bookingDao.bookingSearch(sc);
        assertTrue(list.size()<=50);
    }*/
    @Test
    public void searchSelectCount() throws Exception {
        SearchConditionDto sc = new SearchConditionDto(1,10,"1",null,null);

        int count = bookingDao.searchSelectCount(sc);
        System.out.println("count = " + count);
    }
}