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
    private boolean isLeaf;

    private DecisionTreeNode right;
    private DecisionTreeNode left;

    public DecisionTreeNode(int id, String label,  float thresholdValue) {

        this.id = id;
        this.label = label;
        this.thresholdValue = thresholdValue;


        this.isLeaf = false;
        this.left = null;
        this.right = null;
    }

    public DecisionTreeNode(int id, int classLabel, boolean isLeaf) {
        this.id = id;
        this.classLabel = classLabel;
        this.isLeaf = isLeaf;
    }

    public void setLeft(DecisionTreeNode node) {
        this.left = node;
    }

    public void setRight(DecisionTreeNode node) {
        this.right = node;
    }

    public DecisionTreeNode getRight() {
        return this.right;
    }

    public DecisionTreeNode getLeft() {
        return this.left;
    }

    public void setThresholdValue(float value) {
        this.thresholdValue = value;
    }

    public void setIsLeaf(boolean value) {
        this.isLeaf = value;
    }

    public int getId()
    {
        return this.id;
    }

    public String getLabel()
    {
        return this.label;
    }

    public int getClassLabel() {
        return this.classLabel;
    }

    public float getThresholdValue() {
        return this.thresholdValue;
    }

    public float getImpurity()
    {
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
