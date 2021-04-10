<%@ include file="common/header.jspf"%>

<div class="container">

<div class="float-right"><a href="add" class="btn btn-primary">Add Category</a></div>
<table class="table">  
<tr><th>Id</th><th>Name</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="cat" items="${listCategories}">   
   <tr>  
   <td>${cat.id}</td>  
   <td>${cat.name}</td>  
  <td><a href="edit/${cat.id}">Edit</a></td>  
   <td><a href="delete/${cat.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  

</div>
<%@ include file="common/footer.jspf"%>