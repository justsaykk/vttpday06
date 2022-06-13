## Java Generics

One useful way of using Generics is like this:

Lets say we want to create a box. But we haven't decided what to put into the box.

> The box needs to be able to change its type on-the-go

```java
public class Box<T> { // <- Notice the "<T>"? This essentially makes the type of the box a param
    private T boxContents;

    public T getBoxContents() {
        return boxContents;
    }

    public void setBoxContents(T boxContents) {
        this.boxContents = boxContents;
    }
}
```

And now this code is possible:

```java
public class Main {

    public static void main(String[] args) {
        Box<Integer> boxOfInt = new Box<Integer>();
        Box<String> boxOfString = new Box<String>();

        boxOfInt.setBoxContents(123);
        boxOfString.setBoxContents("String");
    }
}
```
