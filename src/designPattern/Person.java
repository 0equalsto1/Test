package designPattern;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
}