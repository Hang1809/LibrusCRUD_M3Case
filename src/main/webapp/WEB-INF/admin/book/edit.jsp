<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/WEB-INF/admin/layout/csslink.jsp">
        <jsp:param name="page" value=""/>
    </jsp:include>

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
                            <h4 class="page-title">Edit book</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

                <c:if test="${book != null}">
                    <input type="hidden" name="id" value="<c:out value='${book.getId()}' />"/>
                </c:if>

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
                                                       id="isbn" name="isbn"
                                                       value="<c:out value='${book.getIsbn()}' />"
                                                       class="form-control"
                                                       placeholder="ISBN must have 10 numbers and follow this format ex: 0-596-52068-9">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-md-2 control-label">Title</label>
                                            <div class="col-md-10">
                                                <input type="text" id="name" name="name"
                                                       value="<c:out value='${book.getTitle()}' />"
                                                       class="form-control" placeholder="Title of book">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-md-2 control-label">Author</label>
                                            <div class="col-md-10">
                                                <input type="text"
                                                       id="author" name="author"
                                                       value="<c:out value='${book.getAuthor()}' />"
                                                       class="form-control" placeholder="name of author">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-md-2 control-label">Subject</label>
                                            <div class="col-md-10">
                                                <input type="text" class="form-control" name="subject" id="subject"
                                                       value="<c:out value='${book.getSubject()}' />">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-md-2 control-label">Language</label>
                                            <div class="col-md-10">
                                                <SELECT name="idLanguage">
                                                    <c:forEach items="${applicationScope.listLanguage }" var="language">
                                                        <c:choose>
                                                            <c:when test="${language.getId() == book.getLanguage()}">
                                                                <option value="${language.getId()}"
                                                                        selected>${language.getLanguage()}</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="${language.getId()}">${language.getLanguage()}</option>
                                                            </c:otherwise>
                                                        </c:choose>
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
                                                        <c:choose>
                                                            <c:when test="${publisher.getId() == book.getPublisher()}">
                                                                <option value="${publisher.getId()}"
                                                                        selected>${publisher.getPublisher()}</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="${publisher.getId()}">${publisher.getPublisher()}</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                </SELECT>

                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-md-2 control-label">Created At</label>
                                            <div class="col-md-10">
                                                <input type="date" class="form-control"
                                                       fmt:formatDate value="${book.getCreatedAt()}"
                                                       pattern="yyyy-MM-dd HH:mm"/>
                                            </div>
                                        </div>

                                        <div class="text-center">
                                            <button type="submit" class="btn btn-success waves-effect waves-light">
                                                SAVE
                                            </button>
                                            <a class="btn btn-icon waves-effect waves-light btn-success"
                                               href="/book?action=listbook">Book List
                                                <i class="fas fa-list-ol"></i>
                                            </a>
                                        </div>
                                    </form>
                                </div>


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


</div>


<jsp:include page="/WEB-INF/admin/layout/script.jsp">
    <jsp:param name="page" value=""/>
</jsp:include>

</body>

</html>