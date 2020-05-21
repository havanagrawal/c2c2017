# Garbage Collection Problems

1.
```java
void start() {
    A a = new A();
    B b = new B();

    a.someMethod(b);

    b = null;
    a = null;

    System.out.println("start completed");
}
```

2.
```java
class HappyGarbage
{
    public static void main(String args[]) {
        UselessObjectClass h = new UselessObjectClass();
        h.methodA();
    }

}

class UselessObjectClass {

    public Object methodA() {
        Object obj1 = new Object();
        Object [] obj2 = new Object[1];
        obj2[0] = obj1;
        obj1 = null;
        return obj2[0];
    }
}
```

3.
```java
class Bar {
}

class Foo {
    Bar doBar() {
        Bar b = new Bar();
        return b;
    }
}

class Test
{
    public static void main (String args[]) {
        Foo f = new Foo();
        Bar newBar = f.doBar();
        System.out.println("newBar");
        newBar = new Bar();
        System.out.println("finishing");
    }
}
```

4.
```java
class Test
{
    private Demo d;
    void start()
    {
        d = new Demo();
        this.takeDemo(d);
    }

    void takeDemo(Demo demo)
    {
        demo = null;
        demo = new Demo();
    }
}

class DemoDriver {
    public static void main(String[] args) {
        Test t = new Test();
        t.start();
    }
}
```

5.
```java
public class XRunner {
    public static void main(String [] args) {
        Baz x = new Baz();
        Baz x2 = Baz.m1(x); /* Line 6 */
        Baz x4 = new Baz();
        x2 = x4; /* Line 8 */
        doComplexStuff();
    }

}

class Baz {
    static Baz m1(Baz mx) {
        mx = new Baz();
        return mx;
    }
}
```

6.
```java
public Object m()
{
    Object o = new Float(3.14F);
    Object [] oa = new Object[l];
    oa[0] = o;
    o = null;
    oa[0] = null;
    return o;
}
```

7. 
```java
class X2 {
    public static void main(String [] args) {
        FooBar x1 = new FooBar(); /* Line 6 */
        FooBar x2 = new FooBar(); /* Line 7 */
        x1.x = x2;
        x2.x = x1;
        x1 = new FooBar();
        x2 = x1; /* Line 11 */
        doComplexStuff();
    }
}

class FooBar {
    public FooBar x;
}
```
