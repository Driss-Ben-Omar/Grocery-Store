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
                    Confirmation Ajout Produit
               </div>
               
          <div class="card-body">
               <div class="form-group">
               
                    <label class="control-label">ID :</label>
                    <input type="text" name="Nom" class="form-control" value="${produit.idProduit }"/>

                    <label class="control-label">Nom Produit :</label>
                    <input type="text" name="Nom" class="form-control" value="${produit.nomProduit }"/>
                         

                    <label class="control-label">Prix :</label>
                    <input type="text" name="Prix" class="form-control" value="${produit.prix }"/>
                    
                    <label class="control-label">Prix d'achat :</label>
                    <input type="text" name="PrixAchat" class="form-control" value="${produit.prixAchat }"/>
                    
                    <label class="control-label">Quantite :</label>
                    <input type="text" name="Quantite" class="form-control" value="${produit.quantite }"/>
                    
                    <label class="control-label">Quantite vendue :</label>
                    <input type="text" name="Quantite" class="form-control" value="${produit.getQuantiteVendue() }"/>
                    
                    <label class="control-label">Remise :</label>
                    <input type="text" name="remis" class="form-control" value="${produit.remise }"/>
                    
                    
                  </div>  
              </div>
          </div>
      </div>
   </div>
 </body>
</html>