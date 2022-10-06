public class ConstructionOrder {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.show();
        System.out.println("--------------");
        Person p2 = new Person("曹操", 30, 200000);
        p2.show();
        System.out.println("--------------");
        Person p3 = new Person(1, 10);
        p3.show();
    }
}

class Person {
    String name;
    int age;
    float sal;
//    String name = "张飞";
//    int age = 22;
//    float sal = 13000f;

    Person() {
        System.out.println("无参构造");
    }
//    {
//        name = "诸葛亮";
//        age = 42;
//        sal = 13000000f;
//        System.out.println("构造代码块");
//    }

    Person(String name, int age, float sal) {
        this(age, sal);
        System.out.println("3参构造");
        this.name = name;
//        this.age = age;
//        this.sal = sal;
    }

    Person(int age, float sal) {
        this.age = age;
        this.sal = sal;
        System.out.println("2参构造");
    }


    public void show() {
        System.out.println("姓名：" + name + "\t年龄：" + age + "\t工资：" + sal);
    }

    //静态成员方法不能访问非静态数据，因为静态数据先于对象存在，
//    public static void say(String name) {
//        this.name = name;
//    }
}