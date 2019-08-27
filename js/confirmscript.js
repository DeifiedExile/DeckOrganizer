$(document).ready(function(){

    var confirmContent = 'New deck \"'+sessionStorage.getItem('newdeckname') + '\" created successfully with ' + sessionStorage.getItem('cardcount') + ' cards added.'
    $('#confirmdiv').html(confirmContent);

})