package com.booking.app.service;

import com.booking.app.dao.BookingDao;
import com.booking.app.domain.BookingDto;
import com.booking.app.domain.CustomerDto;
import com.booking.app.domain.SearchConditionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookingService {
    @Autowired
    BookingDao bookingDao;
    /* 예약정보 등록 */
    public  int bookingInsert(BookingDto bookingDto) throws Exception {
        return bookingDao.BookingInsert(bookingDto);
    }
    /* 예약고객 정보등록 */
    public  int customerInsert(CustomerDto customerDto) throws Exception {
        return bookingDao.CustomerInsert(customerDto);
    }
//    public BookingDto bookingDetail(Map map) throws Exception {
//        return bookingDao.bookingDetail(map);
//    }
    public List<BookingDto> bookingSearch(SearchConditionDto dto){
        return bookingDao.bookingSearch(dto);
    }
    public List<BookingDto> bookingSearchMap(Map map){
        return bookingDao.bookingSearchMap(map);
    }

    public int getSearchResultCnt(SearchConditionDto sc) throws Exception {
        return bookingDao.searchSelectCount(sc);
    }
/*전체 방문 현황*/
    public int bookingTotalVisit (BookingDto dto) throws Exception {
        return bookingDao.bookingTotalVisit(dto);
    }
    public List<BookingDto> bookingToday(SearchConditionDto sc){
        return bookingDao.bookingToday(sc);
    }

/*당일 예약 전체 현황*/
    public int bookingTodayCount(SearchConditionDto sc) throws Exception {
        return bookingDao.bookingTodayCount(sc);
    }
/*당일 방문 현황*/
    public int bookingTodayVisitCount() throws Exception {
        return bookingDao.bookingTodayVisitCount();
    }
}
