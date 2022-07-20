
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>


    <jsp:include page="/WEB-INF/admin/layout/csslink.jsp">
        <jsp:param name="page" value="index"/>
    </jsp:include>
</head>

<body data-layout="horizontal">

<!-- Begin page -->
<div id="wrapper">

    <!-- Navigation Bar-->
    <jsp:include page="/WEB-INF/admin/layout/header.jsp"></jsp:include>

    <!-- End Navigation Bar-->

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">

                <!-- start page title -->
                <div class="row">
                    <div class="col-12">
                        <div class="page-title-box">
                            <div class="page-title-right">
                                <ol class="breadcrumb m-0">
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Librus</a></li>
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Tables</a></li>
                                    <li class="breadcrumb-item active">Datatable</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Datatable</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

                <div class="row">
                    <div class="col-sm-12">
                        <div class="card-box table-responsive">
                            <h4 class="header-title"><b>Publisher</b></h4>
                            <p class="sub-header">
                                <code>$().DataTable();</code>.
                            </p>

                            <table id="datatable" class="table table-striped table-bordered dt-responsive nowrap" style="border-collapse: collapse; border-spacing: 0; width: 100%;">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Publisher</th>

                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach var="publisher" items="${requestScope.listPublisher}">
                                <tr>
                                    <td><c:out value="${publisher.getId()}"/></td>
                                    <td><c:out value="${publisher.getPublisher()}"/></td>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <!-- end row -->

            </div>
            <!-- end container-fluid -->

        </div>
        <!-- end content -->



        <!-- Footer Start -->

        <jsp:include page="/WEB-INF/admin/layout/footer.jsp"> </jsp:include>

        <!-- end Footer -->

    </div>


</div>

<!-- Vendor js -->
<jsp:include page="/WEB-INF/admin/layout/script.jsp">
    <jsp:param name="page" value="index"/>
</jsp:include>


</body>

</html>

