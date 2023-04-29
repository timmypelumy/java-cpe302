public class App {

    int x = 5;
    int y = 0;

    public App(int u, int v) {
        x = u;
        y = v;

    }

    public static void main(String[] args) {

        App myApp = new App(122, 321);

        MyClass myClass = new MyClass();

        System.out.print("Hello World " + myApp.x + myClass.y);
    }

}
