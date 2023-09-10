package model;
public class Person {
    protected int id;
    protected String name;

    public int getId(){
        return id;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Person() {}

    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
