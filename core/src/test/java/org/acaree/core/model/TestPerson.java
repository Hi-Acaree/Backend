package org.acaree.core.model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Test the constructor and field access methods of the Person class.
 * <p>
 *     This test uses a mock object to test the constructor of the Person class.
 *     The mock object is created using the Mockito framework.
 *     The mock object is used to test the constructor of the Person class.
 *     </p>
 */
 class TestPerson {

    @Test
    void testPersonConstructorAndFieldAccess() {
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String phone = "1234567890";

        Person person = new Person(firstName, lastName, email, phone);

        assertEquals(firstName, person.getFirstName());
        assertEquals(lastName, person.getLastName());
        assertEquals(email, person.getEmail());
        assertEquals(phone, person.getPhone());
    }

    @Test
    void testEquals() {
        Person person1 = new Person("John", "Doe", "john.doe@example.com", "1234567890");
        Person person2 = new Person("John", "Doe", "john.doe@example.com", "1234567890");

        assertEquals(person1, person2);
        assertNotSame(person1, person2);
    }

    @Test
    void testHashCode() {
        Person person1 = new Person("John", "Doe", "john.doe@example.com", "1234567890");
        Person person2 = new Person("John", "Doe", "john.doe@example.com", "1234567890");

        assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    void testToString() {
        Person person = new Person("John", "Doe", "john.doe@example.com", "1234567890");
        String expectedString = "Person{id=0, firstName='John', lastName='Doe', email='john.doe@example.com', phone='1234567890'}";

        assertEquals(expectedString, person.toString());
    }
}
