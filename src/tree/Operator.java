package tree;

public class Operator {
    private int indexOperator;
    private final String info;
    private final String name;

    public Operator(String info, String name, int indexOperator) {
        this.indexOperator = indexOperator;
        this.info = info;
        this.name = name;
    }

    public int captureIndexOperator() {
        return indexOperator;
    }
    
    public String captureInfo() {
        return info;
    }

    public String captureName() {
        return name;
    }

    public void setIndexOperator(int index) {
        this.indexOperator = index;
    }
}
