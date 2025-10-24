package config;

public enum Endpoints {
    USER("/user");

    private final String value;
    Endpoints(String value) { this.value = value; }

    public String getValue() { return value; }
}
