/**
 * Problem: Implement a Singleton Design Pattern
 * Approach: Use Enum or Inner Class
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class SingletonPattern {

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        System.out.println(logger1);
        Logger logger2 = Logger.getInstance();
        System.out.println(logger2);

        SingletonEnum obj1 = SingletonEnum.INSTANCE;
        System.out.println(obj1.hashCode());
        SingletonEnum obj2 = SingletonEnum.INSTANCE;
        System.out.println(obj2.hashCode());
    }
}

class Logger {
    private Logger(){}
    public static class LoggerHolder {
        // Initialization on Demand (Not loaded until referenced)
        public static Logger logger = new Logger();
    }
    public static Logger getInstance(){
        return LoggerHolder.logger;
    }
}

// Guaranteed Single Instance, Thread Safe, Serialization
enum SingletonEnum {
    INSTANCE;
    int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}





/*
Output:
—————————————————————— 

Logger@3f0ee7cb
Logger@3f0ee7cb
2101440631
2101440631



*/
