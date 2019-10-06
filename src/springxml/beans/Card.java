package springxml.beans;

import springxml.services.ICardImgService;

public class Card {

    private String cardName;
    private ICardImgService imgService;

    public Card() {
    }

    public Card(ICardImgService imgService) {
        this.imgService = imgService;
    }

    public void setImgService(ICardImgService imgService) {
        this.imgService = imgService;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getImage()
    {
        if(!cardName.isEmpty()){
            return imgService.getImgUrl(this.cardName);
        }else{
            return "";
        }

    }
}
