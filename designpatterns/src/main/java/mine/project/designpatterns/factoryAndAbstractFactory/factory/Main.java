package mine.project.designpatterns.factoryAndAbstractFactory.factory;

public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape("CIRCLE");
        shape.draw();
    }
}
