<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
      <title>Confirmation Tache</title>
      <link href="backOffice/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
   </head>

 <body>
     <%@ include file="../aside.jsp" %>
      
          <div id="content">
              <div class="container-fluid">
        <div class="card">
               <div class="card-header">
                    Confirmation Ajout Tache
               </div>
               
          <div class="card-body">
               <div class="form-group">
               
                    <label class="control-label">ID :</label>
                    <input type="text" name="id" class="form-control" value="${tache.id }"/>

 
                         

                    <label class="control-label">CIN :</label>
                    <input type="text" name="cin" class="form-control" value="${tache.cin }"/>
                    
                    <label class="control-label">Prix d'achat :</label>
                    <input type="text" name="matricule" class="form-control" value="${tache.matricule }"/>
             </div>
              </div>
          </div>
      </div>
   </div>
 </body>
</html>