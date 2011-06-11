package org.androidaalto.droidkino.xml.dom;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.androidaalto.droidkino.AreaInfo;
import org.androidaalto.droidkino.xml.BaseFinnkinoAreaParser;
import org.androidaalto.droidkino.xml.BaseFinnkinoParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import org.w3c.dom.Element;

public class FinnkinoAreaDOMParser extends BaseFinnkinoAreaParser {
    @Override
    public List<AreaInfo> parse() {
        List<AreaInfo> areaList = new ArrayList<AreaInfo>();
        
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new InputSource(this.getInputStream()));
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            throw new RuntimeException("unable to retreieve area info", e);
        }
        
        Element area = (Element) ((NodeList)doc.getElementsByTagName("TheatreAreas")).item(0);
        
        NodeList areaNodeList = (NodeList) area.getElementsByTagName("TheatreArea");
        
        int numberOfNodes = areaNodeList.getLength();
        
        AreaInfo areaInfo = null;
        
        for (int i = 0; i < numberOfNodes; i++) {
            Node showNode = areaNodeList.item(i);
            if (showNode.getNodeType() == Node.ELEMENT_NODE) {
                Element areaElement = (Element) showNode;
                areaInfo = new AreaInfo();
                areaInfo.setId(getTagValue(areaElement, ID));
                areaInfo.setName(getTagValue(areaElement, NAME));
                areaList.add(areaInfo);
            }
        }
        return areaList;
    }
    
    private static String getTagValue(Element eElement, String sTag) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);

        return nValue.getNodeValue();
    }
}
