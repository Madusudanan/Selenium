import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class XMLDataManager {
	
	public static HashMap<String, String> RetrieveDataFromXML(String XmlFilePath,String RootNode,String IdNode,String...data ) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException, XPathExpressionException{
		//The XML File
		File xmlInput = new File(XmlFilePath);
		//XPath
		XPath xPath =  XPathFactory.newInstance().newXPath();
		//Result HashMap
		HashMap<String, String> resultMap = new HashMap<String,String>();
		//Parser
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		builder = builderFactory.newDocumentBuilder();
		//XML Document Parsed using parser
		Document document = builder.parse(new FileInputStream(xmlInput));
		//Getting the request data
		String req_data [] = data;
		for(int index=0;index<req_data.length;index++){
			//Construction of the query
			String xpathQuery = "//" + RootNode + "[@id='" + IdNode + "']/" + req_data[index]; 
			resultMap.put(req_data[index],  xPath.compile(xpathQuery).evaluate(document));
		}
		return resultMap;
		
	}

}
