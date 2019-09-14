<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="alert alert-danger" role="alert">
  Add product error!
</div>

<a class="btn btn-primary" href="${pageContext.request.contextPath}/add-product" role="button">Back</a>

<jsp:include page="footer.jsp"/>