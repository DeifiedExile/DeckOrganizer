package springxml.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class LargeImgService implements ICardImgService {
    private String cardName;

    private String imgUrl = "";


    @Override
    public String getImgUrl(String cName){


        JSONParser parser = new JSONParser();

        try(FileReader reader = new FileReader("resources/scryfall-oracle-cards.json"))
        {
            Object obj = parser.parse(reader);

            JSONArray cardList = (JSONArray) obj;

            for(Object c : cardList){
                JSONObject card = new JSONObject();
                card = (JSONObject) c;
                if((card.get("name").toString().toUpperCase()).equals(cName.toUpperCase()) )
                {
                    JSONObject cardImgs = (JSONObject)card.get("image_uris");
                    imgUrl = cardImgs.get("large").toString();
                    return imgUrl;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return imgUrl;
    }
}
