package xsd;

import org.xml.sax.Attributes;
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

    private int indentLevel = 0;

    public void validate(String xsdPath, String xmlPath){

        try {
            // creating SAX parser factory
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();

            parserFactory.setValidating(false); //setting DTD as unable
            parserFactory.setNamespaceAware(true); // enable name spaces
            parserFactory.setSchema(getSchema("src/main/java/xsd/" + xsdPath)); // Charging the xsd

            SAXParser saxParser = parserFactory.newSAXParser();

            // annonymous class to handle errors
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


    public void parse(String xmlPath) {
        try {


            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setNamespaceAware(true);
            SAXParser saxParser = parserFactory.newSAXParser();


            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.print(getIndentation() + "<" + qName);
                    // print attributes
                    for (int i = 0; i < attributes.getLength(); i++) {
                        System.out.print(" " + attributes.getQName(i) + "=\"" + attributes.getValue(i) + "\"");
                    }
                    System.out.println(">");
                    indentLevel++;
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String content = new String(ch, start, length).trim();
                    if (!content.isEmpty()) {
                        System.out.println(getIndentation() + content);
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    indentLevel--;
                    System.out.println(getIndentation() + "</" + qName + ">");
                }
            };

            File xmlFile = new File("src/main/java/xml/" + xmlPath);
            saxParser.parse(xmlFile, handler);

            System.out.println("The file " + xmlPath + " has been parsed successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String getIndentation() {
        return " ".repeat(indentLevel * 2);
    }

    private static Schema getSchema(String schemaPath) throws SAXException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        return schemaFactory.newSchema(new File(schemaPath));
    }
}

