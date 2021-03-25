<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>


<div class="container">
<br><br><br>
<form action="/player/save" method="post">
  <div class="form-group">
    <label for="text">이름</label>
    <input type="text" class="form-control" placeholder="이름" name="name">
  </div>
  <div class="form-group">
  <label for="text">포지션</label>
    <input type="text" class="form-control" placeholder="포지션" name="position">
  </div>
  <div class="form-group">
  <label for="text">팀 이름</label>
    <input type="text" class="form-control" placeholder="팀 이름" name="team">
  </div>
  <div class="form-group form-check">
    
  </div>
  <button type="submit" class="btn btn-primary">추가</button>
</form>
</div>
</body>
</html>