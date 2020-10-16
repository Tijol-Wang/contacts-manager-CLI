

public class Contact {
    private String name;
    private long number;

    // Constructor
    public Contact (String name, long number) {
        this.name = name;
        this.number = number;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public long getNum() {
        return this.number;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(long number) {
        this.number = number;
    }


}
