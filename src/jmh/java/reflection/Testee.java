package reflection;

public class Testee {

    private final Integer intValue;
    private final String stringValue;

    public Testee() {
        this.intValue = 42;
        this.stringValue = "string";
    }

    public Integer getInteger() {
        return intValue;
    }

    public String getString() {
        return stringValue;
    }
}
