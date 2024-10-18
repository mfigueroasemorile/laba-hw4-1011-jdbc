package utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import model.Client;

import java.io.File;

public class JAXBParser {

    public <T> void parse (T object){

        try{

            JAXBContext context = JAXBContext.newInstance(object.getClass());

            // marshaller to convert object to XML
            Marshaller marshall = context.createMarshaller();
            marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshall.marshal(object, new File(object.getClass().getSimpleName() + ".xml"));

            System.out.println("Object converted to xml successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /*public <T> T convertFromXML(String fileName, Class<T> clazz) {
        try {
            File file = new File(fileName);

            // Create contect JAXB
            JAXBContext context = JAXBContext.newInstance(clazz);

            // Unmarshaller to convert xml to object
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // read file XML and convert it in object instance
            T object = (T) unmarshaller.unmarshal(file);

            System.out.println("File " + fileName + " has been converted to a " + clazz.getSimpleName() + " object.");
            return object;

        } catch (Exception e) {
            System.out.println("Error while unmarshalling: " + e.getMessage());
            return null;
        }
    }*/
}
