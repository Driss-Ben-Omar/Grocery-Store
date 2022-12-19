<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
  <head>
    <title>Grocery Store </title>
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
    <script type="text/javascript" src="//code.jquery.com/jquery-1.11.3.min.js"></script>
   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

     <!-- parametre modal-->
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
   
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/a8ccccba04.js" crossorigin="anonymous"></script>
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
    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light " id="ftco-navbar">
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
	      </ul> </div>   
	         
            </div>
	         
              <c:if test="${sessionScope.client!=null}">
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
                      
                    
             </c:if>
             
             <c:if test="${sessionScope.client==null}">
               <div class="float-right"><a href="Connexion" class="nav-link">connecter</a></div>
             </c:if>
             
             
</nav>
	        
	      
	  
    <!-- END nav -->

    <section id="home-section" class="hero">
		  <div class="home-slider owl-carousel">
	      <div class="slider-item" style="background-image: url(frontOffice/images/bg_1.jpg);">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

	            <div class="col-md-12 ftco-animate text-center">
	              <h1 class="mb-2">Nous servons des légumes frais &amp; fruits</h1>
	              <h2 class="subheading mb-4">Nous livrons des légumes bio &amp;  fruits</h2>
	              <p><a href="#" class="btn btn-primary">Voir les détails</a></p>
	            </div>

	          </div>
	        </div>
	      </div>

	      <div class="slider-item" style="background-image: url(frontOffice/images/bg_2.jpg);">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

	            <div class="col-sm-12 ftco-animate text-center">
	              <h1 class="mb-2">100% frais &amp; Aliments bio</h1>
	              <h2 class="subheading mb-4">Nous livrons des légumes bio &amp; fruits</h2>
	              <p><a href="#" class="btn btn-primary">Voir les détails</a></p>
	            </div>

	          </div>
	        </div>
	      </div>
	    </div>
    </section>

    <section class="ftco-section">
	 <div class="container">
		<div class="row no-gutters ftco-services">
          <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services mb-md-0 mb-4">
              <div class="icon bg-color-1 active d-flex justify-content-center align-items-center mb-2">
            		<span class="flaticon-shipped"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">Livraison gratuite</h3>
                <span>dans la ville et la région de tetouan</span>
              </div>
            </div>      
          </div>
          <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services mb-md-0 mb-4">
              <div class="icon bg-color-2 d-flex justify-content-center align-items-center mb-2">
            		<span class="flaticon-diet"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">Toujours frais</h3>
                <span>Produit bien emballé</span>
              </div>
            </div>    
          </div>
          <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services mb-md-0 mb-4">
              <div class="icon bg-color-3 d-flex justify-content-center align-items-center mb-2">
            		<span class="flaticon-award"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">Qualité supérieure</h3>
                <span>Produits de qualité</span>
              </div>
            </div>      
          </div>
          <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services mb-md-0 mb-4">
              <div class="icon bg-color-4 d-flex justify-content-center align-items-center mb-2">
            		<span class="flaticon-customer-service"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">Service Client</h3>
                <span>24/7 h</span>
              </div>
            </div>      
          </div>
        </div>
			</div>
		</section>

		<section class="ftco-section ftco-category ftco-no-pt">
			<div class="container">
				<div class="row">
					<div class="col-md-8">
						<div class="row">
							<div class="col-md-6 order-md-last align-items-stretch d-flex">
								<div class="category-wrap-2 ftco-animate img align-self-stretch d-flex" style="background-image: url(frontOffice/images/category.jpg);">
									<div class="text text-center">
										<h2>Catégories</h2>
										<p>Protégez la santé de votre famille</p>
										<p><a href="produit.co" class="btn btn-primary">Achetez maintenant</a></p>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="category-wrap ftco-animate img mb-4 d-flex align-items-end" style="background-image: url(frontOffice/images/category-1.jpg);">
									<div class="text px-3 py-1">
										<h2 class="mb-0"><a href="#">fruits et Légumes</a></h2>
									</div>
								</div>
								<div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(frontOffice/images/category-8.jpg);">
									<div class="text px-3 py-1">
										<h2 class="mb-0"><a href="#">Boucherie</a></h2>
									</div>
								</div>
								<p></p>
								<div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(frontOffice/images/category-7.jpg);">
									<div class="text px-3 py-1">
										<h2 class="mb-0"><a href="#">Volaille</a></h2>
									</div>
								</div>
								<p></p>
								<div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(frontOffice/images/category-10.jpg);">
									<div class="text px-3 py-1">
										<h2 class="mb-0"><a href="#">Poissonnerie</a></h2>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-4">
					   <div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(frontOffice/images/category-9.jpg);">
							<div class="text px-3 py-1">
								<h2 class="mb-0"><a href="#">les produits laitiers</a></h2>
							</div>
						</div>
						<div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(frontOffice/images/category-6.jpg);">
							<div class="text px-3 py-1">
								<h2 class="mb-0"><a href="#">Boulangerie</a></h2>
							</div>		
						</div><p></p>
						<div class="category-wrap ftco-animate img mb-4 d-flex align-items-end" style="background-image: url(frontOffice/images/category-11.jpg);">
							<div class="text px-3 py-1">
								<h2 class="mb-0"><a href="#">Nettoyage</a></h2>
							</div>		
						</div><p></p>
						<div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(frontOffice/images/category-12.jpg);">
							<div class="text px-3 py-1">
								<h2 class="mb-0"><a href="#">épicerie</a></h2>
							</div>
						</div>		
					</div>
					
				</div>
			</div>
		</section>

    <section class="ftco-section">
    	<div class="container">
				<div class="row justify-content-center mb-3 pb-3">
          <div class="col-md-12 heading-section text-center ftco-animate">
          	<span class="subheading">Produits populaires</span>
            <h2 class="mb-4">Nos produits</h2>
            <p>vous pouvez voir tous les produits <a href='produit.co'>ici</a></p>
          </div>
        </div>   		
    	</div>
    	<div class="container">
    		<div class="row">
    			<div class="col-md-6 col-lg-3 ftco-animate">
    				<div class="product">
    					<a href="#" class="img-prod"><img class="img-fluid" src="frontOffice/images/product-1.jpg" alt="Colorlib Template">
    						<span class="status">30%</span>
    						<div class="overlay"></div>
    					</a>
    					<div class="text py-3 pb-4 px-3 text-center">
    						<h3><a href="#">POIVRON</a></h3>
    						<div class="d-flex">
    							<div class="pricing">
		    						<p class="price"><span class="mr-2 price-dc">12.00 DH</span><span class="price-sale">8.00 DH</span></p>
		    					</div>
	    					</div>
	    					<div class="bottom-area d-flex px-3">
	    						<div class="m-auto d-flex">
	    							<a href="#" class="add-to-cart d-flex justify-content-center align-items-center text-center">
	    								<span><i class="ion-ios-menu"></i></span>
	    							</a>
	    							<a href="#" class="buy-now d-flex justify-content-center align-items-center mx-1">
	    								<span><i class="ion-ios-cart"></i></span>
	    							</a>
	    							<a href="#" class="heart d-flex justify-content-center align-items-center ">
	    								<span><i class="ion-ios-heart"></i></span>
	    							</a>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    			<div class="col-md-6 col-lg-3 ftco-animate">
    				<div class="product">
    					<a href="#" class="img-prod"><img class="img-fluid" src="frontOffice/images/product-2.jpg" alt="Colorlib Template">
    						<div class="overlay"></div>
    					</a>
    					<div class="text py-3 pb-4 px-3 text-center">
    						<h3><a href="#">Fraise</a></h3>
    						<div class="d-flex">
    							<div class="pricing">
		    						<p class="price"><span>12.00 DH</span></p>
		    					</div>
	    					</div>
    						<div class="bottom-area d-flex px-3">
	    						<div class="m-auto d-flex">
	    							<a href="#" class="add-to-cart d-flex justify-content-center align-items-center text-center">
	    								<span><i class="ion-ios-menu"></i></span>
	    							</a>
	    							<a href="#" class="buy-now d-flex justify-content-center align-items-center mx-1">
	    								<span><i class="ion-ios-cart"></i></span>
	    							</a>
	    							<a href="#" class="heart d-flex justify-content-center align-items-center ">
	    								<span><i class="ion-ios-heart"></i></span>
	    							</a>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    			<div class="col-md-6 col-lg-3 ftco-animate">
    				<div class="product">
    					<a href="#" class="img-prod"><img class="img-fluid" src="frontOffice/images/product-3.jpg" alt="Colorlib Template">
	    					<div class="overlay"></div>
	    				</a>
    					<div class="text py-3 pb-4 px-3 text-center">
    						<h3><a href="#">Haricots verts</a></h3>
    						<div class="d-flex">
    							<div class="pricing">
		    						<p class="price"><span>9.00 DH</span></p>
		    					</div>
	    					</div>
    						<div class="bottom-area d-flex px-3">
	    						<div class="m-auto d-flex">
	    							<a href="#" class="add-to-cart d-flex justify-content-center align-items-center text-center">
	    								<span><i class="ion-ios-menu"></i></span>
	    							</a>
	    							<a href="#" class="buy-now d-flex justify-content-center align-items-center mx-1">
	    								<span><i class="ion-ios-cart"></i></span>
	    							</a>
	    							<a href="#" class="heart d-flex justify-content-center align-items-center ">
	    								<span><i class="ion-ios-heart"></i></span>
	    							</a>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    			<div class="col-md-6 col-lg-3 ftco-animate">
    				<div class="product">
    					<a href="#" class="img-prod"><img class="img-fluid" src="frontOffice/images/product-4.jpg" alt="Colorlib Template">
    						<div class="overlay"></div>
    					</a>
    					<div class="text py-3 pb-4 px-3 text-center">
    						<h3><a href="#">Chou rouge</a></h3>
    						<div class="d-flex">
    							<div class="pricing">
		    						<p class="price"><span>17.00 DH</span></p>
		    					</div>
	    					</div>
    						<div class="bottom-area d-flex px-3">
	    						<div class="m-auto d-flex">
	    							<a href="#" class="add-to-cart d-flex justify-content-center align-items-center text-center">
	    								<span><i class="ion-ios-menu"></i></span>
	    							</a>
	    							<a href="#" class="buy-now d-flex justify-content-center align-items-center mx-1">
	    								<span><i class="ion-ios-cart"></i></span>
	    							</a>
	    							<a href="#" class="heart d-flex justify-content-center align-items-center ">
	    								<span><i class="ion-ios-heart"></i></span>
	    							</a>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>


    			<div class="col-md-6 col-lg-3 ftco-animate">
    				<div class="product">
    					<a href="#" class="img-prod"><img class="img-fluid" src="frontOffice/images/product-5.jpg" alt="Colorlib Template">
    						<span class="status">30%</span>
    						<div class="overlay"></div>
    					</a>
    					<div class="text py-3 pb-4 px-3 text-center">
    						<h3><a href="#">Tomate</a></h3>
    						<div class="d-flex">
    							<div class="pricing">
		    						<p class="price"><span class="mr-2 price-dc">12.00 DH</span><span class="price-sale">8.00DH</span></p>
		    					</div>
	    					</div>
	    					<div class="bottom-area d-flex px-3">
	    						<div class="m-auto d-flex">
	    							<a href="#" class="add-to-cart d-flex justify-content-center align-items-center text-center">
	    								<span><i class="ion-ios-menu"></i></span>
	    							</a>
	    							<a href="#" class="buy-now d-flex justify-content-center align-items-center mx-1">
	    								<span><i class="ion-ios-cart"></i></span>
	    							</a>
	    							<a href="#" class="heart d-flex justify-content-center align-items-center ">
	    								<span><i class="ion-ios-heart"></i></span>
	    							</a>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    			<div class="col-md-6 col-lg-3 ftco-animate">
    				<div class="product">
    					<a href="#" class="img-prod"><img class="img-fluid" src="frontOffice/images/product-6.jpg" alt="Colorlib Template">
    						<div class="overlay"></div>
    					</a>
    					<div class="text py-3 pb-4 px-3 text-center">
    						<h3><a href="#">Brocoli</a></h3>
    						<div class="d-flex">
    							<div class="pricing">
		    						<p class="price"><span>12.00 DH</span></p>
		    					</div>
	    					</div>
    						<div class="bottom-area d-flex px-3">
	    						<div class="m-auto d-flex">
	    							<a href="#" class="add-to-cart d-flex justify-content-center align-items-center text-center">
	    								<span><i class="ion-ios-menu"></i></span>
	    							</a>
	    							<a href="#" class="buy-now d-flex justify-content-center align-items-center mx-1">
	    								<span><i class="ion-ios-cart"></i></span>
	    							</a>
	    							<a href="#" class="heart d-flex justify-content-center align-items-center ">
	    								<span><i class="ion-ios-heart"></i></span>
	    							</a>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    			<div class="col-md-6 col-lg-3 ftco-animate">
    				<div class="product">
    					<a href="#" class="img-prod"><img class="img-fluid" src="frontOffice/images/product-7.jpg" alt="Colorlib Template">
	    					<div class="overlay"></div>
	    				</a>
    					<div class="text py-3 pb-4 px-3 text-center">
    						<h3><a href="#">CAROTTES</a></h3>
    						<div class="d-flex">
    							<div class="pricing">
		    						<p class="price"><span>5.00 DH</span></p>
		    					</div>
	    					</div>
    						<div class="bottom-area d-flex px-3">
	    						<div class="m-auto d-flex">
	    							<a href="#" class="add-to-cart d-flex justify-content-center align-items-center text-center">
	    								<span><i class="ion-ios-menu"></i></span>
	    							</a>
	    							<a href="#" class="buy-now d-flex justify-content-center align-items-center mx-1">
	    								<span><i class="ion-ios-cart"></i></span>
	    							</a>
	    							<a href="#" class="heart d-flex justify-content-center align-items-center ">
	    								<span><i class="ion-ios-heart"></i></span>
	    							</a>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    			<div class="col-md-6 col-lg-3 ftco-animate">
    				<div class="product">
    					<a href="#" class="img-prod"><img class="img-fluid" src="frontOffice/images/product-8.jpg" alt="Colorlib Template">
    						<div class="overlay"></div>
    					</a>
    					<div class="text py-3 pb-4 px-3 text-center">
    						<h3><a href="#">Jus de fruit</a></h3>
    						<div class="d-flex">
    							<div class="pricing">
		    						<p class="price"><span>15.00 DH</span></p>
		    					</div>
	    					</div>
    						<div class="bottom-area d-flex px-3">
	    						<div class="m-auto d-flex">
	    							<a href="#" class="add-to-cart d-flex justify-content-center align-items-center text-center">
	    								<span><i class="ion-ios-menu"></i></span>
	    							</a>
	    							<a href="#" class="buy-now d-flex justify-content-center align-items-center mx-1">
	    								<span><i class="ion-ios-cart"></i></span>
	    							</a>
	    							<a href="#" class="heart d-flex justify-content-center align-items-center ">
	    								<span><i class="ion-ios-heart"></i></span>
	    							</a>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>
    	</div>
    </section>
		
		<section class="ftco-section img" style="background-image: url(frontOffice/images/bg_3.jpg);">
    	<div class="container">
				<div class="row justify-content-end">
          <div class="col-md-6 heading-section ftco-animate deal-of-the-day ftco-animate">
          	<span class="subheading">Meilleur prix pour vous</span>
            <h2 class="mb-4">LIVRAISON GRATUITE</h2>
            <p>sur Tetouan et les région</p>
            
            
          </div>
        </div>   		
    	</div>
    </section>

    <section class="ftco-section testimony-section">
      <div class="container">
        <div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section ftco-animate text-center">
          	<span class="subheading">Témoignage</span>
            <h2 class="mb-4">Notre client satisfait dit</h2>
            <p>vous pouvez nous envoyer votre avis <a href="contact.co">ici</a> </p>
          </div>
        </div>
        <div class="row ftco-animate">
          <div class="col-md-12">
            <div class="carousel-testimony owl-carousel">
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div class="user-img mb-5" style="background-image: url(frontOffice/images/person_1.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">Bonsoir je viens de recevoir ma commande aujourd'hui. Je tiens à vous remercier pour l'intérêt que vous portez à vos clients et pour le sérieux de votre service et . Bonne continuation.</p>
                    <p class="name">ahmed bakkali</p>
                    <span class="position">Marketing Manager</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div class="user-img mb-5" style="background-image: url(frontOffice/images/person_2.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">Tout est parfait !! J'ai effectué trois commande sur site et à chaque fois je reçois ma marchandise le jour suivant. le livreur est sympa. Merci,je vous donne 5 étoiles.</p>
                    <p class="name">hicham khaldi</p>
                    <span class="position">Interface Designer</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div class="user-img mb-5" style="background-image: url(frontOffice/images/person_3.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">
						Bonjour,Je tiens à vous informer de la  réception de ma commande ce jour.
						Tout est bien emballé et bien conforme.
						Je vous remercie pour votre sérieux.
						En tout cas, pour une première commande, je suis très satisfait et rassuré.
						Je ne manquerais pas de repasser par votre site pour de prochains achats.
						Merci encore à toute l'équipe .Bon courage
					</p>
                    <p class="name">mohammed elwardani</p>
                    <span class="position">UI Designer</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div class="user-img mb-5" style="background-image: url(frontOffice/images/person_4.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">pour une première commande, je suis très satisfait et rassuré.
						Je ne manquerais pas de repasser par votre site pour de prochains achats.
						Merci encore à toute l'équipe .Bon courage
					</p>
                    <p class="name">issam bennani</p>
                    <span class="position">Web Developer</span>
                  </div>
                </div>
              </div>
              
            </div>
          </div>
        </div>
      </div>
    </section>

    <hr>

		

		
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
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">connectez-vous </h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><a href="registre.co"><span class="text">créer un compte</span></a></li>
	                <li><a href="login.co"><span class="text">connectez-vous en tant qu'client</span></a></li>
	                <li><a href="login.do"><span class="text">connectez-vous en tant qu'admin</span></a></li>
	                <li><a href="login.lo"><span class="text">connectez-vous en tant qu'livreur</span></a></li>
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
  <script src="backOffice/js/jquery.min.js"></script>
    <script src="backOffice/js/bootstrap.bundle.min.js"></script>
    <script src="backOffice/js/sb-admin-2.min.js"></script>
    
  </body>
</html>