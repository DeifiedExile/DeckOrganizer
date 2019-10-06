package springxml.services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;

import java.io.FileReader;

public class StandardImgService implements ICardImgService {
    private String cardName;

    private String imgUrl = "";
    private String cardID;

    @Override
    public String getImgUrl(String cName){
        System.out.println(cName);


        JSONParser parser = new JSONParser();

        try(FileReader reader = new FileReader("resources/scryfall-oracle-cards.json"))
        {
            Object obj = parser.parse(reader);

            JSONArray cardList = (JSONArray) obj;


            for(Object c : cardList){
                JSONObject card = new JSONObject();
                card = (JSONObject) c;

                if(card.get("name").toString().toUpperCase()
                        .equals(cName.toUpperCase()) )
                {
                    cardID = card.get("multiverse_ids").toString();
                    cardID = cardID.substring(1, cardID.length() - 1);
                    imgUrl = "https://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=" + cardID + "&type=card";
                    return imgUrl;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return imgUrl;
    }



}
