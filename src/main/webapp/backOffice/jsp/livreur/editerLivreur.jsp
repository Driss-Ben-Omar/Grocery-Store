<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
     <title>editer Livreurs</title>
      <link href="backOffice/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
  </head>
 <body>
       <%@include file="../header.jsp" %>
       <p></p>
       <div class="container">
          <div class="card">
              <div class="card-header">
               Modification des levreurs
              </div>
              
              <div class="card-body">
                 <form action="updateLivreur.do" method="post">
                      <div hidden class="form-group">
                           <label class="control-label">CIN :</label>
                           <input type="text" name="cin" class="form-control" value="${livreur.cin}"/>
                      </div>
                      
                      <div class="form-group">
                           <label class="control-label">Nom Complet :</label>
                           <input type="text" name="nomComplet" class="form-control" value="${livreur.nomComplet}"/>
                       </div>
                       
                      <div class="form-group">
                            <label class="control-label">Date Naissance :</label>
                            <input type="text" name="dateNaissance" class="form-control" value="${livreur.dateNaissance}"/>
                      </div> 
                      
                       <div class="form-group">
                            <label class="control-label">Adresse :</label>
                            <input type="text" name="adresse" class="form-control" value="${livreur.adresse}"/>
                      </div> 
                      
                      <div class="form-group">
                            <label class="control-label">Numero Telephone :</label>
                            <input type="text" name="numeroTelephone" class="form-control" value="${livreur.numeroTelephone}"/>
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