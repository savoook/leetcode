package stream.partitionBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionBy {
    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
//        Map<Boolean, List<Person>> map = new HashMap<>();
//        map.put(true, new ArrayList<>());
//        map.put(false, new ArrayList<>());
//        for (Person person : people) {
//            map.get(person.getAge() >= 18).add(person);
//        }
//        return map;
//    }
        //return people.stream().collect(Collectors.toMap(true, new ArrayList<Person>()));
       return people.stream().collect(Collectors.partitioningBy(p->p.getAge()>18));
    }
}
