<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    <meta charset="utf-8">
    <title>Datatable | Zircos - Responsive Bootstrap 4 Admin Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="Responsive bootstrap 4 admin template" name="description">
    <meta content="Coderthemes" name="author">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- App favicon -->
    <link rel="shortcut icon" href="/assets/images/favicon.ico">


    <c:if test="${param.page == 'index'}">
        <!-- Table datatable css -->
        <link href="/assets/libs/datatables/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
        <link href="/assets/libs/datatables/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css">
        <link href="/assets/libs/datatables/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css">
        <link href="/assets/libs/datatables/fixedHeader.bootstrap4.min.css" rel="stylesheet" type="text/css">
        <link href="/assets/libs/datatables/scroller.bootstrap4.min.css" rel="stylesheet" type="text/css">
        <link href="/assets/libs/datatables/dataTables.colVis.css" rel="stylesheet" type="text/css">
    </c:if>


    <!-- App css -->
    <link href="/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" id="bootstrap-stylesheet">
    <link href="/assets/css/icons.min.css" rel="stylesheet" type="text/css">
    <link href="/assets/css/app.min.css" rel="stylesheet" type="text/css" id="app-stylesheet">


<!-- jquery js -->
<script src="/assets/js/jquery-3.6.0.js"></script>