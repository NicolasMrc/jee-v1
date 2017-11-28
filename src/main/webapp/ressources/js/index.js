/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(document).ready(function(){
   $("input[name='selectedStagiaire']").change(function(){
        $("#edit").removeClass("btn-light disabled");
        $("#edit").addClass("btn-warning");
    }); 
});