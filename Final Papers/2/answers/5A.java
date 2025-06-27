// Interface for all shapes
interface Shape {
    double calculateArea();

    String getName();
}

// Rectangle class
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    public String getName() {
        return "Rectangle";
    }
}

// Circle class
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public String getName() {
        return "Circle";
    }
}

// Triangle class
class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }

    public String getName() {
        return "Triangle";
    }
}

// ShapeCalculator class
class ShapeCalculator {
    public void printShapeInfo(Shape shape) {
        System.out.println(shape.getName() + " area: " + shape.calculateArea());
    }
}

// Main class
class Main {
    public static void main(String[] args) {
        ShapeCalculator calculator = new ShapeCalculator();

        Shape rectangle = new Rectangle(5, 3);
        Shape circle = new Circle(4);
        Shape triangle = new Triangle(6, 2);

        calculator.printShapeInfo(rectangle);
        calculator.printShapeInfo(circle);
        calculator.printShapeInfo(triangle);
    }
}
