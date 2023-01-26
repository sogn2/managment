<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="logInOutLink" value="${ sessionScope.id==null ? '/login/login':'/login/logout' }" />
<c:set var="logInOutTxt" value="${ sessionScope.id==null ? 'login':'logout' }" />

<c:set var="userId" value="${ pageContext.request.getSession(false).getAttribute('id')==null ? '':pageContext.request.getSession(false).getAttribute('id') }" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/x-icon" href="/img/favicon.ico" />

    <title>금일 예약 현황</title>

    <!-- Custom fonts for this template-->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <style>
        .search_area{
            display: flex;
            gap: 30px;
        }
        .search_bar{
            width: 400px;}
        .pagination{
            justify-content: center;

        }
    </style>
    <link href="/css/sb-admin-2.min.css" rel="stylesheet">

<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="/">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Interface
        </div>

        <!-- Nav Item - Tables -->
        <li class="nav-item">
            <a class="nav-link" href="/today">
                <i class="fas fa-fw fa-table"></i>
                <span>당일 예약목록</span></a>
        </li>

        <!-- Nav Item - Tables -->
        <li class="nav-item">
            <a class="nav-link" href="/list">
                <i class="fas fa-fw fa-table"></i>
                <span>전체 예약목록</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Addons
        </div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
               aria-expanded="true" aria-controls="collapsePages">
                <i class="fas fa-fw fa-folder"></i>
                <span>Pages</span>
            </a>
            <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Login Screens:</h6>
                    <a class="collapse-item" href="login.html">Login</a>
                    <a class="collapse-item" href="register.html">Register</a>
                    <a class="collapse-item" href="forgot-password.html">Forgot Password</a>
                    <div class="collapse-divider"></div>
                    <h6 class="collapse-header">Other Pages:</h6>
                    <a class="collapse-item" href="404.html">404 Page</a>
                    <a class="collapse-item" href="blank.html">Blank Page</a>
                </div>
            </div>
        </li>

        <!-- Nav Item - Charts -->
        <li class="nav-item">
            <a class="nav-link" href="charts.html">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Charts</span></a>
        </li>

        <!-- Nav Item - Tables -->
        <li class="nav-item">
            <a class="nav-link" href="tables.html">
                <i class="fas fa-fw fa-table"></i>
                <span>Tables</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>



    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->
                <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">

                        <input type="text" id="reservationDate" class="form-control bg-light border-0 small" value="${param.reservationDate}" placeholder="예약일">


                        <input type="text" id="customerName" class="form-control bg-light border-0 small" value="${param.customerName}" placeholder="이름">

                        <input type="text" id="customerPhone" class="form-control bg-light border-0 small" value="${param.customerPhone}" placeholder="휴대폰">
                        <!-- <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                               aria-label="Search" aria-describedby="basic-addon2"> -->
                        <div class="input-group-append">
                            <button type="button" class="btn btn-primary" id="btn_search" name="btn_search">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                </form>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <!-- Nav Item - Alerts -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-bell fa-fw"></i>
                            <!-- Counter - Alerts -->
                            <span class="badge badge-danger badge-counter">3+</span>
                        </a>
                        <!-- Dropdown - Alerts -->
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="alertsDropdown">
                            <h6 class="dropdown-header">
                                Alerts Center
                            </h6>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-primary">
                                        <i class="fas fa-file-alt text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 12, 2019</div>
                                    <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-success">
                                        <i class="fas fa-donate text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 7, 2019</div>
                                    $290.29 has been deposited into your account!
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-warning">
                                        <i class="fas fa-exclamation-triangle text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 2, 2019</div>
                                    Spending Alert: We've noticed unusually high spending for your account.
                                </div>
                            </a>
                            <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                        </div>
                    </li>

                    <!-- Nav Item - Messages -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-envelope fa-fw"></i>
                            <!-- Counter - Messages -->
                            <span class="badge badge-danger badge-counter">7</span>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="messagesDropdown">
                            <h6 class="dropdown-header">
                                Message Center
                            </h6>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="img/undraw_profile_1.svg"
                                         alt="...">
                                    <div class="status-indicator bg-success"></div>
                                </div>
                                <div class="font-weight-bold">
                                    <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                        problem I've been having.</div>
                                    <div class="small text-gray-500">Emily Fowler · 58m</div>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="img/undraw_profile_2.svg"
                                         alt="...">
                                    <div class="status-indicator"></div>
                                </div>
                                <div>
                                    <div class="text-truncate">I have the photos that you ordered last month, how
                                        would you like them sent to you?</div>
                                    <div class="small text-gray-500">Jae Chun · 1d</div>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="img/undraw_profile_3.svg"
                                         alt="...">
                                    <div class="status-indicator bg-warning"></div>
                                </div>
                                <div>
                                    <div class="text-truncate">Last month's report looks great, I am very happy with
                                        the progress so far, keep up the good work!</div>
                                    <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                         alt="...">
                                    <div class="status-indicator bg-success"></div>
                                </div>
                                <div>
                                    <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                                        told me that people say this to all dogs, even if they aren't good...</div>
                                    <div class="small text-gray-500">Chicken the Dog · 2w</div>
                                </div>
                            </a>
                            <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                        </div>
                    </li>

                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                            <img class="img-profile rounded-circle"
                                 src="img/undraw_profile.svg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Profile
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                Settings
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                Activity Log
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <h1 class="h3 mb-1 text-gray-800">당일 예약 목록</h1>
                <p class="mb-4">당일 예약 목록을 보여드립니다</p>
                <!-- Content Row -->
                <div class="row">

                    <!-- Grow In Utility -->
                    <div class="col-lg-8">
                        <div class="card position-relative">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">예약 목록</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                        <tr>
                                            <th>예약번호</th>
                                            <th>예약일</th>
                                            <th>이름</th>
                                            <th>휴대폰</th>
                                            <th>인원</th>
                                            <th>요구사항</th>
                                            <th>방문여부</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${list}" var="booking">
                                            <tr class="cc">
                                                <td class="bb">${booking.reservationNumber}</td>
                                                <td>${booking.reservationDate}</td>
                                                <td>${booking.customerName}</td>
                                                <td>${booking.customerPhone}</td>
                                                <td>${booking.personnel}</td>
                                                <td>${booking.requirements}</td>
                                                <td>
                                                        <%--                                                    ${booking.visitStatus eq 'N'?'방문안함':'방문함'}--%>
                                                    <c:choose>
                                                        <c:when test="${booking.visitStatus eq 'Y'}">
                                                            방문함
                                                        </c:when>
                                                        <c:when test="${booking.visitStatus eq 'N'}">
                                                            방문안함
                                                        </c:when>
                                                        <c:otherwise>
                                                            취소
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td>

                                                    <input class="btn btn-primary aa" type="button" value="수정"> <input  class="btn btn-secondary bbb" type="button" value="삭제"></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                    <%--                                    <nav aria-label="Page navigation example">--%>
                                    <c:forEach items="${list}" var="booking"></c:forEach>
                                    <ul class="pagination page_bar">
                                        <li class="page-item">
                                            <c:if test="${ph.showPrev}">
                                                <a href="<c:url value='/today?page=${ph.beginPage-1}&pageSize=${ph.pageSize}&customerName=${param.customerName}&customerPhone=${param.customerPhone}&reservationDate=${param.reservationDate}' />" class="page-link">[이전]</a>
                                            </c:if>
                                        </li>

                                        <li class="page-item">
                                            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                                            <a href="<c:url value='/today?page=${i}&pageSize=${ph.pageSize}&customerName=${param.customerName}&customerPhone=${param.customerPhone}&reservationDate=${param.reservationDate}' /> " class="page-link ${i==ph.page?"pageActive":""}"> ${i}</a>
                                        </li>
                                        </c:forEach>
                                        <li class="page-item">
                                            <c:if test="${ph.showNext}">
                                                <a href="<c:url value='/today?page=${ph.endPage+1}&pageSize=${ph.pageSize}&customerName=${param.customerName}&customerPhone=${param.customerPhone}&reservationDate=${param.reservationDate}' />" class="page-link">[다음]</a>
                                            </c:if>
                                        </li>

                                    </ul>
                                    <%--                                    </nav>--%>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col-lg-4">
                        <div class="card position-relative full-height">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">예약 등록</h6>
                            </div>
                            <div class="card-body">
                                <form id="form" action=""  method="post">
                                    <input type="hidden"  id="reservationNumberList">

                                    <input type="hidden"  id="customerNumberList">
                                    <div class="small mb-1" >고객 이름</div>
                                    <input id="customerNameList" name="customerName" class="form-control mb-2" type="text" placeholder="이름" />
                                    <div class="small mb-1">휴대폰번호</div>
                                    <input id="customerPhoneList" name="customerPhone" class="form-control mb-2" type="text" placeholder="010-0000-0000" />
                                    <div class="small mb-1">예약 일시</div>
                                    <input id="reservationDateList" name="reservationDate" class="form-control mb-2" type="text" placeholder="2023-01-26 00:00" />
                                    <div class="small mb-1">인원수</div>
                                    <input id="personnelList" name="personnel" class="form-control mb-2" type="text" placeholder="인원수" />
                                    <div class="small mb-1">요구사항</div>
                                    <input id="requirementsList" name="requirements" class="form-control mb-2" type="text" placeholder="요구사항" />
                                    <div class="small mb-1">요구사항</div>
                                    <select id="visitStatusList" class="form-control" name="visitStatus">
                                        <option value="Y" >방문함</option>
                                        <option value="N" selected>방문안함</option>
                                        <option value="C" >취소</option>
                                    </select>
                                    <input type="hidden" name="companyNumber" value="13">
                                    <%--                                    <div class="d-flex align-items-end flex-column">--%>
                                    <div class="small mb-2"></div>
                                    <div class="btn-group d-flex align-items-center justify-content-center" role="group" aria-label="Basic example">

                                        <button class="btn btn-success" id="modifyBtn" type="button">수정</button>
                                        <button class="btn btn-primary" id="writeBtn" type="button">등록</button>

                                    </div>

                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Fade In Utility -->

</div>

</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

</div>
<!-- End of Content Wrapper -->

</div>
<div class="col-lg-12" id="ex1_Result1" ></div>
<div class="col-lg-12" id="ex1_Result2" ></div>
<!-- End of Page Wrapper -->
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="/js/sb-admin-2.min.js"></script>
<script>
    /*삭제*/
    $(".bbb").click(function(){

        let td = $(this).parent().parent();
        console.log("td"+td)
        let tr = td.children(0);
        console.log("tr"+tr);
        let no = tr.eq(0).text();
        console.log("no"+no);
        alert("눌림"+no);

        // 현재 클릭된 Row(<tr>)
        /*   let tr = $(this);
           let td = tr.children();

           let no = td.eq(0).text();
           console.log(no);*/

        $.ajax({
            url: "/remove",
            type: "POST",
            data: {"customerNumber2": no,
                "reservationNumber": no},
            success: function (data) {
                // 예약번호
                alert("삭제버튼눌림"+no)
            }
        });
    });

    /*등록*/
    // 테이블의 Row 클릭시 값 가져오기
    $(".aa").click(function(){
        let td = $(this).parent().parent();
        console.log("td"+td)
        let tr = td.children(0);
        console.log("tr"+tr);
        let no = tr.eq(0).text();
        let no1 = tr.eq(1).text();
        console.log("no 여기 "+no);
        console.log("no1 여기1 ="+no1);
        $("#reservationNumberList").prop("name","reservationNumber");

        $("#customerNumberList").prop("name","customerNumber");
        // 현재 클릭된 Row(<tr>)
        /*   let tr = $(this);
           let td = tr.children();

           let no = td.eq(0).text();
           console.log(no);*/

        $.ajax({
            url: "/bookingDetail?reservationNumber="+no,
            type: "GET",
            // dataType: "json",
            // data : JSON.stringify(person),
            success: function (data) {
                // 예약번호
                $('#reservationNumberList').val(no);
                $('#customerNumberList').val(no);
                // 고객이름
                $('#customerNameList').val(data.customerName);
                // 고객전화번호
                $('#customerPhoneList').val(data.customerPhone);
                // 예약일
                $('#reservationDateList').val(data.reservationDate);
                // 인원수
                $('#personnelList').val(data.personnel);
                // 요구사항
                $('#requirementsList').val(data.requirements);
                // 방문여부
                $("#visitStatusList").val(data.visitStatus).prop("selected", true);
            }
        });
    });

    $(document).ready(function() {
        $('#btn_search').on("click", function(){

            location.href = "<c:url value='/today'/>?page=1&pageSize=${pageSize}&customerName="+$('#customerName').val().trim()+"&customerPhone="+$('#customerPhone').val().trim()+"&reservationDate="+$('#reservationDate').val().trim();

        })

        $("#writeBtn").on("click", function(){
            let form = $("#form");
            form.attr("action", "<c:url value='/write'/>");
            form.attr("method", "post");
            form.submit();
        });
        $("#modifyBtn").on("click", function(){
            let form = $("#form");
            form.attr("action", "<c:url value='/modify'/>");
            form.attr("method", "post");
            form.submit();
        });
        <%--$("#removeBtn").on("click", function(){--%>
        <%--    let form = $("#form");--%>
        <%--    form.attr("action", "<c:url value='/remove'/>");--%>
        <%--    form.attr("method", "post");--%>
        <%--    form.submit();--%>
        <%--});--%>
    });
</script>
</body>
</html>