package stream.groupBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy {
    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
//        Map<String, List<Person>> map = new HashMap<>();
//        for (Person person : people) {
//            if (!map.containsKey(person.getNationality())) {
//                map.put(person.getNationality(), new ArrayList<>());
//            }
//            map.get(person.getNationality()).add(person);
//        }
//        return map;
        return people.stream().collect(Collectors.groupingBy(Person::getNationality));
    }
}
