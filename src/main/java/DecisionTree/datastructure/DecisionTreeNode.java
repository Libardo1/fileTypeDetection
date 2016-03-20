package DecisionTree.datastructure;

/**
 * Created by rahulravindran on 19/03/16.
 */
public class DecisionTreeNode {

    private int id;
    private String label;
    private int classLabel;
    private float thresholdValue;
    private float impurity;

    DecisionTreeNode right;
    DecisionTreeNode left;

    public int getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public int getClassLabel() {
        return this.classLabel;
    }

    public float getThresholdValue() {
        return this.thresholdValue;
    }

    public float getImpurity() {
        return this.impurity;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClass(int classLabel) {
        this.classLabel = classLabel;
    }

    public void setThreshold(float impurity) {
        this.impurity = impurity;
    }

    public void setImpurity(float impurity) {
        this.impurity = impurity;
    }
}
