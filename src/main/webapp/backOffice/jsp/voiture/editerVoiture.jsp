<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
     <title>editer Voiture</title>
      <link href="backOffice/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
  </head>
 <body>
       <%@include file="../header.jsp" %>
       <p></p>
       <div class="container">
          <div class="card">
              <div class="card-header">
               Modification des voitures
              </div>
              
              <div class="card-body">
                 <form action="updateVoiture.do" method="post">
                 
                 		<div hidden class="form-group">
                            <label class="control-label">matricule :</label>
                            <input type="text" name="matricule" class="form-control" value="${voiture.matricule}"/>
                      </div>
                      
                       
                      <div class="form-group">
                            <label class="control-label">marque :</label>
                            <input type="text" name="marque" class="form-control" value="${voiture.marque}"/>
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