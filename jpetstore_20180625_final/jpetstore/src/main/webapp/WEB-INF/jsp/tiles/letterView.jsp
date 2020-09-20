<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="kr">
<head>
<meta charset="UTF-8">
<title>쪽지함</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Google Fonts -->
<link
   href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700|Open+Sans:300,300i,400,400i,700,700i"
   rel="stylesheet">

<!-- Bootstrap CSS File -->
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
.col1 {
   float: left;
   width: 200px;
}

.col2 {
   float: left;
   width: 200px;
}

.clearfix:after {
   content: " ";
   visibility: hidden;
   display: block;
   height: 0;
   clear: both;
}c
</style>
<script type="text/javascript">
   $(document).ready(function() {
      searchajax();
      addInput();
   });
   function searchajax() {
      $("#searchword")
            .keyup(
                  function() {
                     var words = $("#searchword").val();
                     if (words != '') {
                        $
                              .ajax({
                                 type : 'POST',
                                 url : '/jpetstore/shop/searchAjax.do',
                                 data : {
                                    searchword : words
                                 },
                                 dataType : 'json',
                                 success : function(result) {
                                    if (result.accountList.length > 0) {
                                       var str = ''
                                       for (var i = 0; i < result.accountList.length; i++) {
                                          str += '<a href="#" class="list-group-item selected">'
                                                + result.accountList[i].user_id
                                                + '</a>';
                                       }
                                       $("#results").html(str);
                                    } else {
                                       $("#results").html("");
                                    }
                                 },
                                 error:function(e){
                                    console
                                    .log('error:'
                                          + e.status);
                                     }

                              });
                     } else {
                        $("#results").html("");
                     }
                  });
   }
   function addInput() {
      $(document)
            .on(
                  "click",
                  ".selected",
                  function() {
                     console.log($(this).text());
                     var input = '';
                     input += '<a href="#" class="list-inline-item" style="padding-right : 5px;">'
                           + $(this).text() + '</a>';
                     $("#receiver").append(input);
                     var inputHidden='';
                     inputHidden+='<input type="hidden" name="inputHidden" id="inputHidden" value='+ $(this).text()+'>'
                     $("#receiver").append(inputHidden);
                  });
   }
</script>
</head>
<body>
   <section id="contact">
      <div class="container">
         <div class="row wow fadeInUp">
            <div class="col-lg-12 col-md-8">
               <div class="form">
                  <h4 style="text-align: left;">쪽지함</h4>
                  <hr />
                  <div style="float: right;">
                     <form action="${pageContext.request.contextPath}/shop/letterView.do">
                        <button type="submit" class="btn btn-info">쪽지 전체보기</button>
                     </form>
                  </div>
                  <div style="float: right;">
                     <form
                        action="${pageContext.request.contextPath}/shop/searchLetter.do">
                        <input id="searchLetter" name="searchLetter" type="text"
                           placeholder="쪽지 검색 ex)안녕하세요">
                        <button type="submit" class="btn btn-default">
                           <span class="glyphicon glyphicon-search"></span>
                        </button>
                     </form>
                  </div>
                  <br> <br>

                  <!--칸 한개 -->
                  <c:forEach var="item" items="${list}" varStatus="vs">
                     <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="border-style: solid; border-width: 2px; margin-top: 10px; padding-left: 0px">
                        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3" style="float: left; padding-left: 0px; text-align: center">
                              <c:if test="${item.sender ==loginedAccount.user_id}">
                                 <span class="glyphicon glyphicon-arrow-right"  style="font-size: 4em; color: blue;"></span>
                              </c:if>
                              <c:if test="${item.receiver == loginedAccount.user_id}">
                                 <span class="glyphicon glyphicon-arrow-left" style="font-size: 4em; color: blue;"></span>
                              </c:if>
                           <h4>FROM&nbsp;&nbsp;&nbsp;&nbsp; ${item.sender}</h4>
                           <h4>TO&nbsp;&nbsp;${item.receiver}</h4>
                        </div>
                        <!--내용 부분  -->
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9" style="float: left; margin-top: 1%">
                           <div class="row">
                              <div class="col-lg-2 col-md-2 col-sm-2 col-xs-4">${item.title}</div>
                              <div class="col-lg-8 col-md-8 col-sm-8 col-xs-4">${item.content}</div>
                              <div class="col-lg-2 col-md-2 col-sm-2 col-xs-4" >${item.datetime}</div>
                           </div>
                        </div>
                     </div>
                  </c:forEach>
                  <div class="clearfix"></div>
                  <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2" style="padding-top: 10px;float: right;">
                     <button id="approve" value="쪽지쓰기" class="btn btn-info btn-lg"
                        data-toggle="modal" data-target="#myModal"
                        style="position: absolute; top: 40%;">쪽지쓰기</button>
                  </div>
                  <div  class="input-group"  style="margin-top: 20px; text-align:center; width: 100%">
                     <a href="/shop/letterView.do?pageNo=1">◀</a>&nbsp;
                     <c:if test="${groupNo>1}">
                        <a href="/shop/letterView.do?pageNo=${startPageNo-1}">◁</a>&nbsp;
                     </c:if>
                     <c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">         
                        &nbsp;
                        <a href="/shop/letterView.do?pageNo=${i}"
                           <c:if test="${pageNo==i}">style="font-weight: bold; color: red"</c:if>>${i}</a>
                        &nbsp;
                     </c:forEach>
            
                     <c:if test="${groupNo<totalGroupNo}">
                        <a href="/shop/letterView.do?pageNo=${endPageNo+1}">▷</a>&nbsp;
                     </c:if>
                     <a href="/shop/letterView.do?pageNo=${totalPageNo}">▶</a>
                  </div>                     
                  <!--모달  -->
                  <div class="modal fade" id="myModal" role="dialog">
                     <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                           <div class="modal-body">
                              <div class="col-lg-12 col-md-8">
                                 <div class="form">
                                    <form action="${pageContext.request.contextPath}/shop/writeLetter.do"
                                       method="post">
                                       <div class="col-lg-12">
                                          <div class="row">
                                             <label for="searchword" style="display: block;">받는사람</label>
                                             <input type="text" name="searchword" id="searchword"
                                                style="display: inline-block;" />
                                             <div id="results" class="list-group"></div>
                                             <div id="receiver" class="list-inline"></div>

                                          </div>
                                          <div class="clearfix"></div>
                                          <div class="row">
                                             <label for="title" style="display: block;">제목</label>
                                             <input type="text" name="title" id="title"
                                                style="display: inline-block;" />
                                          </div>
                                          <div class="row">
                                             <label for="content" style="display: block;">내용</label>
                                             <textarea class="form-control" name="content" id="content">
                                                </textarea>
                                          </div>
                                       </div>
                                       <div class="clearfix"></div>
                                       <div class="text-center" style="padding-top: 40px">
                                          <button id="clickApprove" type="submit"
                                             title="Send Message">쪽지쓰기</button>
                                       </div>
                                    </form>
                                 </div>
                              </div>
                           </div>
                           <div class="clearfix"></div>
                           <div class="modal-footer">
                              <button type="button" class="btn btn-default"
                                 data-dismiss="modal">Close</button>
                           </div>
                        </div>
                     </div>
                  </div>

               </div>
            </div>
         </div>
      </div>
   </section>
</body>
</html>