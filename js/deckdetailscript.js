$(document).ready(function(){
    $(document).attr('title', sessionStorage.getItem('DeckName'));
    $.ajax({
        url:"DeckData.csv",
        dataType:"text",
        success:function(data){
            if("newdeck" in sessionStorage)
            {
                data += sessionStorage.getItem("newdeck");
            }
            var cards = $.csv.toObjects(data);

            var tableContent = '<table class="table-dark table-striped">';
            tableContent += '<tr> <th>Deck Type</th> <th>Deck Name</th> <th>Quantity</th> <th>Card Name</th> </tr>'
            for(var i = 0; i<cards.length; i++)
            {
                if(cards[i].Deck === sessionStorage.getItem('DeckName')) {
                    tableContent += '<tr>';

                    tableContent += '<td>' + cards[i].Type + '</td>';
                    tableContent += '<td>' + cards[i].Deck + '</td>';
                    tableContent += '<td>' + cards[i].Qty + '</td>';
                    tableContent += '<td>' + cards[i].Name + '</td>';

                    tableContent += '</tr>';
                }
            }
            tableContent += '</table>';

            $('#tablespace').html(tableContent);
        }

    })

});