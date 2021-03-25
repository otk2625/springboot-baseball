<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>


<div class="container">
<br><br><br>
  <h2>팀 관리</h2>
           
  <table class="table">
    <thead>
      <tr>
        <th>NO</th>
        <th>팀</th>
        <th>구장</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
     <c:forEach var="team" items="${teams}">
     <tr>
        <td>${team.id }</td>
        <td>${team.name }</td>
        <td>${team.baseballStadium.name }</td>
        <td><Button class="btn btn-danger" id="btn-delete" value="${team.id }">삭제</Button></td>
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
			url: "/team/"+id,
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