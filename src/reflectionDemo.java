import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Date;

public class reflectionDemo {

    private int ID;
    private String name;
   // private Date birthday;

    public reflectionDemo() {
    }

    public reflectionDemo(int ID) {
        this.ID = ID;
    }

    public reflectionDemo(String name) {
        this.name = name;
    }

    public reflectionDemo(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }


    public static void main(String[] args) {
        reflectionDemo reflection = new reflectionDemo();
        Class c = reflection.getClass();
        Constructor[] constructors = c.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.print(Modifier.toString(constructors[i].getModifiers()) + "参数： ");
           // System.out.println(constructors[i].getParameterTypes());
            Class[] parameters = constructors[i].getParameterTypes();
            for (int i1 = 0; i1 < parameters.length; i1++) {
                System.out.print(parameters[i1]);
            }
            System.out.println();
        }


    }
}
