package designPattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {
    @Test
    public void test() {
        Person person = Person.builder()
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .email("johndoe@example.com")
                .build();
        Assertions.assertEquals("John", person.getFirstName());
    }

}