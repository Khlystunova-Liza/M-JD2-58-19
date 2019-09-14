
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<form method="POST" action="${pageContext.request.contextPath}/add-product" enctype="multipart/form-data">
  <div class="form-group">
    <label for="exampleInputEmail1">Product name</label>
    <input type="text" name="itemName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter product name">
    <small id=  "emailHelp" class="form-text text-muted">Please describe product item</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Price</label>
    <input type="number" name="prise" class="form-control" id="exampleInputPassword1" placeholder="Product price">
  </div>
  <div class="form-group">
      <label for="exampleFormControlFile1">Example file input</label>
      <input type="file" name="file"  class="form-control-file" id="exampleFormControlFile1">
    </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>


<jsp:include page="footer.jsp"/>