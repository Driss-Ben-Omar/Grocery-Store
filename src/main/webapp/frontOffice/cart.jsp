<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <title>Panier</title>
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
    <script src="https://kit.fontawesome.com/a8ccccba04.js" crossorigin="anonymous"></script>
    <div class="modal fade" id="parametreModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">changer les paramètre</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                <form action="change.co" method="post">
                <div  hidden class="form-group">
                     <label class="control-label">id :</label>
                     <input type="text" name="id" class="form-control" value="${client.id}"/>
                </div>
                <div   class="form-group">
                     <label class="control-label">Nom Complet :</label>
                     <input type="text" name="nomComplet" class="form-control" value="${client.getNomComplet()}"/>
                </div>
                
                <div class="form-group">
                     <label class="control-label">Email :</label>
                     <input type="text" name="email" class="form-control" />
                 </div>
                 
                <div class="form-group">
                      <label class="control-label">Mot de passe  :</label>
                      <input type="text" name="passWord" class="form-control" />
                </div> 
                
                <div class="form-group">
                      <label class="control-label">Nouveau mot de passe  :</label>
                      <input type="text" name="newPassWord" class="form-control" />
                </div> 
                
                 <div class="form-group">
                      <label class="control-label">Numero de telephone :</label>
                      <input type="text" name="numTele" class="form-control" value="${client.numeroTelephone}"/>
                </div> 
                <div class="form-group">
                      <label class="control-label">Date de naissance  :</label>
                      <input type="text" name="dateNaissance" class="form-control" value="${client.dateNaissance}"/>
                </div>
                <div class="form-group">
                      <label class="control-label">Adresse  :</label>
                      <input type="text" name="adresse" class="form-control" value="${client.adresse}"/>
                </div>
                
                 <div>
                      <button type="submit" class="btn btn-primary">Modifier</button>
                 </div>
          </form>
          </div>


                  </div>
                <div class="modal-footer">
                   <button type="button" class="btn btn-default" data-dismiss="modal">fermer</button>
                </div>
            </div>
        </div>
    
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
	          <li class="nav-item active"><a href="index.co" class="nav-link">Accueil</a></li>
	          <li class="nav-item"><a href="produit.co" class="nav-link">nos produits</a></li>
	          <li class="nav-item"><a href="about.co" class="nav-link">a propos de nous</a></li>
	          <li class="nav-item"><a href="contact.co" class="nav-link">Contacter</a></li>
	          <li class="nav-item cta cta-colored"><a href="cart.co" class="nav-link"><span class="icon-shopping_cart"></span>[${metierC.nombrePanier(client.id)}]</a></li>
	        </ul>
	      </div>
	    </div>
	    <div class="float-right nav-item dropdown no-arrow">
              
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">M. ${sessionScope.client.getNomComplet()}</span>
                                <img class="img-profile rounded-circle" src="backOffice/jsp/profile.png">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                            
                             <a class="dropdown-item" href="commandes.co" >
                                   <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                     Mes commandes
                                </a>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#parametreModal">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    les paramètre
                                </a>
                               
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="logout.co" >
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Se déconnecter
                                </a>
                            </div>
                      </div>
	  </nav>
    <!-- END nav -->

    

    <section class="ftco-section ftco-cart">
      <form action='creeCommand.co' method='post'>
			<div class="container">
				<div class="row">
    			<div class="col-md-12 ftco-animate">
    				<div class="cart-list">
    				
	    				<table class="table">
						    <thead class="thead-primary">
						      <tr class="text-center">
						        <th>&nbsp;</th>
						        <th>&nbsp;</th>
						        <th>Nom du produit</th>
						        <th>Prix</th>
						        <th>Quantité</th>
						        <th>Total</th>
						      </tr>
						    </thead>
						    <tbody>
						    <c:forEach items="${model.produits}" var="p">
						      <tr class="text-center">
						        <td class="product-remove"><a href="removeFromCart.co?id=${p.idProduit }"><span class="ion-ios-close"></span></a></td>
						        
						        <td class="image-prod"><div class="img" style="background-image:url(frontOffice/images/${p.nomProduit}_${p.idProduit}.jpg);"></div></td>
						        
						        <td class="product-name">
						        	<h3>${p.nomProduit}</h3>      	
						        </td>
						        
						        <td class="price">${p.prix} Dh</td>
						        
						       <td>
						   	
						      <a  href='dec.co?id=${p.idProduit}' class="btn btn-primary"><i class="fas fa-minus" ></i></a>
                        
					             	<label> ${q=metierC.getQuantite(p.idProduit,c.getId())}</label>
                   
					           <a href='inc.co?id=${p.idProduit}' class="btn btn-primary" ><i class="fas fa-plus " ></i></a>
					    
					          </td>
						        
						        <td class="total">${t=p.prix*q} DH</td>
						        <div hidden>${total=total+t}</div>
						        <div hidden>${remis=remis+p.remise}</div>
						      </tr><!-- END TR-->

						    </c:forEach>
						    </tbody>
						  </table>
					  </div>
    			</div>
    		</div>
    		<div class="row justify-content-end">


    			<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
    				<div class="cart-total mb-3">
    					<h3>Totaux du panier</h3>
    					<p class="d-flex">
    						<span>Total</span>
    						<span>${total} DH</span>
    						
    					</p>
    					<p class="d-flex">
    						<span>Remise</span>
    						<span>${remis}</span>
    					</p>
    					<hr>
    					<p class="d-flex total-price">
    						<span>prix après Remise</span>
    						<span>${pt=total-remis} DH</span>
    					</p>
    				</div>
    				<p><a href="creeCommand.co?prix=${pt}"  class="btn btn-primary py-3 px-4">Passer la commande</a></p>
    			</div>
    		</div>
			</div>
			</form>
		</section>
		

      <footer class="ftco-footer ftco-section">
      <div class="container">
      	<div class="row">
      		<div class="mouse">
						<a href="#" class="mouse-icon">
							<div class="mouse-wheel"><span class="ion-ios-arrow-up"></span></div>
						</a>
					</div>
      	</div>
        <div class="row mb-5">
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Grocery Store</h2>
              <p>Nous somme les leader en négociations et ventes en ligne au Maroc.</p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-5">
              <h2 class="ftco-heading-2">Menu</h2>
              <ul class="list-unstyled">
                <li><a href="produit.co" class="py-2 d-block">Produits</a></li>
                <li><a href="about.co" class="py-2 d-block">a propos de nous</a></li>
                <li><a href="contact.co" class="py-2 d-block">Contacter</a></li>
              </ul>
            </div>
          </div>
        
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Vous avez une question ?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><span class="icon icon-map-marker"></span><span class="text">Av. des Forces Armées Royales, Tétouan 93000</span></li>
	                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+212 392 392 721</span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">grocery@store.com</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">

            <p>
				&copy;<script>document.write(new Date().getFullYear());</script> Tous droits réservés 
			</p>
          </div>
        </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


<script src="frontOffice/js/jquery.min.js"></script>
  <script src="frontOffice/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="frontOffice/js/popper.min.js"></script>
  <script src="frontOffice/js/bootstrap.min.js"></script>
  <script src="frontOffice/js/jquery.easing.1.3.js"></script>
  <script src="frontOffice/js/jquery.waypoints.min.js"></script>
  <script src="frontOffice/js/jquery.stellar.min.js"></script>
  <script src="frontOffice/js/owl.carousel.min.js"></script>
  <script src="frontOffice/js/jquery.magnific-popup.min.js"></script>
  <script src="frontOffice/js/aos.js"></script>
  <script src="frontOffice/js/jquery.animateNumber.min.js"></script>
  <script src="frontOffice/js/bootstrap-datepicker.js"></script>
  <script src="frontOffice/js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="frontOffice/js/google-map.js"></script>
  <script src="frontOffice/js/main.js"></script>

 

  </body>
</html>