import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class XMLNode {

    //name: String +get +set

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //attributes: Map<String, String>

    private Map<String, String> attributes = new HashMap<>();


    //text: String +get +set

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //subNodes: List<XMLNode> +get

    private List<XMLNode> subNodes = new LinkedList<>();

    public List<XMLNode> getSubNodes() {
        return subNodes;
    }


    public XMLNode(String name) {
        this.name = name;
    }

    public void addNode(XMLNode node){
        subNodes.add(node);
    }

    public XMLNode getNode(int index){
        return subNodes.get(index);
    }

    public boolean containsSubNodes(){
        return (subNodes.size()!=0);
    }

    public String getAttribute(String name) {
        return attributes.get(name);
    }

    public void setAttribute(String name, String value) {
        attributes.put(name, value);
    }

    public String printAttributes(){
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<String,String> entry : attributes.entrySet()){
            builder.append(" "+ entry.getKey() + "=\"" + entry.getValue() + "\"");
        }
        return builder.toString();
    }
}
