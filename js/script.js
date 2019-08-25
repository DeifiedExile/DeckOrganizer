$(document).ready(function(){
    $.ajax({
        url: "DeckData.csv",
        dataType: "text",
        success: function (data) {
            var cards = $.csv.toObjects(data);
            var tableContent = '<table class="table-dark table-striped">';
            var deckName = "";
            for (var i = 0; i < cards.length; i++) {
                if (cards[i].Deck !== deckName) {
                    deckName = cards[i].Deck;
                    tableContent += '<tr><td><a href="DeckDetail.html" class="selectDeck">' + deckName + '</a></td></tr>';

                }

            }
            tableContent += '</table>';
            $('#deckList').html(tableContent);
        }
    });
    $(document).on('click', 'a', function(e){


        //var name = this.text;
        sessionStorage.setItem('DeckName', this.text );
    });

});