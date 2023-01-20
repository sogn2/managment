package com.booking.app.service;

import com.booking.app.dao.BookingDao;
import com.booking.app.dao.GraphDao;
import com.booking.app.domain.BookingDto;
import com.booking.app.domain.CustomerDto;
import com.booking.app.domain.SearchConditionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GraphService {
    @Autowired
    GraphDao graphDao;

    public List<BookingDto> vipCustomerTen(String reservationDate) throws Exception {
        return graphDao.vipCustomerTen(reservationDate);
    }

}
