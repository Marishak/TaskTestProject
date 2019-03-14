
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.SAXException;

public class Main {
    public static void main(String[] args) throws SAXException, IOException {
        String schemaLocation = "shapes.xsd";
        //проверка на соответствие xsd
        if (xmlCorrespondsToScheme(schemaLocation, new FileInputStream(args[0]))) {
            //создание мапы фигур
            Map<Integer, Shape> shapeList = createShapeList(new FileInputStream(args[0]));
            for (Map.Entry<Integer, Shape> shape : shapeList.entrySet()) {
                System.out.println(shape.getKey() + ": " + shape.getValue().getColor() + " - " + shape.getValue().getArea());
            }

        }
    }

    private static boolean xmlCorrespondsToScheme(String shema, InputStream filexml) throws SAXException, IOException{
        // поиск и создание экземпляра фабрики для языка XML Schema
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        // компиляция схемы
        Schema schema = factory.newSchema(Main.class.getResource(shema));
        // создание валидатора для схемы
        Validator validator = schema.newValidator();
        // разбор проверяемого документа
        Source source = new StreamSource(filexml);
        // валидация документа
        try {
            validator.validate(source);
            return true;
        }
        catch (SAXException ex) {
            System.out.println(shema + " is not valid because ");
            System.out.println(ex.getMessage());
            return false;

        }
    }

    private static Map<Integer, Shape> createShapeList(InputStream fileXML) throws IOException {
        Map<Integer, Shape> shapeMap = new HashMap<Integer, Shape>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileXML));
        int count = 0;
        //паттерн для нахождения тегов
        Pattern pattern = Pattern.compile("(\\<(/?[^>]+)>)");
        List<String> parametersList = new ArrayList<String>();

        while (reader.ready()) {
            String color;
            String string = reader.readLine();

            //TRIANGLE
            if (string.contains("triangle")) {
                parametersList.clear();
                count++;
                string = reader.readLine();
                while (!string.contains("/triangle")) {
                    parametersList.add(string);
                    string = reader.readLine();
                }
                parametersList.removeAll(Arrays.asList("", null, " "));
                color = parametersList.get(0).replaceAll(pattern.pattern(), "");
                float side1 = Float.parseFloat(parametersList.get(1).replaceAll(pattern.pattern(), ""));
                float side2 = Float.parseFloat(parametersList.get(2).replaceAll(pattern.pattern(), ""));
                float side3 = Float.parseFloat(parametersList.get(3).replaceAll(pattern.pattern(), ""));

                try {
                    Shape shape = Triangle.of(color, side1, side2, side3);
                    shapeMap.put(count, shape);
                } catch (IllegalArgumentException e) {
                    System.out.println("Shape triangle №" + count + ". The parameters for the triangle are incorrect.");
                }

            //SQUARE
            } else if (string.contains("square")) {
                parametersList.clear();
                count++;
                string = reader.readLine();
                while (!string.contains("/square")) {
                    parametersList.add(string);
                    string = reader.readLine();
                }
                parametersList.removeAll(Arrays.asList("", null, " "));
                color = parametersList.get(0).replaceAll(pattern.pattern(), "");
                float side1 = Float.parseFloat(parametersList.get(1).replaceAll(pattern.pattern(), ""));

                try {
                    Shape shape = Square.of(color, side1);
                    shapeMap.put(count, shape);
                } catch (IllegalArgumentException e) {
                    System.out.println("Shape square №" + count + ". The parameters for the square are incorrect.");
                }


            //RECTANGLE
            } else if (string.contains("rectangle")) {
                parametersList.clear();
                count++;
                string = reader.readLine();
                while (!string.contains("/rectangle")) {
                    parametersList.add(string);
                    string = reader.readLine();
                }
                parametersList.removeAll(Arrays.asList("", null, " "));
                color = parametersList.get(0).replaceAll(pattern.pattern(), "");
                float side1 = Float.parseFloat(parametersList.get(1).replaceAll(pattern.pattern(), ""));
                float side2 = Float.parseFloat(parametersList.get(2).replaceAll(pattern.pattern(), ""));

                try {
                    Shape shape = Rectangle.of(color, side1, side2);
                    shapeMap.put(count, shape);
                } catch (IllegalArgumentException e){
                    System.out.println("Shape rectangle №" + count + ". The parameters for the rectangle are incorrect.");
                }


            //CIRCLE
            } else if (string.contains("circle")) {
                parametersList.clear();
                count++;
                string = reader.readLine();
                while (!string.contains("/circle")) {
                    parametersList.add(string);
                    string = reader.readLine();
                }
                parametersList.removeAll(Arrays.asList("", null, " "));
                color = parametersList.get(0).replaceAll(pattern.pattern(), "");
                float diameter = Float.parseFloat(parametersList.get(1).replaceAll(pattern.pattern(), ""));

                try {
                    Shape shape = Circle.of(color, diameter);
                    shapeMap.put(count, shape);
                } catch (IllegalArgumentException e) {
                    System.out.println("Shape circle №" + count + ". The parameters for the circle are incorrect.");
                }

            }
        }

        return shapeMap;
    }
}
