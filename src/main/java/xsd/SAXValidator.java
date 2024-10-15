package xsd;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class SAXValidator {

    public void validate(String xsdPath, String xmlPath){

        try {
            // 1. creating SAX parser factory
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();

            parserFactory.setValidating(false); //
            parserFactory.setNamespaceAware(true); // enable name spaces
            parserFactory.setSchema(getSchema("src/main/java/xsd/" + xsdPath)); // Charging the xsd

            SAXParser saxParser = parserFactory.newSAXParser();

            // handler to get errors
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void error(SAXParseException e) throws SAXException {
                    System.out.println("Error: " + e.getMessage());
                    throw e;
                }

                @Override
                public void fatalError(SAXParseException e) throws SAXException {
                    System.out.println("Fatal error: " + e.getMessage());
                    throw e;
                }

                @Override
                public void warning(SAXParseException e) throws SAXException {
                    System.out.println("Warning: " + e.getMessage());
                }
            };

            //Validate XML
            File xmlFile = new File("src/main/java/xml/" + xmlPath);
            saxParser.parse(xmlFile, handler);

            System.out.println("The file "+xmlPath+" is valid");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Schema getSchema(String schemaPath) throws SAXException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        return schemaFactory.newSchema(new File(schemaPath));
    }
}

