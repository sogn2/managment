package com.booking.app.Controller;

import com.booking.app.domain.BookingDto;
import com.booking.app.domain.CustomerDto;
import com.booking.app.domain.PageHandler;
import com.booking.app.domain.SearchConditionDto;
import com.booking.app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
//    @GetMapping("/write")
//    public String write(Model m) {
//        m.addAttribute("mode","new");
//        return "redirect:/board/list";
//    }
    /* 글쓰기 */
    @PostMapping("/write")
    public String write(BookingDto bookingDto, CustomerDto customerDto, HttpSession session, Model m) {

        try {
//            String writer = (String) session.getAttribute("id");
//            bookingDto.setWriter(writer);
            int customer =  bookingService.customerInsert(customerDto);
            int booking= bookingService.bookingInsert(bookingDto);

            if (booking != 1 && customer !=1){
                throw new Exception("게시글 등록 오류");
            }
            System.out.println("booking = " + booking);
            System.out.println("customer = " + customer);
            return "redirect:/list";

        } catch (Exception e) {
            e.printStackTrace();

            // 만약 try 에서 DB에 게시글 저장하다가 에러나면 다시 원래 글쓰던 화면으로 방금 정보 다 가지고 돌아가게 하기.
            m.addAttribute("bookingDto", bookingDto);
            m.addAttribute("customerDto", customerDto);
            return "boardList";
        }
    }



    @GetMapping("/list")
    public String list(SearchConditionDto sc, Model m, HttpServletRequest request) {
        try {
            Integer page = sc.getPage();
            Integer pageSize = sc.getPageSize();


            // null 값 들어왔을때 대비
            if(page==null) {page=1; sc.setPage(1);}
            if(pageSize==null) {pageSize=10; sc.setPageSize(10);}


            // 종 게시물 개수 구해서
            int totalCount = bookingService.getSearchResultCnt(sc);
            System.out.println("totalCount22: " + totalCount);

            // 페이징 계산하기(마지막 페이지가 몇번째인지)
            PageHandler pageHandler = new PageHandler(totalCount, page, pageSize);
            System.out.println("pageHandler22 : " + pageHandler);

            List<BookingDto> list = bookingService.bookingSearch(sc);

            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);

            System.out.println(sc);

            return "boardList";

        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }

    }
    @GetMapping("/today")
    public String todayList(SearchConditionDto sc, Model m, HttpServletRequest request) {
        try {
            Integer page = sc.getPage();
            Integer pageSize = sc.getPageSize();


            // null 값 들어왔을때 대비
            if(page==null) {page=1; sc.setPage(1);}
            if(pageSize==null) {pageSize=10; sc.setPageSize(10);}


            // 종 게시물 개수 구해서
            int totalCount = bookingService.bookingTodayCount(sc);
            System.out.println("totalCount22: " + totalCount);

            // 페이징 계산하기(마지막 페이지가 몇번째인지)
            PageHandler pageHandler = new PageHandler(totalCount, page, pageSize);
            System.out.println("pageHandler22 : " + pageHandler);

            BookingDto bookingDto = new BookingDto();
            CustomerDto customerDto = new CustomerDto();

            List<BookingDto> todayList = bookingService.bookingToday(sc);

            m.addAttribute("list", todayList);
            m.addAttribute("ph", pageHandler);



            return "todayList";

        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }

    }
    @GetMapping("/bookingTodayVisitCount")
    @ResponseBody
    public  int[] bookingTodayVisitCount() throws Exception {
        SearchConditionDto sc = new SearchConditionDto();
        int todayTotal = bookingService.bookingTodayCount(sc);
        double todayTotal1 = todayTotal;
        int today = bookingService.bookingTodayVisitCount();
        double today1 = today;
        int[] tov = {0, 0, 0};
        if(todayTotal!=0) {
            int result = today / todayTotal * 100;
            double rusult1 = today1 / todayTotal1 * 100;
            int result2 = (int) rusult1;

            tov = new int[]{today, todayTotal, result2};
        }
        return tov;
    }
    @GetMapping("/bookingTotalVisitCount")
    @ResponseBody
    public  int[] bookingTotalVisitCount() throws Exception {
        BookingDto dto = new BookingDto();
        SearchConditionDto sc = new SearchConditionDto();
        int totalVisit = bookingService.getSearchResultCnt(sc);
        double totalVisitDouble = totalVisit;
        int visit = bookingService.bookingTotalVisit(dto);
        double visit1 = visit;
        int[] totalVisitArr = {0, 0, 0};
        if(totalVisit!=0) {
            int result = visit / totalVisit * 100;
            double rusult1 = visit1 / totalVisitDouble * 100;
            int result2 = (int) rusult1;

            totalVisitArr = new int[]{visit, totalVisit, result2};
            System.out.println(totalVisitArr);
        }
        return totalVisitArr;
    }
}
