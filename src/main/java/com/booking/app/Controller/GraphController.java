package com.booking.app.Controller;

import com.booking.app.domain.BookingDto;
import com.booking.app.domain.CustomerDto;
import com.booking.app.domain.PageHandler;
import com.booking.app.domain.SearchConditionDto;
import com.booking.app.service.BookingService;
import com.booking.app.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class GraphController {
    @Autowired
    GraphService graphService;


    @GetMapping("/vipTopTen")
    @ResponseBody
    public List<BookingDto> vipCustomerTen(String reservationDate, BookingDto bookingDto)  throws Exception {

        bookingDto.setReservationDate(reservationDate);
        System.out.println(bookingDto.getReservationDate());
        System.out.println(graphService.vipCustomerTen(reservationDate));
        return graphService.vipCustomerTen(bookingDto.getReservationDate());
    }

}
