<%@ include file="common/header.jspf"%>
<div class="container">

<h4>Add Category</h4>
 <form:form method="post" action="save"  modelAttribute="category" >    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  class="form-control" required="true" /></td>  
         </tr> 
         <tr>    
          <td> </td>    
          <td><input type="submit" class="btn btn-primary" value="Save" /></td>    
         </tr>   
         </table>
</form:form> 


</div>
<%@ include file="common/footer.jspf"%>