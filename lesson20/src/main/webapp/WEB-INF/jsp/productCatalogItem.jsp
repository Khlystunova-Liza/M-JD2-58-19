

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="card" style="width: 18rem;">
    <img src="https://www.it-academy.by/local/images/logo.svg" class="card-img-top" alt="...">
    <div class="card-body">
        <h5 class="card-title">${item.itemName}</h5>
        <p class="card-text">${item.price} USD</p>
        <a href="#" class="btn btn-primary">Buy</a>
    </div>
</div>


<jsp:include page="footer.jsp"/>