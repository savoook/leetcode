package stream.getTheOldestPerson;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class MaxAndComparatorTest {

    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        Person oldestPerson = MaxAndComparator.getOldestPerson(collection);
        assertThat(oldestPerson).usingRecursiveComparison().isEqualTo(eva);
    }
}