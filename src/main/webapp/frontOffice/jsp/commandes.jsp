<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <title>Commandes</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="frontOffice/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="frontOffice/css/animate.css">
    
    <link rel="stylesheet" href="frontOffice/css/owl.carousel.min.css">
    <link rel="stylesheet" href="frontOffice/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="frontOffice/css/magnific-popup.css">

    <link rel="stylesheet" href="frontOffice/css/aos.css">

    <link rel="stylesheet" href="frontOffice/css/ionicons.min.css">

    <link rel="stylesheet" href="frontOffice/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="frontOffice/css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="frontOffice/css/flaticon.css">
    <link rel="stylesheet" href="frontOffice/css/icomoon.css">
    <link rel="stylesheet" href="frontOffice/css/style.css">
  </head>
<body class="goto-here">
		<div class="py-1 bg-primary">
    	<div class="container">
    		<div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
	    		<div class="col-lg-12 d-block">
		    		<div class="row d-flex">
		    			<div class="col-md pr-4 d-flex topper align-items-center">
					    	<div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-phone2"></span></div>
						    <span class="text">+212 1235 2355 98</span>
					    </div>
					    <div class="col-md pr-4 d-flex topper align-items-center">
					    	<div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-paper-plane"></span></div>
						    <span class="text">Grocery@Store.com</span>
					    </div>
					    <div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
						    <span class="text">Livraison En 7/24h 7 Jours  &amp; Et Retours Gratuits</span>
					    </div>
				    </div>
			    </div>
		    </div>
		  </div>
    </div>
    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index.co">Grocery Store</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item "><a href="index.co" class="nav-link">Accueil</a></li>
	          <li class="nav-item"><a href="produit.co" class="nav-link">nos produits</a></li>
	          <li class="nav-item active"><a href="about.co" class="nav-link">a propos de nous</a></li>
	          <li class="nav-item"><a href="contact.co" class="nav-link">Contacter</a></li>
	          <li class="nav-item cta cta-colored"><a href="cart.co" class="nav-link"><span class="icon-shopping_cart"></span>[${metierC.nombrePanier(client.id)}]</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
<div class="container">
                   <div class="card">
                      <div class="card-header">
                            Les Commandes
                      </div>
 
                      <div class="card-body">
                            <div class="table-responsive">
                                <table class="table" id="dataTable"  width="100%" cellspacing="0">
                                    <thead>
                                         <tr>
                                          <th>Date Commande</th><th>Date Livraison</th><th>Durre</th><th>Prix Totale</th><th></th><th></th>
                                        </tr>
                                     </thead>
                                     <tbody>
                              <c:forEach items="${model.commandes}" var="c">
                                <tr id='parents'>
                                
                                  
                                  <td>${c.dateCommande}</td>
                                  <td>${c.dateLivraison}</td>
                                  <td>${c.valeurDurre()}</td>
                                  <td>${c.prixTotale}</td>
                                  
                                     
                                  <td><a href="voireProduits.co?id=${c.id}"><button type="button" class="btn btn-primary">Produits</button></a></td>
                                  <td><a href="telecharger.co?id=${c.id}"><button   class="btn btn-primary float-right" >télécharger le reçu</button></a></td>
                                  
                                </tr>
                               
                              </c:forEach>
                              </tbody>
                           </table>
                      </div>
                  </div>
            </div>
          </div>
           
  <div id="myModal" class="modal fade" role="dialog">
      <div class="modal-dialog">
    
        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
          <h4 class="modal-title ">reçu de paiement</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">

            <form action="save.do" method="post">
                <div class="form-group">
                   <label class="control-label">Nom Produit :</label>
                   <input type="text" name="nom" class="form-control"/>
                </div>
                
                <div class="form-group">
                    <label class="control-label">Prix :</label>
                    <input type="text" name="prix" class="form-control"/>
               </div>
               
                <div class="form-group">
                    <label class="control-label">Prix D'achat :</label>
                    <input type="text" name="prixAchat" class="form-control"/>
               </div>
               
               <div class="form-group">
                    <label class="control-label">Quantite :</label>
                    <input type="text" name="quantite" class="form-control"/>
               </div>
               
              <div class="form-group">
                    <label class="control-label">Quantite Vendue:</label>
                    <input type="text" name="quantiteVendue" class="form-control"/>
               </div>
               
               <div class="form-group">
                    <label class="control-label">Remise :</label>
                    <input type="text" name="remis" class="form-control"/>
               </div>
               
               <div>
                  <button type="submit" class="btn btn-primary">Ajouter</button>
               </div>
            </form>
          </div>
        
        </div>
    </div></div>
        <script src="backOffice/js/jquery.min.js"></script>
    <script src="backOffice/js/bootstrap.bundle.min.js"></script>
    <script src="backOffice/js/sb-admin-2.min.js"></script>


</body>
</html>