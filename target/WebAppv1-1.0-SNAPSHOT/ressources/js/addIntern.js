/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
   $("input[name='selectedStagiaire']").change(function(){
       
        $("#add").removeClass("btn-light disabled");
        $("#add").addClass("btn-primary");
        
    }); 
    
    $('#add').click(function(){
        var id = $('input[name=selectedStagiaire]:checked').val();
        window.location.href='home?action=addIntern&id=' + id;
    });
});