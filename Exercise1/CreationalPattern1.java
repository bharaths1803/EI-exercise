//Singleton Pattern

//Use Case: A logging system where only one instance of the logger should exist.

class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class CreationalPattern1 {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is a log message.");

        System.out.println(logger1 == logger2); // true, both are the same instance
    }
}