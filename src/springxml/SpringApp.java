package springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springxml.beans.Card;

public class SpringApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Card card = context.getBean("myCard", Card.class);

        System.out.println("<div>\n" +
                "    <h3>\n" +
                card.getCardName() +
                "    </h3>\n" +
                "    <div>\n" +
                "        <img src=\"" +
                card.getImage() +
                "\"/>\n" +
                "    </div>\n" +
                "</div>");

        context.close();
    }
}
