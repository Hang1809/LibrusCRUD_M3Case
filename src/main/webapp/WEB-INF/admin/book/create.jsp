<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/WEB-INF/admin/layout/csslink.jsp">
        <jsp:param name="page" value=""/>
    </jsp:include>

    <link href="/assets\libs\toastr\toastr.min.css" rel="stylesheet" type="text/css">
</head>

<body data-layout="horizontal">

<!-- Begin page -->
<div id="wrapper">

    <!-- Navigation Bar-->
    <jsp:include page="/WEB-INF/admin/layout/header.jsp"></jsp:include>
    <!-- End Navigation Bar-->


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
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Forms</a></li>
                                    <li class="breadcrumb-item active">Form elements</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Add new book</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

                <div class="row">
                    <div class="col-sm-12">
                        <div class="card-box">

                            <div class="row">
                                <div class="col-lg-12">
                                    <form class="form-horizontal" method="post">
                                        <div class="form-group row">
                                            <label class="col-md-2 control-label">ISBN</label>
                                            <div class="col-md-10">
                                                <input type="text"
                                                       id="isbn" name="isbn" value="${book.getIsbn()}"
                                                       class="form-control"
                                                       placeholder="ISBN must have 10 numbers and follow this format ex: 0-596-52068-9">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-md-2 control-label">Title</label>
                                            <div class="col-md-10">
                                                <input type="text" id="name" name="title" value="${book.getTitle()}"
                                                       class="form-control" placeholder="Title of book">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-md-2 control-label">Author</label>
                                            <div class="col-md-10">
                                                <input type="text"
                                                       id="author" name="author" value="${book.getAuthor()}"
                                                       class="form-control" placeholder="name of author">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-md-2 control-label">Subject</label>
                                            <div class="col-md-10">
                                                <input type="text" class="form-control" name="subject" id="subject"
                                                       value="${book.getSubject()}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-md-2 control-label">Language</label>
                                            <div class="col-md-10">
                                                <SELECT name="idLanguage">
                                                    <c:forEach items="${applicationScope.listLanguage }" var="language">
                                                        <option value="${language.getId()}">
                                                            <c:out value="${language.getLanguage()}"></c:out>
                                                        </option>
                                                    </c:forEach>
                                                </SELECT>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-md-2 control-label">Publisher</label>
                                            <div class="col-md-10">
                                                <SELECT name="idPublisher">
                                                    <c:forEach items="${applicationScope.listPublisher }"
                                                               var="publisher">
                                                        <option value="${publisher.getId()}">
                                                            <c:out value="${publisher.getPublisher()}"></c:out>
                                                        </option>
                                                    </c:forEach>
                                                </SELECT>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-md-2 control-label">Created At</label>
                                            <div class="col-md-10">
                                                <input type="date" class="form-control"
                                                       fmt:formatDate value="${book.getCreatedAt()}" pattern="yyyy-MM-dd HH:mm" />
                                            </div>
                                        </div>
                                        <div class="text-center">
                                            <button type="submit" class="btn btn-success waves-effect waves-light">
                                                Create
                                            </button>
                                            <a class="btn btn-icon waves-effect waves-light btn-success"
                                               href="/book?action=listbook">Book List
                                                <i class="fas fa-list-ol"></i>
                                            </a>
                                        </div>
                                    </form>
                                </div>


                            </div>
                            <div>

                                <c:if test="${requestScope.errors != null}">
                                    <script>
                                        var myVariable = '<%=request.getAttribute("errors")%>'
                                        $( document ).ready(function() {
                                                toastr["error"](myVariable)

                                                toastr.options = {
                                                "closeButton": true,
                                                "debug": false,
                                                "newestOnTop": false,
                                                "progressBar": false,
                                                "positionClass": "toast-top-right",
                                                "preventDuplicates": false,
                                                "onclick": null,
                                                "showDuration": "300",
                                                "hideDuration": "1000",
                                                "timeOut": "5000",
                                                "extendedTimeOut": "1000",
                                                "showEasing": "swing",
                                                "hideEasing": "linear",
                                                "showMethod": "fadeIn",
                                                "hideMethod": "fadeOut"
                                            }
                                        });

                                    </script>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end row -->

            </div>
            <!-- end container-fluid -->

        </div>

        <!-- end content -->



        <!-- Footer Start -->

        <jsp:include page="/WEB-INF/admin/layout/footer.jsp"></jsp:include>


        <!-- end Footer -->

    </div>

    <!-- ============================================================== -->
    <!-- End Page content -->
    <!-- ============================================================== -->

</div>
<!-- END wrapper -->


<jsp:include page="/WEB-INF/admin/layout/script.jsp">
    <jsp:param name="page" value=""/>
</jsp:include>

</body>

</html>