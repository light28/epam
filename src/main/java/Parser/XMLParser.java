package Parser;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

import Model.*;


public class XMLParser {
    private Document document;
    private String XMLPath = "src\\main\\resources\\users.xml";

    public XMLParser() {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = documentBuilder.parse(XMLPath);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users_info = new ArrayList<User>();
        User userTmp = new User();

        Node root = document.getDocumentElement();
        NodeList users = root.getChildNodes();
        for(int i = 0; i < users.getLength(); i++) {
            Node user = users.item(i);
            if(user.getNodeType() != Node.TEXT_NODE) {
                NodeList userProps = user.getChildNodes();
                for(int j = 0; j < userProps.getLength(); j++) {
                    Node userProp = userProps.item(j);
                    if(userProp.getNodeType() != Node.TEXT_NODE) {
                        if(j == 1) {
                            userTmp.login = userProp.getTextContent();
                        }
                        if(j != 0) {
                            userTmp.password = userProp.getTextContent();
                        }
                    }
                }
                users_info.add(userTmp);
            }
        }
        return users_info;
    }


}
