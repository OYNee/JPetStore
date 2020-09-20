<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <jsp:include page="../home.jsp"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<title>후기 작성</title>
	<!-- Bootstrap CSS File -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>		
	<script>
	function writeChk() {
		if( $("#title").val() == "") {
			$("#title").attr("placeholder", "제목을 입력하세요!");
			$("title").focus();
			return ;
		} else if( $("#title").val().length > 50) {
			$("#title").val("");
			$("#title").attr("placeholder", "50글자를 넘을 수 없습니다!");
			$("#title").focus();
			return ;
		} else if( $("#userid").val() == "") {
			$("#userid").attr("placeholder", "작성자를 입력하세요!");
			$("#userid").focus();
			return ;
		} else if( $("#password").val() == "") {
			$("#password").attr("placeholder", "비밀번호를 입력하세요!");	
			$("#password").focus();
			return ;
		} else if( $("#content").val() == "") {
			$("#content").attr("placeholder", "내용을 입력하세요!");	
			$("#content").focus();
			return ;
		}
		return $("#form1").submit();
	}
	
	function fileChange() {
		if($("#battach")[0].files.length != 0) {
			var originalfilename = $("#battach")[0].files[0].name;
			$("#spanFileName").text(originalfilename);
		}
	}
	</script>
</head>
<body>
	<div style="max-width: 1000px; margin: auto;  margin-top: 50px">
	<h4>후기 등록</h4>
	<hr />
	<form method="post" action="postWrite.do" style="padding: 0px 20px" id="form1">
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> 
					<span class="glyphicon glyphicon-pencil"></span>
				</span> 
				<input type="text" class="form-control" placeholder="제목" name="title"  id="title" maxlength="30"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> 
					<span class="glyphicon glyphicon-user"></span>
				</span> 
				<input type="text" class="form-control" placeholder="작성자" name="userid" id="userid"  value="${loginid}"maxlength="8" readOnly/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> 
					<span class="glyphicon glyphicon-lock"></span>
				</span> 
				<input type="password" class="form-control" placeholder="비밀번호" name="password" id="password"  maxlength="10"/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> 
					<span class="glyphicon glyphicon-pencil"></span>
				</span>
				<p>
					<textArea rows="10" cols="30" class="form-control" placeholder="내용" name="content" id="content"></textArea>
				</p>
			</div>
		</div>
		<div class="form-group" style="height: 50px;">
			<div class="input-group">
				<span class="input-group-addon"> <span 	class="glyphicon glyphicon-picture"></span></span>
				<div class="form-control" style="height: 47px;">
					<span id="spanFileName"></span>
					<label for="image" class="btn btn-default">파일 선택</label>	 
					<input type="file"  style="visibility: hidden;" class="form-control" placeholder="선택" name="image" id="image" onchange="fileChange()" />
				</div>
			</div>
		</div>
		<div align="right">
		<a class="btn btn-success" href="postList.do" >취소</a>
		 <input type="hidden" class="form-control" name="sellerid" id="sellerid"  value="${sellerid}"/>
		<input type="button" class="btn btn-info" value="등록"  onclick="writeChk()"/>
		 <input type="hidden" class="form-control" name="loginid" id="loginid"  value="${loginid}"/>
		</div>
	</form>
	</div>
</body>
</html>