package DecisionTree.datastructure;


import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * Created by rahulravindran on 19/03/16.
 */
public class DecisionTree {

    private DecisionTreeNode root;

    private Gson gson = new GsonBuilder().create();

    private String jsonFile =
            "/Users/rahulravindran/IdeaProjects/FileTypeDetection/src/main/java/DecisionTree/dtjson.json";

    public void buildTree(JsonObject node) {
        root = insertHelper(root, node);
        System.out.println(root.getLeft().getRight().getId());
    }

    public String getLabel(String rule) {
        return rule.split("<=")[0].trim();
    }

    public float getCriterion(String rule) {
        return Float.parseFloat(rule.split("<=")[1].trim());
    }

    public DecisionTreeNode insertHelper(DecisionTreeNode node, JsonObject jsonNode) {

        //check if node is null
        if(node == null) {
            if(jsonNode.get("rule") == null) {
                //this is a leaf node
                node = new DecisionTreeNode(jsonNode.get("id").getAsInt(),
                        getClassLabel(jsonNode.get("value").getAsJsonArray()), true);
            } else {
                node = new DecisionTreeNode(jsonNode.get("id").getAsInt(),
                        getLabel(jsonNode.get("rule").getAsString()),
                            getCriterion(jsonNode.get("rule").getAsString()));

            }
        }

        if(jsonNode.get("right") != null)
            node.setRight(insertHelper(node.getRight(), jsonNode.get("right").getAsJsonObject()));

        if(jsonNode.get("left") != null)
            node.setLeft(insertHelper(node.getLeft(), jsonNode.get("left").getAsJsonObject()));

        return node;

    }

    public int getClassLabel(JsonArray array) {
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i).getAsInt() > 0)
                    return i;
        }
        return -1;
    }

    public void readJson() {
        try {
            JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(this.jsonFile)));
            JsonParser parser = new JsonParser();
            JsonObject nodes  = parser.parse(reader).getAsJsonObject();
            buildTree(nodes);

            //System.out.println(nodes.get("rule"));
        } catch(FileNotFoundException f) {
            f.printStackTrace();
        }
    }

    public static void main(String [] args) {
        DecisionTree t = new DecisionTree();
        t.readJson();
    }

}
