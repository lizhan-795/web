package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lz
 * @data 2019-08-20
 * @comment 描述
 */
public class XmlUtil {
    private XmlUtil(){}


    public static XmlUtil getInstance(String path){
        if(path != null ){
            PATH=path;
        }
        return Holder.instance;
    }
    private static class Holder{
        private static XmlUtil instance = new XmlUtil();
    }

    private static String PATH;
    public <T> List<T> readXml(Class<T> tClass) throws Exception{
        List<T> list = new ArrayList<>();
        Document document = getDocument();
        Element rootElement = document.getRootElement();
        //得到根节点
        List<Element> elements = rootElement.elements();
        //得到所有的food节点
        for (Element t : elements) {
            T t1 = tClass.newInstance();
            //通过反射，通过无参构造方法实例化T的对象
            List<Element> elements1 = t.elements();
            //得到每个food节点的子节点
            for (Element element : elements1) {
                String name = element.getName();
                //得到节点名，name，price，count，date
                //通过内省机制为属性赋值
                BeanInfo info = Introspector.getBeanInfo(tClass);
                //得到所有属性的描述，通过PropertyDescriptor对象的getName() 得到每个属性的名称
                PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors();
                for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                    //setName ,setPrice,setCount,setDate
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    //调用属性的封装方法 setXXX方法
                    if (propertyDescriptor.getName().equals(name)) {
                        String fieldName = propertyDescriptor.getName();
                        //得到属性名
                        Class<?> type = tClass.getDeclaredField(fieldName).getType();
                        //获取属性的类型
                        Object convert = StringUtil.convert(type, element.getText());
                        //将字符串格式的xml的节点文本转换为对应的java类型的值
                        writeMethod.invoke(t1,convert);
                    }
                }
            }
            list.add(t1);
        }
        return  list;
    }

    public Document getDocument(){
        SAXReader reader = new SAXReader();
        try {
            return reader.read(new File(PATH));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> void writeXml(List<T> list){
        File file=new File(PATH);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SAXReader reader=new SAXReader();
        Document document= null;
        try {
            document=reader.read(file);
        } catch (DocumentException e) {
            document=createDocument();
            document.addElement("root");
        }
        Element rootElement = document.getRootElement();
        for (T t : list) {
            String name = t.getClass().getName();
            String element_name = name.substring((name.lastIndexOf(".")) + 1).toLowerCase();
            Element element = rootElement.addElement(element_name);
            try {
                BeanInfo beanInfo=Introspector.getBeanInfo(t.getClass());
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                    String name1 = propertyDescriptor.getName();
                    if(name1.equalsIgnoreCase("class")){
                            continue;
                    }
                    Element element1 = element.addElement(name1);
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Object invoke = readMethod.invoke(t);
                    String s = StringUtil.convertObj2String(invoke);
                    element1.setText(s);
                }
            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        writeDocument(document);
    }

    public Document createDocument(){
        Document document= DocumentHelper.createDocument();
        document.setXMLEncoding("utf-8");
        return document;
    }

    public void writeDocument(Document document){
        try {
            FileWriter fileWriter = new FileWriter(PATH);
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(fileWriter, format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
