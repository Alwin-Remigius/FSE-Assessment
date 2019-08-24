<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring Security hibernate integration example</title>
</head>
<body>
 
<h2>Library Management Screen</h2>
 <h6><a href="<c:url value='j_spring_security_logout'/>">Click here to logout</a></h6>
<form:form method="post" action="add" commandName="book">
 
    <table>
    <tr>
        <td><form:label path="bookId"><spring:message code="label.bookId"/></form:label></td>
        <td><form:input path="bookId" /></td>
    </tr>
    <tr>
        <td><form:label path="title"><spring:message code="label.title"/></form:label></td>
        <td><form:input path="title" /></td>
    </tr>
    <tr>
        <td><form:label path="price"><spring:message code="label.price"/></form:label></td>
        <td><form:input path="price" /></td>
    </tr>
    <tr>
        <td><form:label path="publishDate"><spring:message code="label.publishDate"/></form:label></td>
        <td><form:input path="publishDate" /></td>
    </tr>
    <tr>
        <td><form:label path="volume"><spring:message code="label.volume"/></form:label></td>
        <td><form:input path="volume" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.add"/>"/>
        </td>
    </tr>
</table> 
</form:form>
 
     
<h3>Books</h3>
<c:if  test="${!empty bookList}">
<table class="data">
<tr>
    <th>Book Id</th>
    <th>Title</th>
    <th>Price</th>
    <th>Book Id</th>
    <th>PublishDate</th>
    <th>Volume</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${bookList}" var="book">
    <tr>
        <td>${book.bookId} </td>
        <td>${book.title} </td>
        <td>${book.price} </td>
        <td>${book.publishDate} </td>
        <td>${book.volume} </td>
        
        <td><a href="delete/${book.bookId}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
 
</body>
</html>