<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Voyage</title>
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

    
        <!-- Content Wrapper -->
        <div id="content" >

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
 
                       
                               
                    
                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

    
                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${liv.nomComplet}</span>
                                <img class="img-profile rounded-circle" src="backOffice/jsp/profile.png">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                             
                                 
                                
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
                <div class="container">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Voyage</h1>
                    </div>

                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">les Voyages</h6>  
                        </div>
                        <div class="card-body ">
                            <div class="table-responsive">
                                <table class="table" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                             <th>Marque</th><th>Matricule</th><th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                         <c:forEach items="${model.taches}" var="t">
                                <tr>
                                  <td>${t.marque }</td>
                                  <td>${t.matricule }</td>
                                    <td>
                       					<a href="commandesinTache.lo?id=${t.id }"><button type="button" class="btn btn-primary">Commandes</button></a>
                                  </td>
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

 
    <!-- End of Page Wrapper -->

    

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
                    <a class="btn btn-primary" href="logout.lo">Déconnexion</a>
                </div>
            </div>
        </div>
    </div>
    
 
   
                      

    <script src="backOffice/js/jquery.min.js"></script>
    <script src="backOffice/js/bootstrap.bundle.min.js"></script>
    <script src="backOffice/js/sb-admin-2.min.js"></script>

    <script src="backOffice/js/jquery.dataTables.min.js"></script>
    <script src="backOffice/js/dataTables.bootstrap4.min.js"></script>
    <script src="backOffice/js/datatables-demo.js"></script>
    

</body>
</html>

