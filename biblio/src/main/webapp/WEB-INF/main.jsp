<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<title><spring:message code="application.title"></spring:message></title>
	<decorator:head></decorator:head>
	<%@ include file="/WEB-INF/view/includes/style.jsp"%>
	<%@ include file="/WEB-INF/view/includes/js.jsp"%>
</head>
<body>
	<div id="container">
		<%@ include file="/WEB-INF/view/includes/header.jsp"%>
		<div id="internalWrapper">
			<%@ include file="/WEB-INF/view/includes/links.jsp"%>
			<div id="content">
				<decorator:body></decorator:body>
			</div>
		</div>
		<%@ include file="/WEB-INF/view/includes/footer.jsp"%>
	</div>
</body>
</html>