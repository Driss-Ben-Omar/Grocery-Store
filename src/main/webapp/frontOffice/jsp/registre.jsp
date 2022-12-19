<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sign up</title>

    <!-- Custom fonts for this template-->
    <link href="frontOffice/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="frontOffice/css/sb-admin-2.min.css" rel="stylesheet">
   
</head>
<body style="background-color:#82AE46;">
<script>
window.onload = function () 
{

    function changeImage() {   
        var BackgroundImg=["frontOffice/jsp/background3.gif",
            "frontOffice/images/background4.gif",
            "frontOffice/images/background5.gif",
            "frontOffice/images/background6.gif"
        ];
        var i = Math.floor((Math.random() * 4));
        document.getElementById('id').style.backgroundImage = 'url("' + BackgroundImg[i] + '")';
    }
    window.setInterval(changeImage, 3000);
}

//style="background-image: url('frontOffice/jsp/background3.gif');
</script>
    <div class="container">
        
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div id='id' class="col-lg-5 d-none d-lg-block "  style="background-image: url('frontOffice/images/background3.gif');background-repeat: no-repeat;" >
                    <!--  <img class="img-fluid 3rem " style="width:auto;height:auto;"â€ alt="llll" src="frontOffice/jsp/backgroud.jpg">-->
                    </div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Créer un compte!</h1>
                            </div>
                            <form class="user" action="Registre" method="post">
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="nomComplet" placeholder="Nom Complet">
                                </div>
                                <div class="form-group row">
                                   <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" name="telephone" placeholder="Telephone">
                                    </div>
                                     <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" name="dateNaissance" placeholder="Date Naissance">
                                    </div>
                                 </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" name="email" placeholder="Adresse e-mail">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="adresse" placeholder="Addresse">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user" name="Password" placeholder="mot de passe">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user" name="repeatPassword" placeholder="Répéter le mot de passe">
                                    </div>
                                </div>
                                <input type="submit" class="btn btn-primary btn-user btn-block">
                             
                            </form>
                            <hr>
                           
                            <div class="text-center">
                                <a class="small" href="login.co">Vous avez déjà un compte? Connexion!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    
<!--     <script type="text/javascript">
    var status =document.getElemnetId("status").value;
    if(status=="failed")
    	{
    		swal("soory","password is failed","failed");
    	}
    
    </script> 
    -->
</body>
</html>