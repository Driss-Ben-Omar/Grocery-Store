<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="driss benomar & mouad benthami">
    <title>Login</title>
    <link href="frontOffice/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <link href="frontOffice/css/sb-admin-2.min.css" rel="stylesheet">
    <style type="text/css">
    .row
    {
    height: 500px;
    }
    </style>
</head>
<body style="background-color:#82AE46;">
<script>
window.onload = function () {

    function changeImage() {   
        var BackgroundImg=["frontOffice/images/background3.gif",
            "frontOffice/images/background4.gif",
            "frontOffice/images/background5.gif",
            "frontOffice/images/background6.gif"
        ];
        var i = Math.floor((Math.random() * 4));
        document.getElementById('id').style.backgroundImage = 'url("' + BackgroundImg[i] + '")';
    }
    window.setInterval(changeImage, 3000);
}

</script>

<div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block" id="id" style="background-image: url('frontOffice/images/background3.gif');"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Bienvenu</h1>
                                    </div>
                                    <form class="user"	action="Connexion" method="post">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                               name="email" aria-describedby="emailHelp"
                                                placeholder="Entrer l'adresse e-mail..." value="${clients.getEmail()}">
                                        </div>
                                        <div class="form-group">
                                                <input type="password" class="form-control form-control-user"
                                                name="password" placeholder="mot de passe" value="${clients.getPassword()}" >
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Mémoriser info</label>
                                            </div>
                                        </div>
                                         <input type="submit" class="btn btn-primary btn-user btn-block">
                                          
                                      
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="registre.co">Créer un compte</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

 
   <!--  <script src="frontOffice/js/jquery.min.js"></script>
    <script src="frontOffice/js/bootstrap.bundle.min.js"></script>


    <script src="frontOffice/js/jquery.easing.min.js"></script>

    <script src="frontOffice/js/sb-admin-2.min.js"></script>  -->

</body>
</html>