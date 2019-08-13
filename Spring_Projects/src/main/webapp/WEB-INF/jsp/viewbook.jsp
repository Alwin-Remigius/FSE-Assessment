    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Book List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>bookId</th><th>title</th><th>price</th><th>publishDate</th><th>volume</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="book" items="${list}"> 
    <tr>
    <td>${book.bookId}</td>
    <td>${book.title}</td>
    <td>${book.price}</td>
    <td>${book.publishDate}</td>
    <td>${book.volume}</td>
    <td><a href="editbook/${book.bookId}">Edit</a></td>
    <td><a href="deletebook/${book.bookId}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="bookform">Add New Book</a>