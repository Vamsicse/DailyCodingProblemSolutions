import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Problem: Implement the singleton pattern with a twist. First, instead of storing one instance, store two instances.
 *    And in every even call of getInstance(), return the first instance and in every odd call of getInstance(), return the second instance.
 * Approach: Keep track of counter and return instances accordingly.
 *
 * @author Vamsi Krishna Myalapalli
 * @since 2019-12-27
 */
public class SingletonTwist {

    private static class Singleton implements Cloneable, Serializable {
        private static final long serialVersionUID = 42L;
        private static Singleton evenInstance;
        private static Singleton oddInstance;
        private static AtomicInteger counter = new AtomicInteger(1);

        private Singleton() {
            // Safeguard against reflection
            if (evenInstance != null || oddInstance != null) {
                throw new RuntimeException("Use getInstance() instead");
            }
        }

        public static Singleton getInstance() {
            boolean even = counter.getAndIncrement() % 2 == 0;
            // Make thread safe
            if (even && evenInstance == null) {
                synchronized (Singleton.class) {
                    if (evenInstance == null) {
                        evenInstance = new Singleton();
                    }
                }
            } else if (!even && oddInstance == null) {
                synchronized (Singleton.class) {
                    if (oddInstance == null) {
                        oddInstance = new Singleton();
                    }
                }
            }

            return even ? evenInstance : oddInstance;
        }

        // Make singleton from deserializaion
        protected Singleton readResolve() {
            return getInstance();
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException("Use getInstance() instead");
        }
    }

}


