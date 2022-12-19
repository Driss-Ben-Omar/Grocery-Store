<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <title>a  propos de nous</title>
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


<div class="card  mx-auto">
  <div class="row">
    <div class="col">
      <img src='frontOffice/images/About-us.png' class="img-fluid" alt="...">
    </div>
    <div class="col">
      <div class="card-body">
        <h5 class="card-title">Bienvenue sur Grocery Store votre supermarché online</h5>
        	<p>Grocery Store est un hypermarché en ligne qui dispose d’un large choix de produits et références pour répondre aux besoins de toute la famille même les plus exigent, avec plus de 100 marque dans notre catalogue, vous trouvez tout ce dont vous avez besoin. Découvrez une large gamme de produits frais fruits, légumes, salades et herbes du riz des épices et assaisonnement aux produits de soins personnels, boisson. Avec Grocery Store vous n’avez plus besoin de pousser un chariot lourd et prendre la queue devant la caisse plein du monde. Faite vos courses de chez vous en toutes légèreté et votre commande sera chez vous le lendemain. Grocery Store vous aide a trouver tout ce que vous voulez avec ces multiples possibilité de recherche et de filtre qui va facilité a l’utilisateur la manipulation pour trouver la meilleure qualité disponible aux prix le plus optimale .</p>
        <p class="card-text">
		 <small class="text-muted">
		    Grocery Stor vous garantit une livraison à temps et la qualité la plus optimale<br>
             Produits haute qualité<br>
			 Service client inégalé
		 </small>
		</p>
		<p><a href="produit.co" class="btn btn-primary">Achetez maintenant</a></p>
      </div>
    </div>
  </div>
</div>


		
		<section class="ftco-section ftco-counter img" id="section-counter" style="background-image: url(frontOffice/images/bg_3.jpg);">
    	<div class="container">
    		<div class="row justify-content-center py-5">
    			<div class="col-md-10">
		    		<div class="row">
		          <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18 text-center">
		              <div class="text">
		                <strong class="number" data-number="10000">0</strong>
		                <span>Clients satisfaits</span>
		              </div>
		            </div>
		          </div>
		          <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18 text-center">
		              <div class="text">
		                <strong class="number" data-number="100">0</strong>
		                <span>Prodruits</span>
		              </div>
		            </div>
		          </div>
		          <div class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18 text-center">
		              <div class="text">
		                <strong class="number" data-number="1000">0</strong>
		                <span>Commandes</span>
		              </div>
		            </div>
		          </div>
		        </div>
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

    <section class="ftco-section bg-light">
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