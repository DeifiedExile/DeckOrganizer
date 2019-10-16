$(document).ready(function(){




    $('#navSearchSubmit').on('click', function(e){
        if(!$('#navSearchText').val.length > 0){
            e.preventDefault();
            e.stopPropagation();
            $('#searchCollapse').collapse('show');
            $('#navSearchText').css('border', 'red');


        }
    })

    $(document).on('mousedown', '.selectDeck', function(e){
        sessionStorage.setItem('deckName', $(this).innerHTML);
        console.log($(this).innerHTML);
    });

        //add new card entry form line
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

    //submit new deck
    $('input:submit').on('click', function(e){

        var cardcount = 0;
        if( typeof deckcsv === 'undefined' || deckcsv === null) {
            var deckcsv = "";
        }
        else
        {
            var deckcsv = sessionStorage.getItem("newdeck");
        }

        $('.cardlistentry').each(function(i,obj){
            deckcsv += 'Commander,';
            deckcsv += $('#deckName').val();
            deckcsv += ',' + parseInt($(this).find('.cardentryqty').val()) + ',' + $(this).find('.cardentryname').val() + '\n';

            cardcount += parseInt($(this).find('.cardentryqty').val());
        })
        sessionStorage.setItem('cardcount', cardcount.toString());
        sessionStorage.setItem('newdeckname', $('#deckName').val());
        sessionStorage.setItem('newdeck', deckcsv);
        $('a #decksubmit').click();

    });

    //confirmation script

    $('#confirmdiv').html('New deck \"'+sessionStorage.getItem('newdeckname') + '\" created successfully with ' + sessionStorage.getItem('cardcount') + ' cards added.');

    // //card api call
    // var mtg = require('mtgsdk')
    //
    // mtg.card.where({name: '"Archangel Avacyn"'})
    //     .then(results => {
    //     console.log(results)
    // })

});





