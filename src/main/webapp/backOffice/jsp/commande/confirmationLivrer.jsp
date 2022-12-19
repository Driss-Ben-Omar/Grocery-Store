<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
      <title>Confirmation</title>
      <link href="backOffice/bootstrap.min.css" rel="stylesheet" type="text/css" />
   </head>

 <body>
     <%@include file="../aside.jsp" %>

     
     
     
     <div id="content"> 
     <div class="container-fluid">
        <div class="card">
          
               <div class="card-header">
                    Confirmation commande
               </div>
               
          <div class="card-body">
               <div class="form-group">
               
                           <label class="control-label">Id :</label>
                           <input type="text" name="id" class="form-control" value="${commandeLivrer.id}"/>
                 
                      
                      
                           <label class="control-label">Id Client :</label>
                           <input type="text" name="idClient" class="form-control" value="${commandeLivrer.idClient}"/>
                  
                       
            
                            <label class="control-label">Date Livraison :</label>
                            <input type="text" name="dateLivraison" class="form-control" value="${commandeLivrer.dateLivraison}"/>
                      
                      
                
                            <label class="control-label">Date Commande :</label>
                            <input type="text" name="dateCommande" class="form-control" value="${commandeLivrer.dateCommande}"/>
                     
              
                            <label class="control-label">Prix Totale :</label>
                            <input type="text" name="PrixTotale" class="form-control" value="${commandeLivrer.prixTotale}"/>
                   
               </div>     
              </div>
          </div>
      </div>
   </div>
 </body>
</html>