$(document).ready(function(){

    $(document).on('click', '#addcard', function(e){
        e.preventDefault();
        $(".cardlistentry").last().after("<tr class=\"form-group cardlistentry\">\n" +
            "                    <td>\n" +
            "                        <div class=\"col-sm-6 offset-sm-2\"><input type=\"number\" class=\"form-control input-sm cardentryqty\" ></div>\n" +
            "                    </td>\n" +
            "                    <td>\n" +
            "                        <div class=\"col-sm-12 \"><input type=\"text\" class=\"form-control input-med cardentryname\" ></div>\n" +
            "                    </td>\n" +
            "                </tr>");
    });
    $('input:submit').on('click', function(e){

        var cardcount = 0;
        $('.cardlistentry').each(function(i,obj){
            cardcount += parseInt($(this).find('.cardentryqty').val());
        })
        sessionStorage.setItem('cardcount', cardcount.toString());
        sessionStorage.setItem('newdeck', $('#deckName').val());
        $('a #decksubmit').click();

    });

});