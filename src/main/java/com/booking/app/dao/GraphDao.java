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
public class GraphDao {

    @Autowired
    private SqlSession session;

    private  static String namespace = "com.booking.app.dao.GraphMapper.";
    /*고객 테이블 삽입*/


    /*리스트 조회인데 실질적으로 사용안함*/
    public List<BookingDto> vipCustomerTen(String reservationDate) {

        return session.selectList(namespace+"vipCustomer",reservationDate);
    }

}
