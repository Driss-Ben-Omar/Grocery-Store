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
    height: 510px;
    }
    </style>
</head>
<body class="bg-gradient-primary">
<div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block" id="id" style="background-image: url('frontOffice/images/background7.gif');"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Bienvenu</h1>
                                    </div>
                                    <form action='login' method=post class="user">
                                        <div class="form-group">
                                            <input type="email" name='email' class="form-control form-control-user" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Entrer l'adresse e-mail...">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="passWord" class="form-control form-control-user" id="exampleInputPassword" placeholder="mot de passe">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">M�moriser info</label>
                                            </div>
                                        </div>
                                        <button type='submit' class="btn btn-primary btn-user btn-block">Connexion</button>
                                  
                                      
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="forgot-password.html">Mot de passe oubli�?</a>
                                    </div>
                                    <div></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>


</body>
</html>