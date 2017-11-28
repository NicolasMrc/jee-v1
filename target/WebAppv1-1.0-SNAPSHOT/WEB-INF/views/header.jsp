<%-- 
    Document   : header
    Created on : 9 nov. 2017, 14:02:28
    Author     : Nico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="ressources/css/header.css"/>
    <link rel="stylesheet" href="ressources/css/font-awesome.min.css"/>

<nav class="navbar navbar-light bg-light justify-content-between">
  <a class="navbar-brand">
    <img src="ressources/images/logo.png" width="30" height="30" alt="">
    Stages
  </a>
  <form class="form-inline">
    <c:if test="${user != null}">
        <p>Bienvenue <c:out value="${user.firstname}"></c:out> <c:out value="${user.lastname}"></c:out></p>
    <a class="btn btn-danger" href="home?action=logout"><i class="fa fa-power-off" aria-hidden="true"></i> Déconnectez vous</a> <%-- jsp:forward --%>
    </c:if>
  </form>
</nav>