<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>CommandeLivrer</title>
    <link href="frontOffice/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="frontOffice/css/sb-admin-2.min.css" rel="stylesheet" >
     <link href="backOffice/css/dataTables.bootstrap4.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/a8ccccba04.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js" crossorigin="anonymous"></script>
   <script>
   $(document).ready(function() {
	    $('#dataTable').DataTable( {
	        "language": {
	            "url": "//cdn.datatables.net/plug-ins/1.11.5/i18n/fr-FR.json"
	        }
	    } );
	} );
   
  
   $(document).ready(function() {

	   if(window.location.href.indexOf('#myModaledit') != -1) {
	     $('#myModal').modal('show');
	   }

	 });
   </script>
  
    
   </head>
<body id="page-top">

<script>

function filterFunction() {

	  var input, filter, ul, li, a, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  div = document.getElementById("myDropdown");
	  a = div.getElementsByTagName("a");
	  for (i=0; i<a.length; i++) {
	    txtValue = a[i].textContent || a[i].innerText;
	    if (txtValue.toUpperCase().indexOf(filter) > -1) {
	      a[i].style.display="";
	    } else {
	      a[i].style.display="none";
	    }
	  }
	}
	
	

</script>

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.do">
                <div class="sidebar-brand-icon"> 
                     <img src="backOffice/jsp/logo.png" alt="logo" >
                </div>
                <div class="sidebar-brand-text mx-3">Grocery Store</div>
            </a>

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.do">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fa fa-product-hunt" aria-hidden="true"></i>
                    <span>Produit</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">produit :</h6>
                        <a class="collapse-item" href="chercher.do?motCle=">Produits</a>
                        <a  href='chercher.do?motCle=#myModaledit'  class="collapse-item">Saisie Produit</a>
                        
                    </div>
                </div>
            </li>
            
              <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseone" aria-expanded="true" aria-controls="collapseone">
                   <i class="fa fa-car" aria-hidden="true"></i>
                    <span>Voiture</span>
                </a>
                <div id="collapseone" class="collapse" aria-labelledby="headingone" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">voiture :</h6>
                        <a class="collapse-item" href="chercherVoiture.do?motCle=">Voitures</a>
                        <a  href='chercherVoiture.do?motCle=#myModaledit'  class="collapse-item">Saisie Voiture</a>
                        
                    </div>
                </div>
            </li>
            
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsefour" aria-expanded="true" aria-controls="collapsefour">
                   <i class="fa fa-male" aria-hidden="true"></i>
                    <span>Livreur</span>
                </a>
                <div id="collapsefour" class="collapse" aria-labelledby="headingfour" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">livreur :</h6>
                        <a class="collapse-item" href="chercherLivreur.do?motCle=">Livreur</a>
                        <a  href='chercherLivreur.do?motCle=#myModaledit'  class="collapse-item">Saisie Livreur</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                    <span>les Commandes</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Commandes:</h6>
                       <a class="collapse-item" href="chercherCommande.do">Commandes</a>
                        <a class="collapse-item" href="chercherCommandeLivrer.do">Commandes Livrees</a>
                        <a class="collapse-item" href="chercherTache.do">les voyage</a>
                    </div>
                </div>
            </li>
            
                        <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <span>client</span>
                </a>
                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Clients:</h6>
                        <a class="collapse-item" href="chercherClient.do">clients</a>
                       
                    </div>
                </div>
            </li>



            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
 
                        <div class="input-group  navbar-search dropdown">
                            <input type="text" autocomplete="off" class="form-control bg-light border-primary border-1 small dropdown-toggle"  data-toggle="dropdown" placeholder="chercher..."   id="myInput" onkeyup="filterFunction()"> 
 
                           <div class=" dropdown-menu list-group-flush" id="myDropdown" >
                               <a href="chercher.do?motCle=" class="list-group-item list-group-item-action ">Produits</a>
                               <a href='chercher.do?motCle=#myModaledit' class="list-group-item list-group-item-action">Saisie Produit</a>
                               <a href="chercherVoiture.do?motCle=" class="list-group-item list-group-item-action">Voitures</a>
                               <a href='chercherVoiture.do?motCle=#myModaledit'  class="list-group-item list-group-item-action">Saisie Voiture</a>
                               <a href="chercherLivreur.do?motCle=" class="list-group-item list-group-item-action">Livreurs</a>
                               <a href='chercherLivreur.do?motCle=#myModaledit'  class="list-group-item list-group-item-action">Saisie Livreur</a>
                               <a href="chercherCommande.do" class="list-group-item list-group-item-action ">Commandes</a>
                               <a href="chercherCommandeLivrer.do" class="list-group-item list-group-item-action ">Commandes Livrer</a>
                               <a href="chercherClient.do" class="list-group-item list-group-item-action ">Clients</a>
                               <a href="chercherTache.do" class="list-group-item list-group-item-action ">voyages</a>
                               
                          </div>
                           
                            <div class="input-group-append">
                                <button class="btn btn-primary" >
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>   
                        </div>
                               
                    
                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

    
                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Admin</span>
                                <img class="img-profile rounded-circle" src="backOffice/jsp/profile.png">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                             
                                 <a class="dropdown-item" href="#" data-toggle="modal" data-target="#parametreModal">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    les paramètre
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Se déconnecter
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Les Commande Livrer</h1>
                    </div>

                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                        
                        
                            <h6 class="m-0 font-weight-bold text-primary">Les Commande Livrer</h6>
                             
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                     <tr>
                                             <th>ID</th><th>Nom Client</th><th>Numero Telephone</th><th>Adresse Client</th><th>Date Commande</th><th>Date Livraison</th><th>Prix Totale</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                         <c:forEach items="${model.commandesLivrer}" var="cl">
                                <tr>
                                  <td>${cl.id }</td>
                                  <td>${cl.nomComplet }</td>
                                  <td>${cl.numeroTelephone }</td>
                                  <td>${cl.adresse }</td>
                                  <td>${cl.dateCommande }</td>
                                  <td>${cl.dateLivraison}</td>
                                  <td>${cl.prixTotale}</td>
                       
                                 
                                </tr>
                              </c:forEach>
                                    
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    

                   

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->


        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Prêt à partir?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Sélectionnez "Déconnexion" ci-dessous si vous êtes prêt à mettre fin à votre session en cours</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Annuler</button>
                    <a class="btn btn-primary" href="logout.do">Déconnexion</a>
                </div>
            </div>
        </div>
    </div>
    
    
          
    
    <div class="modal fade" id="parametreModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">changer les paramètre d'admin</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                <form action="change.do" method="post">
                <div  hidden class="form-group">
                     <label class="control-label">Nom Complet :</label>
                     <input type="text" name="nomComplet" class="form-control" value="${admin.nomComplet}"/>
                </div>
                
                <div class="form-group">
                     <label class="control-label">Email :</label>
                     <input type="text" name="email" class="form-control" value="${admin.email}"/>
                 </div>
                 
                <div class="form-group">
                      <label class="control-label">mot de pass  :</label>
                      <input type="text" name="passWord" class="form-control" value="${admin.password}"/>
                </div> 
                
                 <div class="form-group">
                      <label class="control-label">Numero de telephone :</label>
                      <input type="text" name="numTele" class="form-control" value="${admin.numeroTelephone}"/>
                </div> 
                
                 <div>
                      <button type="submit" class="btn btn-primary">Modifier</button>
                 </div>
          </form>
          </div>
                      

    <script src="backOffice/js/jquery.min.js"></script>
    <script src="backOffice/js/bootstrap.bundle.min.js"></script>
    <script src="backOffice/js/sb-admin-2.min.js"></script>

    <script src="backOffice/js/jquery.dataTables.min.js"></script>
    <script src="backOffice/js/dataTables.bootstrap4.min.js"></script>
    <script src="backOffice/js/datatables-demo.js"></script>
    

</body>
</html>

