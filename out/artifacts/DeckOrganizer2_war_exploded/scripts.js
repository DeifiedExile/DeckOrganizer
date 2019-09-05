$(document).ready(function(){

    // var url = window.location.href;
    // var path = url.substring( 0, url.lastIndexOf( "/" ) + 1);;
        $.ajax({

            url: ('DeckData.csv'),
            dataType:"text",
            success:function(data){
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

});



