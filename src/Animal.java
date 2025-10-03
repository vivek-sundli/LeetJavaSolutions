// src/Animal.java
public abstract class Animal {
    protected String name;
    protected Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public abstract void eat();
    public abstract void sleep();
}