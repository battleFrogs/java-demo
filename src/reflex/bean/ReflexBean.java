package reflex.bean;


public class ReflexBean {

    private String name;
    private String value;

    public String age;

    public ReflexBean() {
    }

    public ReflexBean(String name, String value, String age) {
        this.name = name;
        this.value = value;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ReflexBean{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
