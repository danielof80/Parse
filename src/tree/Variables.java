package tree;

class Variables extends Tree {

    private Type type;

    public Variables(Type value) {
        this.type = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    public Object getValue(){
        return type.getValue();
    }

    @Override
    public Type evaluate() {
        return type;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
