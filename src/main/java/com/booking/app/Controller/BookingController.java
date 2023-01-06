package com.booking.app.Controller;

import com.booking.app.domain.BookingDto;
import com.booking.app.domain.CustomerDto;
import com.booking.app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;


        /* 글쓰기(화면만 보여주는거) 버튼 누르고, 글쓰기 페이지 들어갈때. */
    @GetMapping("/write")
    public String write(Model m) {
        m.addAttribute("mode","new");
        return "board";
    }
        /* 글쓰기 */
    @PostMapping("/write")
    public String write(BookingDto bookingDto, CustomerDto customerDto, HttpSession session, Model m) {

        try {
//            String writer = (String) session.getAttribute("id");
//            bookingDto.setWriter(writer);
            System.out.println("bookingDto: " + bookingDto);
            int rowCount = bookingService.bookingInsert(bookingDto);
            int rowCount1 = bookingService.customerInsert(customerDto);
            return "redirect:/board/list";

        } catch (Exception e) {
            e.printStackTrace();

            // 만약 try 에서 DB에 게시글 저장하다가 에러나면 다시 원래 글쓰던 화면으로 방금 정보 다 가지고 돌아가게 하기.
            m.addAttribute("bookingDto", bookingDto);
            m.addAttribute("customerDto", customerDto);
            return "board";
        }
    }
    @GetMapping("/list")
    public String list( Model m, HttpServletRequest request) {




        try {
            BookingDto bookingDto = new BookingDto();
            CustomerDto customerDto = new CustomerDto();
            Map map = new HashMap();
            map.put("bookingDto",bookingDto);
            map.put("customerDto",customerDto);
            List<BookingDto> list = bookingService.bookingList(map);
            // 이렇게 하면 최근 글 10개 가져온다.
            // view에 넘길거니까 모델에 담아서 보낸다.
            m.addAttribute("list", list);


            System.out.println("list: " + list);

            return "boardList";

        } catch (Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
            return "0";
        }

    }

}
