<%-- 
    Document   : login
    Created on : 9 nov. 2017, 10:12:17
    Author     : Nico
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"  crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" crossorigin="anonymous"></script>
        <script src="ressources/js/login.js"></script>
        <link rel="stylesheet" type="text/css" href="ressources/css/login.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 col-lg-6 offset-lg-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col">
                                    <h1>Connection</h1>  
                                </div>
                            </div>
                            <form method="post" action="home">
                                <input type='hidden' name='action' value='login' />
                                <div class="row">
                                    <div class="col-12">
                                        <c:if test="${error != null}">
                                            <div class="alert alert-danger" role="alert">
                                                <c:out value="${error}"></c:out>
                                                </div>  
                                        </c:if>
                                    </div>
                                    <div class="col-12">
                                        <div class="form-group">
                                            <label for="login">Nom d'utilisateur</label>
                                            <input id="login" type="text" name="login" class="form-control" placeholder="Nom d'utilisateur">
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <div class="form-group">
                                            <label for="passwordField">Mot de passe</label>
                                            <input type="password" class="form-control" id="passwordField" placeholder="Mot de passe" name="password">
                                        </div>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary float-right">Se connecter</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <c:if test="${logout == true}">
            <div class="modal fade" id="logout" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-body">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <p>Au revoir, A bientôt !</p>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </body>
</html>
