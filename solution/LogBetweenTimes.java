import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LogBetweenTimes {

    private static Map<String, TreeMap> serviceMap = new TreeMap<>();

    private static String MercuryService = "Mercury";
    private static String PlutoService = "Pluto";

    public static void main(String[] args) {
        addService(MercuryService);
        addService(PlutoService);
        addServiceCall(MercuryService, 1, "first log");
        addServiceCall(MercuryService, 5, "second log");
        addServiceCall(PlutoService, 3, "first log");
        System.out.println(getAllServiceCallsBetweenTimes(1,4));
    }

    public static void addService(String service) {
        serviceMap.put(service, new TreeMap<Long, String>());
    }

    //Time complexity O(LogN)
    public static void addServiceCall(String service, long time, String payload) {
        TreeMap<Long, String> timings = serviceMap.getOrDefault(service, new TreeMap<Long, String>()); //getOrDefault is not mandatory if addService is always called first
        timings.put(time, payload); //now timingMap can also store payload in the form of a List<String> if that is clarified in the followup question.
    }

    //Time complexity O(N) - If the result list required to be sorted again, time complexity O(NlogN)
    public static List<String> getAllServiceCallsBetweenTimes(long time1, long time2) {
        //Loop all services and get the subMap between time1 and time2.
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, TreeMap> entry: serviceMap.entrySet()) {
            Map<Long, String> timingSubMap = entry.getValue().subMap(time1, true, time2, true);
            for(Map.Entry<Long, String> entry1: timingSubMap.entrySet()) {
                result.add(entry.getKey() + ": " + entry1.getValue());
            }
        }
        return result;
    }

}

/*
Output:
——————————————————————

[Mercury: first log, Pluto: first log]

——————————————————————
 */