$(document).ready(function(){

    $(document).on('click', '#addcard', function(e){
        e.preventDefault();
        $(".cardlistentry").last().after("<tr class=\"form-group cardlistentry\">\n" +
            "                    <td>\n" +
            "                        <div class=\"col-sm-6 offset-sm-2\"><input type=\"number\" class=\"form-control input-sm cardentry\" ></div>\n" +
            "                    </td>\n" +
            "                    <td>\n" +
            "                        <div class=\"col-sm-12 \"><input type=\"text\" class=\"form-control input-med cardentry\" ></div>\n" +
            "                    </td>\n" +
            "                </tr>");
    });
    $('input:submit').on('click', function(e){
        e.preventDefault();
        //this cant be implemented on client side afaik
    })

});