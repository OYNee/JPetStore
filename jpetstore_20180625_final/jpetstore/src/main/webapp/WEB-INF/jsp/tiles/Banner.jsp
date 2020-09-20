<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br>
<c:if test="${userSession.account.bannerOption}">
  <table class="top">
    <tr>
      <td align="center"><c:out value="${userSession.account.bannerName}" escapeXml="false" /> &nbsp;</td>
    </tr><!-- 배너 테이블에 bannername 안에 들어간 값이 아래에 뜬다. 좋아하는 동물을 설정해놓으면 그 동물의 사진이 뜨게 하면 좋을듯! -->
  </table>
</c:if>

