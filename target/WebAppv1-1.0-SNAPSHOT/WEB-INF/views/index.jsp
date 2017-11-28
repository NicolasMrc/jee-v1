<%-- 
    Document   : index
    Created on : 9 nov. 2017, 10:15:49
    Author     : Nico
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bonjour</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
        
        <script src="ressources/js/index.js"></script>
        <link rel="stylesheet" href="ressources/css/index.css"/>
    </head>

    <body>
        <%@include file="header.jsp"%>
        <div class="container-fluid">
            <div class="row">
                <div class="col">
                    <h1 class="stagiaires-title text-center">Vos Stagiaires</h1>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <c:choose>
                        <c:when test="${stagiaires.size() == 0}">
                            <div class="alert alert-primary" role="alert">
                                Aucun stagiaire ne vous a été affecté! Contactez le service des stages.
                            </div>
                        </c:when>
                        <c:when test="${stagiaires.size() > 0}">
                            <form action="stagiaire">
                                <input type="hidden" name="action" value="null"/>
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th scope="col"><p class="small-td">Selection</p></th>
                                        <th scope="col"><p class="small-td">Groupe</p></th>
                                        <th scope="col"><p class="small-td">Nom</p></th>
                                        <th scope="col"><p class="small-td">Fiche visite</p></th>
                                        <th scope="col"><p class="small-td">Fiche eval entr</p></th>
                                        <th scope="col"><p class="small-td">Sondage web</p></th>
                                        <th scope="col"><p class="small-td">Rapport rendu</p></th>
                                        <th scope="col"><p class="small-td">Soutenance</p></th>
                                        <th scope="col"><p class="small-td">Viste planif</p></th>
                                        <th scope="col"><p class="small-td">Visite Faite</p></th>
                                        <th scope="col"><p class="small-td">Début</p></th>
                                        <th scope="col"><p class="small-td">Fin</p></th>
                                        <th scope="col"><p class="small-td">Entreprise</p></th>
                                        <th scope="col"><p class="small-td">Maitre de stage</p></th>
                                        <th scope="col"><p class="small-td">Adresse</p></th>
                                        
                                        <th scope="col"><p class="small-td">Note Tech</p></th>
                                        <th scope="col"><p class="small-td">Note Com</p></th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                    <c:forEach items="${stagiaires}" var="stagiaire">
                                        <tr>
                                            <td class="text-center"><input class="form-check-input" type="radio" name="selectedStagiaire" value="${stagiaire.id}"></td>
                                            <td><c:out value="${stagiaire.groupe}"></c:out></td>
                                            <td><c:out value="${stagiaire.lastname}"></c:out></td>
                                            <c:choose>
                                                <c:when test="${stagiaire.ficheVisite}">
                                                    <td class="green"></td>
                                                </c:when>
                                                <c:when test="${!stagiaire.ficheVisite}">
                                                    <td class="red"></td>
                                                </c:when>
                                            </c:choose>
                                            <c:choose>
                                                <c:when test="${stagiaire.ficheEvalEntr}">
                                                    <td class="green"></td>
                                                </c:when>
                                                <c:when test="${!stagiaire.ficheEvalEntr}">
                                                    <td class="red"></td>
                                                </c:when>
                                            </c:choose>
                                            <c:choose>
                                                <c:when test="${stagiaire.sondageWeb}">
                                                    <td class="green"></td>
                                                </c:when>
                                                <c:when test="${!stagiaire.sondageWeb}">
                                                    <td class="red"></td>
                                                </c:when>
                                            </c:choose>
                                            <c:choose>
                                                <c:when test="${stagiaire.rapportRendu}">
                                                    <td class="green"></td>
                                                </c:when>
                                                <c:when test="${!stagiaire.rapportRendu}">
                                                    <td class="red"></td>
                                                </c:when>
                                            </c:choose>


                                            <c:choose>
                                                <c:when test="${stagiaire.soutenance}">
                                                    <td class="green"></td>
                                                </c:when>
                                                <c:when test="${!stagiaire.soutenance}">
                                                    <td class="red"></td>
                                                </c:when>
                                            </c:choose>


                                            <c:choose>
                                                <c:when test="${stagiaire.visitePlanif}">
                                                    <td class="green"></td>
                                                </c:when>
                                                <c:when test="${!stagiaire.visitePlanif}">
                                                    <td class="red"></td>
                                                </c:when>
                                            </c:choose>


                                            <c:choose>
                                                <c:when test="${stagiaire.visiteFaite}">
                                                    <td class="green"></td>
                                                </c:when>
                                                <c:when test="${!stagiaire.visiteFaite}">
                                                    <td class="red"></td>
                                                </c:when>
                                            </c:choose>

                                            <td class="text-center"><c:out value="${stagiaire.debut}"></c:out></td>
                                            <td class="text-center"><c:out value="${stagiaire.fin}"></c:out></td>
                                            <td class="text-center"><c:out value="${stagiaire.entreprise}"></c:out></td>
                                            <td class="text-center"><c:out value="${stagiaire.maitreStage}"></c:out></td>
                                            <td class="text-center"><c:out value="${stagiaire.adresse}"></c:out></td>
                                            
                                            <td class="text-center"><c:out value="${stagiaire.noteTech}"></c:out></td>
                                            <td class="text-center"><c:out value="${stagiaire.noteCom}"></c:out></td>
                                            </tr>
                                    </c:forEach>  
                                    
                                </tbody>
                            </table>
                            </form>
                            
                            <a class="btn btn-info float-right" id="add" href="home?action=addIntern"><i class="fa fa-plus-circle" aria-hidden="true"></i> Ajouter</a>
                            <a class="disabled btn btn-light float-right" id="edit"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Editer</a>
                            <a class="btn btn-primary float-right" id="validate"><i class="fa fa-floppy-o" aria-hidden="true"></i> Valider</a>
                            
                        </c:when>
                    </c:choose>


                </div>
            </div>
        </div>
    </body>
</html>
