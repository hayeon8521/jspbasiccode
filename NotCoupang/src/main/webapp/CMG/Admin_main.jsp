<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.Fyou.vo.OrderVO"%>
<%@page import="java.util.List"%>
<%@page import="com.Fyou.vo.MonthVO"%>
<%@page import="com.Fyou.vo.SellerCateVO"%>
<%
String LOGID = (String) session.getAttribute("LOGID");
String LOGNAME = (String) session.getAttribute("LOGNAME");
String MEMBERDIVISION = (String) session.getAttribute("MEMBERDIVISION");
List<OrderVO> img_list = (List<OrderVO>) request.getAttribute("img_list");
int total_sales = (int) request.getAttribute("total_sales");
MonthVO month_sales = (MonthVO) request.getAttribute("month_sales");
int now_month_sales = (int) request.getAttribute("now_month_sales");
List<SellerCateVO> seller_cate_list = (List<SellerCateVO>) request.getAttribute("seller_cate_list");
int state = (int) request.getAttribute("state");
int stop_end = (int) request.getAttribute("stop_end");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>!Coupang Admin</title>

    <!-- Custom fonts for this template-->
    <link href="CMG/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="CMG/css/sb-admin-2.min.css" rel="stylesheet">
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="Admin_main.do">
                <div class="sidebar-brand-icon rotate-n-15">
                </div>
                <div class="sidebar-brand-text mx-3">!Coupang</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="Admin_insert.do">
                    <span>상품 등록</span></a>
            </li>

            <li class="nav-item active">
                <a class="nav-link" href="Admin_list.do?page=1">
                    <span>등록 상품 조회</span></a>
            </li>


            <li class="nav-item active">
                <a class="nav-link" href="Admin_ask.do">
                    <span>문의 관리</span></a>
            </li>

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

                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=LOGID %></span>
                            </a>
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link" href="http://localhost/NotCoupang/logout.do">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Logout</span>
                            </a>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">요약 정보</h1>
                    </div>

                    <!-- Content Row -->
                    <div class="row">

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                총 매출</div>
                                                <%
                                                String total_str = " ";
                                                if (total_sales >= 100000000) {
                                                	total_str = total_str + (int)(total_sales / 100000000) + "억";
                                                	total_sales = total_sales % 100000000;
                                                }
                                                if (total_sales >= 10000) {
                                                	total_str = total_str + " " + (int)(total_sales / 10000) + "만";
                                                	total_sales = total_sales % 10000;
                                                }
                                                total_str = total_str + " " + total_sales + "원";
                                                %>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%=total_str %></div>
                                        </div>
                                        <div class="col-auto">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                이번달 매출</div>
                                            	<%
                                                String month_str = " ";
                                                if (now_month_sales >= 100000000) {
                                                	month_str = month_str + (int)(now_month_sales / 100000000) + "억";
                                                	now_month_sales = now_month_sales % 100000000;
                                                }
                                                if (now_month_sales >= 10000) {
                                                	month_str = month_str + " " + (int)(now_month_sales / 10000) + "만";
                                                	now_month_sales = now_month_sales % 10000;
                                                }
                                                month_str = month_str + " " + now_month_sales + "원";
                                                %>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%=month_str %></div>
                                        </div>
                                        <div class="col-auto">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div class="card-body">
                                	<div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                                판매중인 상품</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%=state %></div>
                                        </div>
                                        <div class="col-auto">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Pending Requests Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-warning shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                판매 중단 & 종료</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%=stop_end %></div>
                                        </div>
                                        <div class="col-auto">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Content Row -->

                    <div class="row">

                        <!-- Area Chart -->
                        <div class="col-xl-8 col-lg-7">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">1년 매출</h6>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-area">
                                        <canvas id="myAreaChart"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Pie Chart -->
                        <div class="col-xl-4 col-lg-5">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">수익 분포</h6>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-pie pt-4 pb-2">
                                        <canvas id="myPieChart"></canvas>
                                    </div>
                                    <div class="mt-4 text-center small">
                                        <span class="mr-2">
                                        </span>
                                        <span class="mr-2">
                                        </span>
                                        <span class="mr-2">
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->
    <script>
    chart_data = [<%=month_sales.getM01()%>, 
    			  <%=month_sales.getM02()%>, 
    			  <%=month_sales.getM03()%>, 
    			  <%=month_sales.getM04()%>, 
    			  <%=month_sales.getM05()%>, 
    			  <%=month_sales.getM06()%>, 
    			  <%=month_sales.getM07()%>, 
    			  <%=month_sales.getM08()%>, 
    			  <%=month_sales.getM09()%>, 
    			  <%=month_sales.getM10()%>, 
    			  <%=month_sales.getM11()%>, 
    			  <%=month_sales.getM12()%>]
    
    pie_labels = []
    pie_data = []
    <%
    for (int i = 0 ; i < seller_cate_list.size() ; i++) {
    %>
    pie_labels.push("<%=seller_cate_list.get(i).getGoodsCatename()%>")
    pie_data.push(<%=seller_cate_list.get(i).getTotal()%>)
    <%
    }
    %>
    </script>

    <!-- Bootstrap core JavaScript-->
    <script src="CMG/vendor/jquery/jquery.min.js"></script>
    <script src="CMG/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="CMG/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="CMG/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="CMG/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="CMG/js/demo/chart-area-demo.js"></script>
    <script src="CMG/js/demo/chart-pie-demo.js"></script>

</body>

</html>