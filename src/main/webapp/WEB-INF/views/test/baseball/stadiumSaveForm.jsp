<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
<br><br><br>
<form method="post" action="/stadium/save">
  <div class="form-group">
    <label for="text">야구장 이름</label>
    <input type="text" class="form-control" placeholder="야구장 이름" name="name">
  </div>
  <div class="form-group">
  </div>
  <div class="form-group form-check">
    
  </div>
  <button type="submit" class="btn btn-primary">추가</button>
</form>
</div>
</body>
</html>