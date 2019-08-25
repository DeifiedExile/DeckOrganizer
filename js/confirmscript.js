$(document).ready(function(){

    var confirmContent = 'New deck \"'+sessionStorage.getItem('newdeck') + '\" created successfully with ' + sessionStorage.getItem('cardcount') + ' cards added.'
    $('#confirmdiv').html(confirmContent);
})