// Common behaviors for all workers
interface Worker {
    void work();

    void eat();

    void sleep();

    void attendMeeting();
}

// Specific behavior for developers who write code
interface CodeWriter {
    void writeCode();
}

// Specific behavior for designers who design UI
interface UIDesigner {
    void designUI();
}

// Developer implements Worker and CodeWriter interfaces
class Developer implements Worker, CodeWriter {

    @Override
    public void work() {
        System.out.println("Developer is working");
    }

    @Override
    public void eat() {
        System.out.println("Developer is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Developer is sleeping");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Developer is attending meeting");
    }

    @Override
    public void writeCode() {
        System.out.println("Developer is writing code");
    }
}

// Designer implements Worker and UIDesigner interfaces
class Designer implements Worker, UIDesigner {

    @Override
    public void work() {
        System.out.println("Designer is working");
    }

    @Override
    public void eat() {
        System.out.println("Designer is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Designer is sleeping");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Designer is attending meeting");
    }

    @Override
    public void designUI() {
        System.out.println("Designer is designing UI");
    }
}
