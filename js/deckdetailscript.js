$(document).ready(function(){
    $(document).attr('title', sessionStorage.getItem('DeckName'));
    $.ajax({
        url:"DeckData.csv",
        dataType:"text",
        success:function(data){
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

            // var cardData = data.split(/\r?\n|\r/);
            // var tableContent = '<table class="table-dark table-striped">';
            // for(var i = 0; i<cardData.length; i++)
            // {
            //     var cardDetail = cardData[i].split(/,(?![^"]*"(?:(?:[^"]*"){2})*[^"]*$)/);
            //     tableContent += '<tr>';
            //     for(var cellCount = 0; cellCount<cardDetail.length; cellCount++)
            //     {
            //         if(i === 0)
            //         {
            //             tableContent += '<th>'+cardDetail[cellCount]+'</th>';
            //         }
            //         else
            //         {
            //             if(cardDetail[1] === sessionStorage.getItem('DeckName')) {
            //                 tableContent += '<td>';
            //                 if (cardDetail[cellCount].charAt(0) === '\"') {
            //                     var tempCard = cardDetail[cellCount].slice(1, cardDetail[cellCount].length - 1);
            //                     tableContent += tempCard + '</td>';
            //                 } else {
            //                     tableContent += cardDetail[cellCount] + '</td>';
            //                 }
            //             }
            //
            //         }
            //     }
            //     tableContent += '</tr>';
            // }
            // tableContent += '</table>';
            $('#tablespace').html(tableContent);
        }

    })


    // sessionStorage.setItem('a', cards[1]);
    // var tableContent = "<table>";
    // $.each(cards, function(index, value){
    //     console.log('text2');
    //    if(this.deck.equals(sessionStorage.getItem('DeckName')))
    //    {
    //        var row = "<tr>";
    //        var col = "<td>" + value.Deck + "</td>";// $('<td>').text(this.Deck);
    //        col.append("<td>" + this.Qty + "</td>");
    //        col.append("<td>" + this.Name + "</td>");
    //        row.append(col + "</tr>");
    //        tableContent.append(row + "</table>");
    //    }
    // });
    //
    // $('#tablespace').append(tableContent);


});