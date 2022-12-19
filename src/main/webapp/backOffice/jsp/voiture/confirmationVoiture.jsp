<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
      <title>Confirmation</title>
      <link href="backOffice/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
   </head>

 <body>
     <%@include file="../aside.jsp" %>


      
               
           <div id="content">
              <div class="container-fluid">
              <div class="card">
               <div class="card-header">
                    Confirmation voiture
               </div>
                 <div class="card-body">
                    <label class="control-label">Matricule :</label>
                    <input type="text" name="matricule" class="form-control" value="${voiture.matricule }"/>

                    <label class="control-label">Marque :</label>
                    <input type="text" name="marque" class="form-control" value="${voiture.marque }"/>
              
                </div>
              </div>
                    </div></div>


  

 </body>
</html>