package com.comb.util;

import com.comb.model.Application;
import com.comb.model.Envirment;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class XmlUtil {

    public static List<Envirment> readApplicationXml() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/main/resources/localMap.xml"));
        Element root = document.getRootElement();
        List<Element> list = root.elements("envir");
        List<Envirment> envirments = new ArrayList<>(list.size() + 1);
        for (int i = 0; i < list.size(); i++) {
            Element envirmentElement = list.get(i);
            Envirment envirment = new Envirment();
            envirment.setEnvirName(envirmentElement.elementText("envirName"));
            envirment.setIntroduction(envirmentElement.elementText("introduction"));
            Element appElements = envirmentElement.element("applications");
            List<Element> applications = appElements.elements("application");
            LinkedList<Application> applicationLinkedList = new LinkedList<>();
            for (int j = 0; j < applications.size(); j++) {
                Element appElement = applications.get(j);
                Application application = new Application(appElement.elementText("appName"), appElement.elementText("appUrl"), appElement.elementText("introduction"));
                applicationLinkedList.add(application);
            }
            envirment.setApplications(applicationLinkedList);
            envirments.add(envirment);
        }
        return envirments;
    }


}
