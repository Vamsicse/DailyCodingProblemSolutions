import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LogFindAverageAPILatency {

    private static String BarAPI = "Bar";
    private static String FooAPI = "Foo";

    private static HashMap<String, List<Event>> log = new HashMap<>();

    static class Event {
        Action action;
        long timeStamp;
        Event(long timeStamp, Action action){ this.action=action; this.timeStamp=timeStamp;}
        @Override
        public String toString(){
            return "TimeStamp: " + timeStamp + " Action: " + action.name();
        }

    }

    private enum Action {
        START, END
    }

    public static void main(String[] args) {
        log(FooAPI, 100, Action.START);
        log(FooAPI, 150, Action.END);
        log(BarAPI, 200, Action.START);
        log(FooAPI, 220, Action.START);
        log(BarAPI, 230, Action.END);
        log(FooAPI, 250 ,Action.END);
        printLog();
        System.out.println(getAllServiceCallsBetweenTimes(Arrays.asList(FooAPI,BarAPI)));
    }

    private static void log(String apiName, long time, Action action){
        ArrayList<Event> list = new ArrayList<>();
        list.add(new Event(time, action));
        if(log.containsKey(apiName)){
            log.get(apiName).addAll(list);
        }
        else {
            log.put(apiName, list);
        }
    }

    private static void printLog(){
        System.out.println(log);
    }

    public static HashMap<String, Long> getAllServiceCallsBetweenTimes(List<String> apis) {
        HashMap<String, Long> avgLatencies = new HashMap<>();
        for(String apiName : apis) {
            long elapsed = 0;
            int size = log.get(apiName).size();
            for (int i = size - 1; i > -1; i -= 2) {
                elapsed = elapsed + (log.get(apiName).get(i).timeStamp) - (log.get(apiName).get(i - 1).timeStamp);
            }
            avgLatencies.put(apiName, elapsed / (size/2));
        }
        return avgLatencies;
    }

}
