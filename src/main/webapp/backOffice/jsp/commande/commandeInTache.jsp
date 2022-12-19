  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
     <title>Les Commandes</title>
     <link href="backOffice/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
  </head>
 
   <body>
    <%@ include file="../aside.jsp" %>
      
          <div id="content">
              <div class="container-fluid">
                   <div class="card">
                      <div class="card-header">
                            Les Commandes
                      </div>
                      
                      <div class="card-body">
                          <table class="table table-striped">
                              <tr>
           <th>ID</th><th>Nom Client</th><th>Telephone de Client</th><th>Adresse de Client</th><th>Date Livraison</th><th>Date Commande</th><th>Prix Totale</th><th></th>  <th></th>                            </tr>
           
                              <c:forEach items="${model.commandes}" var="c">
                                <tr>
                                
                                
                                  <td>${c.id}</td>
                                  <td>${c.nomComplet }</td>
                                  <td>${c.numeroTelephone }</td>
                                  <td>${c.adresse }</td>
                                  <td>${c.dateLivraison }</td>
                                  <td>${c.dateCommande}</td>
                                  <td>${c.prixTotale}</td>
                                  <td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimerCommendeInTache.do?id=${c.id }"><button type="submit" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> </button></a></td>
                                  <td><a href="livrer.do?id=${c.id}"><button type="submit" class="btn btn-primary">confirmer la livraison</button></a></td>
                                  
                                </tr>
                              </c:forEach>
                           </table>
                      </div>
                  </div>
            </div>
            </div>
   
  </body>
</html>
