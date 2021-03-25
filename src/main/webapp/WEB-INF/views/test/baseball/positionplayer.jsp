<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
<br><br><br>
  <h2>포지션 별 야구선수</h2>
       
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>포지션</th>
        <!-- 팀 -->
        <th>롯데</th>
        <th>NC</th>
        <th>기아</th>
        <th>해태</th>
         <!-- 팀 -->
      </tr>
    </thead>
    <tbody>

       <tr>
    	<c:forEach var="basement1" items="${basemant1s }">
    		<td>
    			${basement1}
    		</td>
    	
    	</c:forEach>
      </tr>
      
      <tr>
    	<c:forEach var="basement2" items="${basemant2s }">
    		<td>
    			${basement2}
    		</td>
    	
    	</c:forEach>
      </tr>

     
    </tbody>
  </table>
</div>

</body>
</html>