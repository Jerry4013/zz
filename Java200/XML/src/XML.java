public class XML {

    public String formXml(XMLNode node){
        String xmlString = "<" + node.getName() + node.printAttributes() + ">";
        if(node.containsSubNodes()){
            for (XMLNode subnode: node.getSubNodes())
                xmlString += formXml(subnode);
        }else
            xmlString += node.getText();
        xmlString += "</" + node.getName() + ">";
        return  xmlString;
    }

    public String fromXmlWithPrettyPrinting(XMLNode node){
        String xmlString = "<" + node.getName() + node.printAttributes() + ">";
        if(node.containsSubNodes()){
            for (XMLNode subnode: node.getSubNodes())
                xmlString += "\n  " + fromXmlWithPrettyPrinting(subnode);
            xmlString += "\n";
        }else
            xmlString += node.getText();
        xmlString += "</" + node.getName() + ">";
        return  xmlString;
    }

    public XMLNode toXml(String string){
        XMLNode aNode = new XMLNode("aNode");

        return aNode;
    }
}
