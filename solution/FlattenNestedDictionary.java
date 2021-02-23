import java.util.HashMap;
import java.util.Set;

public class FlattenNestedDictionary {

    public static void main (String[] args) throws java.lang.Exception
    {
        HashMap<String, Object> dict = new HashMap<>();

        HashMap<String, Object> a = new HashMap<>();
        HashMap<String, Object> bar = new HashMap<>();
        HashMap<String, Object> baz = new HashMap<>();
        HashMap<String, Object> foo = new HashMap<>();
        HashMap<String, Object> key = new HashMap<>();

        baz.put("baz", "8");
        bar.put("bar", baz);
        a.put("a", "5");
        foo.put("a", a);
        foo.put("bar", bar);
        key.put("key", "3");

        dict.put("key", key);
        dict.put("foo", foo);

        System.out.println(dict);

        /**
         {
          "key": 3,
          "foo": {
            "a": 5,
            "bar": {
               "baz": 8
             }
           }
         }

         Output should look like this:
         {
         "key": 3,
         "foo.a": 5,
         "foo.bar.baz": 8
         }

         **/
    }

    public HashMap<String,String> flattenDictionary(HashMap<String,Object> dictionary, HashMap<String,String> flattenDictionary){
        Set<String> keys = dictionary.keySet();
        for(String key : keys){
            if(dictionary.get(key) instanceof String){
                continue;
            }
            /*
            while(dictionary.get(key)){

            }

             */
        }
        return null;
    }

}
