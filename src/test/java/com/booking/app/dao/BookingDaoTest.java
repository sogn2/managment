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
        for (int i = 0; i<9;i++) {
            CustomerDto customerDto = new CustomerDto("한선영", "010-2284-231"+i);
            assertTrue(bookingDao.CustomerInsert(customerDto) == 1);
            String s = "2020-02-09 15:30";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            java.util.Date date = sdf.parse(s);
            BookingDto bookingDto = new BookingDto(1, 13, 1, "요구", "2023-01-26 0"+i+":30", 'N');
            assertTrue(bookingDao.BookingInsert(bookingDto) == 1);
        }
    }

    @Test
    public void BookingUpdate() throws Exception {

            CustomerDto customerDto = new CustomerDto(1,"개정보", "010-5-423");
        System.out.println(customerDto);
            assertTrue(bookingDao.customerUpdate(customerDto) == 1);
            String s = "2020-02-09 15:30";
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//            java.util.Date date = sdf.parse(s);
            BookingDto bookingDto = new BookingDto(1,1, 13, 10, "장그래 화이팅", "2023-01-16 0:30", 'Y');
            assertTrue(bookingDao.bookingUpdate(bookingDto) == 1);

    }
    @Test
    public void BookingDelete() throws Exception {
        BookingDto bookingDto = new BookingDto();
        CustomerDto customerDto = new CustomerDto();
        SearchConditionDto sc = new SearchConditionDto();
        Integer reservationNumber=17;

//        System.out.println( bookingDto.setReservationNumber(reservationNumber));
        System.out.println("이거"+reservationNumber);
            bookingDao.CustomerDelete(reservationNumber);
        System.out.println( bookingDao.BookingDelete(reservationNumber));

    }

    @Test
    public void BookingDetail(){
        BookingDto bookingDto = new BookingDto();
        CustomerDto customerDto = new CustomerDto();
        SearchConditionDto sc = new SearchConditionDto();
        Integer reservationNumber=17;
        bookingDto.setReservationNumber(reservationNumber);
        System.out.println("이거"+reservationNumber);
        Map map = new HashMap();
        map.put("bookingDto",bookingDto);

        map.put("customerDto",customerDto);

        bookingDao.bookingDetail(reservationNumber);
        System.out.println(bookingDao.bookingDetail(reservationNumber));

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
/*데이터 입력부*/
        int todayTotal = bookingDao.bookingTodayCount(sc);
        double todayTotal1 = todayTotal;
        int today = bookingDao.bookingTodayVisitCount();
        double today1 = today;
        if (todayTotal!=0){
        /*int형 숫자 계산*/
        int result = today/todayTotal*100;
//        (더블 타입 숫자계산)
        double rusult1 =today1/todayTotal1*100;
        /*더블타입 한거 int로 반환*/
        int result2 = (int) rusult1;
        /*데이터 정제*/
        System.out.println(todayTotal+"여기"+today);
        System.out.println(todayTotal1+"여기1 "+today1);
        
//        System.out.println("int형 계산한거"+result);
        System.out.println("더블타입 계산한거 = " + rusult1);
        System.out.println("더블타입 int로 반환한거 = " + result2);
        }else {
            System.out.println("전체일수가 0");
        }
    }
    @Test
    public void bookingTotalVisit() throws Exception {
        BookingDto dto = new BookingDto();
        bookingDao.bookingTotalVisit(dto);
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
        SearchConditionDto sc = new SearchConditionDto(1,10,null,null,null);
        BookingDto dto= new BookingDto();
        int total = bookingDao.searchSelectCount(sc);
        double total1 = total;
        int count = bookingDao.bookingTotalVisit(dto);//당일 방문 횟수
        double count1= count;

        double result =count1/total1*100;
        /*더블타입 한거 int로 반환*/
        int result2 = (int) result;

        System.out.println(total);
        System.out.println("count = " + count);
        System.out.println(total1+" "+count1);
        System.out.println("int형 계산"+count/total*100);
        System.out.println("double 계산"+count1/total1*100);
        System.out.println("3형 계산"+count1/total*100);
        System.out.println("4e 계산"+count/total1*100);
        System.out.println(result);
        System.out.println(result2);
    }
}