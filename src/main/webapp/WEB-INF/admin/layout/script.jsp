<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Vendor js -->
<script src="/assets/js/vendor.min.js"></script>

<c:if test="${param.page == 'index'}">
    <!-- Datatable plugin js -->
    <script src="/assets/libs/datatables/jquery.dataTables.min.js"></script>
    <script src="/assets/libs/datatables/dataTables.bootstrap4.min.js"></script>

    <script src="/assets/libs/datatables/dataTables.responsive.min.js"></script>
    <script src="/assets/libs/datatables/responsive.bootstrap4.min.js"></script>

    <script src="/assets/libs/datatables/dataTables.buttons.min.js"></script>
    <script src="/assets/libs/datatables/buttons.bootstrap4.min.js"></script>

    <script src="/assets/libs/datatables/buttons.html5.min.js"></script>
    <script src="/assets/libs/datatables/buttons.print.min.js"></script>

    <script src="/assets/libs/datatables/dataTables.keyTable.min.js"></script>
    <script src="/assets/libs/datatables/dataTables.fixedHeader.min.js"></script>
    <script src="/assets/libs/datatables/dataTables.scroller.min.js"></script>

    <script src="/assets/libs/jszip/jszip.min.js"></script>
    <script src="/assets/libs/pdfmake/pdfmake.min.js"></script>
    <script src="/assets/libs/pdfmake/vfs_fonts.js"></script>

    <!-- Datatables init -->
    <script src="/assets/js/pages/datatables.init.js"></script>
</c:if>
<script src="/assets\libs\toastr\toastr.min.js"></script>
<script src="/assets\js\pages\toastr.init.js"></script>
<!-- App js -->
<script src="/assets/js/app.min.js"></script>



