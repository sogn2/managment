package com.booking.app.dao;

import com.booking.app.domain.BookingDto;
import com.booking.app.domain.CustomerDto;
import com.booking.app.domain.SearchConditionDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BookingDao {

    @Autowired
    private SqlSession session;

    private  static String namespace = "com.booking.app.dao.BookingMapper.";

    public int CustomerInsert(CustomerDto dto) throws Exception {
        return session.insert(namespace+"customerInsert", dto);
    }
    public int BookingInsert(BookingDto dto) throws Exception {
        return session.insert(namespace+"bookingInsert", dto);
    }
    public List<BookingDto> bookingList(Map map) {
        return session.selectList(namespace+"bookingList",map);
    }
    public List<BookingDto> bookingSearchMap(Map map) {
        return session.selectList(namespace+"bookingSearchMap",map);
    }
    public List<BookingDto> bookingSearch(SearchConditionDto sc){
        return session.selectList(namespace+"bookingSearch",sc);
    }
    public int searchSelectCount(SearchConditionDto sc) throws  Exception{
        return session.selectOne(namespace+"searchSelectCount",sc);
    }
}
