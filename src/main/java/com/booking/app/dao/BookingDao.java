package com.booking.app.dao;

import com.booking.app.domain.BookingDto;
import com.booking.app.domain.CustomerDto;
import com.booking.app.domain.SearchConditionDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookingDao {

    @Autowired
    private SqlSession session;

    private  static String namespace = "com.booking.app.dao.BookingMapper.";
    /*고객 테이블 삽입*/
    public int CustomerInsert(CustomerDto dto) throws Exception {
        return session.insert(namespace+"customerInsert", dto);
    }
    /*예약 테이블 삽입*/
    public int BookingInsert(BookingDto dto) throws Exception {
        return session.insert(namespace+"bookingInsert", dto);
    }
    /*리스트 조회인데 실질적으로 사용안함*/
    public Map bookingDetail(Map map) {

        return session.selectOne(namespace+"bookingDetail",map);
    }
    /*search결과, 전체리스트 조회*/
    public List<BookingDto> bookingSearchMap(Map map) {
        return session.selectList(namespace+"bookingSearchMap",map);
    }
    /*당일 예약 목록*/
    public List<BookingDto> bookingToday(SearchConditionDto sc) {
        return session.selectList(namespace+"bookingToday",sc);
    }
/*금일 방문 횟수*/
    public int bookingTodayVisitCount(SearchConditionDto sc) throws  Exception{
        return session.selectOne(namespace+"bookingTodayVisitCount",sc);
    }
    public int bookingTodayCount(SearchConditionDto sc) throws  Exception{
        return session.selectOne(namespace+"bookingTodayCount",sc);
    }
    public List<BookingDto> bookingSearch(SearchConditionDto sc){
        return session.selectList(namespace+"bookingSearch",sc);
    }
    public int searchSelectCount(SearchConditionDto sc) throws  Exception{
        return session.selectOne(namespace+"searchSelectCount",sc);
    }
}
