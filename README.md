# Java Generics

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

# Decorators

## In this example, we will write a program to read a zip file:

```java
public class IOMain {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream(args[0]);
            ZipInputStream zis = new ZipInputStream(is);
            /* Notice that in previous examples, we only used up to the InputStream.
            Using an additional layer of ZipInputStream helps us to open up more functionality and gain access to different set of methods

            This is a concept called "decorating" or "decorators"
            */

            while (true) {
                ZipEntry zip = zis.getNextEntry();
                if (null != zip) {
                    System.out.printf("Filename: %s, size: %l\n", zip.getName(), zip.getSize());
                    zis.close();
                } else {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Another example of a decorator:

"MyWriter.java"

```java
public class MyWriter {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(args[0]);
        BufferedOutputStream bos = new BufferedOutputStream(fos); // This is what we call a "decorator"
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeInt(2);
        oos.writeUTF("Some String here");
        oos.writeUTF("Some other String here");
        oos.flush();
        oos.close();
    }
}
```

"MyReader.java"

```java
public class MyReader {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);

        int lines = ois.readInt(); // Since we wrote integer first, we need to read integer first.
        System.out.printf("there are %d int lines\n", lines);

        for (int i = 0; i < lines; i++) {
            String line = ois.readUTF();
            System.out.printf("%d: %s", i, line);
        }

        ois.close();
    }
}
```

# Multi-Dimension Arrays:

```java
public class ArrayMain {
    public static void main(String[] args) {
        // Lets create an array of 10 lines
        String[] lines = new String[10];

        // Lets create a normal 3x3 array of float
        float[][] matrix = new float[3][3];

        // For more granular control:
        float[][] matrix2 = new float[3][];
        for (int i = 0; i < matrix2.length; i++) {
            matrix[i] = new float[3];
            matrix[i][0] = i;
            matrix[i][1] = i;
            matrix[i][2] = i;
            matrix[i][3] = i;
        }

        /*
        We need to note that in Java, there is no such thing as a 2D array.
        The way to emulate it is to have an array of arrays.
        Therefore, it is possible that the array is not NxN. It could be NxM.
        */
    }
}
```
