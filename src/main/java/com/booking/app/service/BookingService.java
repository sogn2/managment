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
    public List<BookingDto> bookingList(Map map) throws Exception {
        return bookingDao.bookingList(map);
    }
    public List<BookingDto> bookingSearch(SearchConditionDto dto){
        return bookingDao.bookingSearch(dto);
    }
}
