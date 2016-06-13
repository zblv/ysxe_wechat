<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	String path = request.getContextPath();
	Integer serPort=request.getServerPort();
	String temp = serPort == 80 || serPort == 443 ? "" : ":"
			+ request.getServerPort();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + temp + path +"/";
%>
<c:set var="basePath" ><%=basePath %></c:set>