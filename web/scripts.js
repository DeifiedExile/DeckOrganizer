$(document).ready(function(){

    // var url = window.location.href;
    // var path = url.substring( 0, url.lastIndexOf( "/" ) + 1);;
        $.ajax({

            url: ('DeckData.csv'),
            dataType:"text",
            success:function(data){
                if("newdeck" in sessionStorage)
                {
                    data += sessionStorage.getItem("newdeck");
                }
                var cards = $.csv.toObjects(data);


                    var deckTableContent = '<table class="table-dark table-striped">';
                    var deckName = "";
                    for (var i = 0; i < cards.length; i++) {
                        if (cards[i].Deck !== deckName) {
                            deckName = cards[i].Deck;
                            deckTableContent += '<tr><td class="decktd"><div class = "selectDeckCard card card-body  shadow-sm text-center"><a href="DeckDetail.html" class="selectDeck">' + deckName + '</a></div></td></tr>';
                        }
                    }
                    deckTableContent += '</table>';
                    $('#divDeckList').html(deckTableContent);




                    var cardTableContent = '<table class="table-dark table-striped">';
                    cardTableContent += '<tr> <th>Deck Type</th> <th>Deck Name</th> <th>Quantity</th> <th>Card Name</th> </tr>'
                    for(var i = 0; i<cards.length; i++)
                    {
                        if(cards[i].Deck === sessionStorage.getItem('DeckName')) {
                            cardTableContent += '<tr>';

                            cardTableContent += '<td>' + cards[i].Type + '</td>';
                            cardTableContent += '<td>' + cards[i].Deck + '</td>';
                            cardTableContent += '<td>' + cards[i].Qty + '</td>';
                            cardTableContent += '<td>' + cards[i].Name + '</td>';

                            cardTableContent += '</tr>';
                        }
                    }
                    cardTableContent += '</table>';

                    $('#divCardList').html(cardTableContent);

            }
        });

        $(document).on('click', '.selectDeck', function(e){
            sessionStorage.setItem('DeckName', this.text);
            console.log($(this).text);
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

});



