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
             <div class="container">
                   <div class="card">
                      <div class="card-header">
                            Les Commandes
                      </div>

                       <div class="card-body">
                            <div class="table-responsive">
                                <table class="table" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Nom Produit</th><th>Prix</th><th>Remise</th><th>Quantité</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                         <c:forEach items="${model.produits}" var="p">
                                <tr>
                                  
                                  <td>${p.nomProduit }</td>
                                  <td>${p.prixAchat}</td>
                                  <td>${p.remise}</td>
                                  <td>${metierC.getQuantiteProduit(p.idProduit,idcommande)}</td>
                              
                                </tr>
                              </c:forEach>
                                    
                                    </tbody>
                                </table>
                            </div>
                        </div>
</div></div>
</body>
</html>