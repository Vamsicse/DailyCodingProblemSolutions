import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Schedule method invocations with respect to time
 * Approach: Use Scheduler
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
public class InvokeFunctionAfterTime {

    public static void main(String[] args) {
        String methodToInvoke = "greetHowdy";
        int time=5;
        new InvokeFunctionAfterTime().methodInvoker(methodToInvoke, time);
        methodToInvoke = "greetWhatsUp";
        time=3;
        new InvokeFunctionAfterTime().methodInvoker(methodToInvoke, time);
    }

    private void methodInvoker(String method, int time){
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable task=null;
        if(method.equals("greetHowdy")) {
            task = () -> {
                new InvokeFunctionAfterTime().greetHowdy();
            };
        }
        else if(method.equals("greetWhatsUp")){
            task = () -> {
                new InvokeFunctionAfterTime().greetWhatsUp();
            };
        }
        System.out.println("Invoking method: " + method + " after " + time + " seconds");
        executor.schedule(task, time, TimeUnit.SECONDS);
        executor.shutdown();
    }

    private void greetHowdy(){
        System.out.println("Howdy!");
    }

    private void greetWhatsUp(){
        System.out.println("Hey WhatsUp!");
    }
}
