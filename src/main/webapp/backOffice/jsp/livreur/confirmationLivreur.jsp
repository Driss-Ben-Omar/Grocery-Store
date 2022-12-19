<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
      <title>Confirmation</title>
      <link href="backOffice/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
   </head>

 <body>
     <%@ include file="../aside.jsp" %>
      
          <div id="content">
              <div class="container-fluid">
        <div class="card">
               <div class="card-header">
                    Confirmation Livreurs
               </div>
               
          <div class="card-body">
               <div class="form-group">
               
                           <label class="control-label">CIN :</label>
                           <input type="text" name="cin" class="form-control" value="${livreur.cin}"/>
                 
                      
                      
                           <label class="control-label">Nom Complet :</label>
                           <input type="text" name="nomComplet" class="form-control" value="${livreur.nomComplet}"/>
                  
                       
            
                            <label class="control-label">Date Naissance :</label>
                            <input type="text" name="dateNaissance" class="form-control" value="${livreur.dateNaissance}"/>
                      
                      
                
                            <label class="control-label">Adresse :</label>
                            <input type="text" name="adresse" class="form-control" value="${livreur.adresse}"/>
                     
              
                            <label class="control-label">Numero Telephone :</label>
                            <input type="text" name="numeroTelephone" class="form-control" value="${livreur.numeroTelephone}"/>
                   
                  </div>  
              </div>
          </div>
      </div>
   </div>
 </body>
</html>