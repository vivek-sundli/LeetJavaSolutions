public class Lion extends Animal{
    public Integer age;
    public String name;

    @Override
    public void eat() {
        System.out.println("Lion Eating");
    }

    @Override
    public void sleep() {
        System.out.println("Lion Sleeping");
    }
}
