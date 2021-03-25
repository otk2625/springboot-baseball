<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>


<div class="container">
<br><br><br>
  <h2>선수 관리</h2>
           
  <table class="table">
    <thead>
      <tr>
        <th>NO</th>
        <th>선수이름</th>
        <th>포지션</th>
        <th>팀</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="player" items="${players}">
     <tr>
        <td>${player.id }</td>
        <td>${player.name }</td>
        <td>${player.position }</td>
        <td>${player.team.name }</td>
        <td><Button class="btn btn-danger" id="btn-delete" value="${player.id }">삭제</Button></td>
      </tr>
    </c:forEach>
     
      
    </tbody>
  </table>
</div>

<script>
	$("#btn-delete").on("click",(e)=>{
		let id = e.currentTarget.value;
		
		$.ajax({
			type: "DELETE",
			url: "/player/"+id,
			dataType: "json"
		}).done((res)=>{
			console.log(res);
			if(res === 200){
				alert("삭제에 성공하였습니다");
				history.go(0);
				
			}else {
				alert("삭제에 실패하였습니다");
			}
		});

	});
	
	
</script>

</body>
</html>