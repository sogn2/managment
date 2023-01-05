package com.booking.app.dao;

import com.booking.app.domain.BookingDto;
import com.booking.app.domain.CustomerDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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


}
