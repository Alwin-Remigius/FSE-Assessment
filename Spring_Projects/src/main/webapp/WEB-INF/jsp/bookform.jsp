<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Book</h1>
       <form:form method="post" action="save">  
      	<table >  
         <tr>  
          <td>BookId : </td> 
          <td><form:input path="bookId"  /></td>
         </tr>  
         <tr>  
          <td>Title :</td>  
          <td><form:input path="title" /></td>
         </tr> 
         <tr>  
          <td>Price :</td>  
          <td><form:input path="price" /></td>
         </tr> 
         <tr>  
          <td>PublishDate :</td>  
          <td><form:input path="publishDate" /></td>
         </tr>
         <tr>  
          <td>Volume :</td>  
          <td><form:input path="volume" /></td>
         </tr>
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
