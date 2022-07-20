<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                            <h4 class="header-title"><b>Book List</b></h4>
                            <p class="sub-header">
                                Great selection of modern and classic books waiting to be discovered !!!
                                <code>$().DataTable();</code>.
                            </p>
                            <div class="text-lg-right" style="margin-bottom: 15px">
                                <a href="book?action=create"
                                   class="btn btn-success waves-effect waves-light">CREATE NEW BOOK</a>
                            </div>

                            <table id="datatable" class="table table-striped table-bordered dt-responsive nowrap"
                                   style="border-collapse: collapse; border-spacing: 0; width: 100%;">
                                <thead>
                                <tr>
                                    <%--<th>BookId</th>--%>
                                    <th>Isbn</th>
                                    <th>Title</th>
                                    <th>Author</th>
                                    <th>Subject</th>
                                    <th>Language</th>
                                    <th>Publisher</th>
                                    <th>Created At</th>
                                    <th>Action</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach var="book" items="${requestScope.listBook}">
                                <tr>
                                    <c:if test="${book != null}">
                                    <input type="hidden" name="id" value="<c:out value='${book.getId()}' />"/>
                                    </c:if>
                                        <%--<td style="display:none;"><c:out value="${book.getId()}"/></td>--%>
                                    <td><c:out value="${book.getIsbn()}"/></td>
                                    <td><c:out value="${book.getTitle()}"/></td>
                                    <td><c:out value="${book.getAuthor()}"/></td>
                                    <td><c:out value="${book.getSubject()}"/></td>

                                    <td>
                                        <c:forEach items="${applicationScope.listLanguage }" var="language">
                                            <c:if test="${language.getId() == book.getLanguage()}">
                                                <c:out value="${language.getLanguage()}"/>
                                            </c:if>
                                        </c:forEach>

                                    </td>
                                    <td>
                                        <c:forEach items="${applicationScope.listPublisher }" var="publisher">
                                            <c:if test="${publisher.getId() == book.getPublisher()}">
                                                <c:out value="${publisher.getPublisher()}"/>
                                            </c:if>
                                        </c:forEach>

                                    </td>
                                    <td><fmt:formatDate value="${book.getCreatedAt()}" pattern="yyyy-MM-dd HH:mm"/></td>
                                    <td>
                                        <a class="btn btn-icon waves-effect waves-light btn-warning"
                                           href="/book?action=edit&id=${book.getId()}">
                                            <i class="fas fa-wrench"></i>
                                        </a>
                                        <a class="btn btn-icon waves-effect waves-light btn-danger"
                                           href="/book?action=delete&id=${book.getId()}">
                                            <i class="fas fa-trash"></i>
                                        </a>
                                    </td>

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

        <jsp:include page="/WEB-INF/admin/layout/footer.jsp"></jsp:include>

        <!-- end Footer -->

    </div>


</div>

<!-- Vendor js -->
<jsp:include page="/WEB-INF/admin/layout/script.jsp">
    <jsp:param name="page" value="index"/>
</jsp:include>


</body>

</html>