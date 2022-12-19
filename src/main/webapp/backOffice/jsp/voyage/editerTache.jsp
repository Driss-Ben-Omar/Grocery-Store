<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
     <title>editer Taches</title>
      <link href="backOffice/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
  </head>
 <body>
       <%@include file="../header.jsp" %>
       <p></p>
       <div class="container">
          <div class="card">
              <div class="card-header">
               Modification des Taches
              </div>
              
              <div class="card-body">
                 <form action="updateTache.do" method="post">
                      <div hidden class="form-group">
                           <label class="control-label">ID :</label>
                           <input type="text" name="id" class="form-control" value="${tache.id}"/>
                      </div>
                      
                       
                      <div class="form-group">
                            <label class="control-label">CIN :</label>
                            <input type="text" name="cin" class="form-control" value="${tache.cin}"/>
                      </div> 
                      
                       <div class="form-group">
                            <label class="control-label">Matricule :</label>
                            <input type="text" name="matricule" class="form-control" value="${tache.matricule}"/>
                      </div> 
                      
                      
                       <div>
                            <button type="submit" class="btn btn-primary">Modifier</button>
                       </div>
                </form>
             </div>
          </div>
      </div>
  </body>
</html>