public class Driver {
    public static void main(String[] args) {
        XMLNode point = new XMLNode("point");
        point.setAttribute("id", "100");


        XMLNode x = new XMLNode("x");
        x.setText("3");
        point.addNode(x);
        XMLNode y = new XMLNode("y");
        y.setText("4");
        point.addNode(y);
        XML xml = new XML();
        String xmlString = xml.formXml(point);
        System.out.println(xmlString);
        xmlString = xml.fromXmlWithPrettyPrinting(point);
        System.out.println(xmlString);
    }
}
