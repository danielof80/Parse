package calculator.constants;

import tree.Type;

public class NamedConstants extends Constant{
        
    private String name;

    public NamedConstants(String name, Type<?> value) {
        super(value);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
