<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <jsp:include page="../home.jsp" flush="true"/> --%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, user-scalable=no">
	<title>후기상세</title>
	<!-- Bootstrap CSS File -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>		
	<script>
		function handleBtnUpdate() {
			var bpassword = $("#bpassword").val();
			if( bpassword =="") {
				$("#bpassword").attr("placeholder", "비밀번호를 입력하셔야 합니다.");
				$("#bpassword").focus();
				return ;
			}
			$.ajax({
				url: "boardCheckBpassword",
				method: "post",
				data: {"bno":"${board.bno}", "bpassword":bpassword},
				success: function(data) {
					if(data.result =="success") {
						location.href="boardUpdate?bno=${board.bno}&pageNo=${pageNo}&mid=${member.mid}";
					} else {
						$("#bpassword").val("");
						$("#bpassword").attr("placeholder", "비밀번호를 입력하셔야 합니다.");
						$("#bpassword").focus();
					}
				}
			});
		}
		function handleBtnDelete() {
			var bpassword = $("#bpassword").val();
			if( bpassword =="") {
				$("#bpassword").attr("placeholder", "비밀번호를 입력하셔야 합니다.");
				$("#bpassword").focus();
				return ;
			}
			$.ajax({	
				url: "boardCheckBpassword",
				method: "post",
				data: {"bno":"${board.bno}", "bpassword":bpassword},
				success: function(data) {
					if(data.result =="success") {
						console.log("success");
						check = confirm("삭제하시겠습니까?");
						if (check) { 
							location.href="boardDelete?bno=${board.bno}";
						 }
					} else {
						$("#bpassword").val("");
						$("#bpassword").attr("placeholder", "비밀번호를 입력하셔야 합니다.");
						$("#bpassword").focus();
					}
				}
			});
		}
		function handleBtnDeleteAdmin() {			
			check = confirm("삭제하시겠습니까?");
			if (check) { 
				location.href="boardDelete?bno=${board.bno}";
			 }
		}
		function handleBtnLike() {
			console.log($("#mid").val());
			if($("#mid").val()==""){		
				alert("로그인 후 이용 가능합니다");
				$("#list").focus();
				return;
			}
			location.href="boardLike?bno=${board.bno}&pageNo=${pageNo}&mid=${member.mid}";		
		}
		
		function handleBtnComment(){
			if( $("#bcpassword").val() == "") {
				$("#bcpassword").attr("placeholder", "비밀번호");
				$("#bcpassword").focus();
				return ;
			} else if( $("#bccomment").val() == "") {
				$("#bccomment").val("");
				$("#bccomment").attr("placeholder", "내용을 입력하세요!");
				$("#bccomment").focus();
				return ;
			} 
			return $("#form1").submit();
		}
		
		function handleLoginCheck() {
			if($("#mid").val()==""){
				alert("로그인 후 이용하세요~");		
				$("#list").focus();
				return ;
			} 
		}
	</script>
</head>
<body>
	<div style="max-width: 1000px; margin: auto; margin-top: 50px">	
	<h4><a href="boardList?pageNo=${pageNo}" class="btn btn-default"  id="list">목록</a> ${board.btitle}</h4>
	<c:if test="${member.mlevel == 5}">
		<div class="form-group" align="right">
			<input type="button" class="btn btn-warning btn-sm" value="게시글 삭제(관리자)"    onclick="handleBtnDeleteAdmin()"/>	
		</div>	
	</c:if>
	<hr />
	<form method="post"  id="form1" action="boardCommentWrite" style="padding: 0px 20px"
		enctype="multipart/form-data">
		
		<button type="button" class="btn btn-default" name="bno" disabled="disabled" style="width: 100px; height: 33px;">${post.postid}</button>
		<button type="button" class="btn btn-default" disabled="disabled" style="width:40px; background-color: #CEF6EC"><span class="glyphicon glyphicon-user" style="color: #FAAC58"></span></button>
		<button type="button" class="btn btn-default" name="bwriter"  disabled="disabled" style="width: 250px; height: 33px;">${post.userid}</button>
		<button type="button" class="btn btn-default" disabled="disabled" style="width:40px; background-color: #CEF6EC"><span class="glyphicon glyphicon-heart" style="color: #FAAC58"></span></button>
		<button type="button" class="btn btn-default" name="blikecount"  disabled="disabled" style="width: 100px; height: 33px;">${post.like_count}</button>
		<button type="button" class="btn btn-default" disabled="disabled" style="width:40px; background-color: #CEF6EC"><span class="glyphicon glyphicon-eye-open" style="color: #FAAC58"></span></button>
		<button type="button" class="btn btn-default" name="bhitcount"  disabled="disabled" style="width: 100px; height: 33px;">${post.view_count}</button>
		<button type="button" class="btn btn-default" disabled="disabled" style="width:40px; background-color: #CEF6EC"><span class="glyphicon glyphicon-time" style="color: #FAAC58"></span></button>
		<fmt:formatDate var="bdate" value="${post.date_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
		<button type="button" class="btn btn-default" name="bdate"  disabled="disabled" style="width: 210px; height: 33px;">${bdate}</button>
		&nbsp;<br/>&nbsp;
		<!-- <hr/> -->
		<div class="form-group" style="text-align: center;">
			<c:if test='${post.image != null}'>
				<img src="postImage?postid=${post.postid}" style="max-width: 980px;"/>
			</c:if>
		</div>
		<div class="form-group" style="text-align: center;">			
			<p class="text-justify" >${post.content}</p>
		</div>
		
		<!-- Like Count -->
		<div class="form-group" style="text-align: center;">
			<div class="btn btn-danger" style="border-radius: 50px; width: 100px; height: 100px; line-height: 30px; " onclick="handleBtnLike()">
				${post.like_count}<br/>
				<span class="glyphicon glyphicon-heart" aria-hidden="true"  style="color: yellow; font-size: 45px"></span>
			</div>			
		</div>
		<hr/>
		<div class="form-group" align="right">
			<c:if test="${loginid == post.userid}" >
				<input type="password" id="bpassword" placeholder="비밀번호"	name="bpassword"  style="width: 150px; height: 33px;"  maxlength="10"/>
				<input type="button" class="btn btn-info" value="수정"  onclick="handleBtnUpdate()" />
				<input type="button" class="btn btn-danger" value="삭제"    onclick="handleBtnDelete()"/>	
			</c:if>		
			<a href="boardList?pageNo=${pageNo}" class="btn btn-primary"  id="list">목록</a>
		</div>		
		<hr/>

		<c:if test="${loginid != null}" >		
		<div class="form-group" align="right">
			<input type="password" id="bcpassword" placeholder="비밀번호"	name="bcpassword"  style="width: 150px; height: 33px;"  maxlength="10"/>
			<input type="button" class="btn btn-success" value="등록"  onclick="handleBtnComment()" />		
		</div>
		</c:if>
	</form>
	</div>
</body>
</html>