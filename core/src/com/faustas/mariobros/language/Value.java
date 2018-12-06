package com.faustas.mariobros.language;

public class Value {

    static Value VOID = new Value(new Object());

    private final Object value;
    
    Value(Object value) {
        this.value = value;
    }

    Boolean asBoolean() {
        return (Boolean)value;
    }

    Double asDouble() {
        return (Double)value;
    }

    String asString() {
        return String.valueOf(value);
    }

    boolean isDouble() {
        return value instanceof Double;
    }

    @Override
    public int hashCode() {

        if(value == null) {
            return 0;
        }

        return this.value.hashCode();
    }

    @Override
    public boolean equals(Object o) {

        if(value == o) {
            return true;
        }

        if(value == null || o == null || o.getClass() != value.getClass()) {
            return false;
        }

        Value that = (Value)o;

        return this.value.equals(that.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
