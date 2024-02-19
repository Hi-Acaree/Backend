package org.acaree.core.dto;

import lombok.Getter;
import lombok.Setter;
import org.acaree.core.exceptions.PersonException;
import org.acaree.core.model.Person;
import org.acaree.core.util.ErrorType;

import java.util.Objects;

@Getter @Setter
public class PersonDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String pictureUrl;


    public static PersonDTO from(Person person) {
        Objects.requireNonNull(person, "Person cannot be null");
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());

        if (person.getFirstName() == null || person.getFirstName().isEmpty() ){
            throw new PersonException("Person first name is required", ErrorType.PERSON_INVALID_INPUT);
        }
        if (person.getLastName() == null || person.getLastName().isEmpty() ){
            throw new PersonException("Person last name is required", ErrorType.PERSON_INVALID_INPUT);
        }
        if (person.getEmail() == null || person.getEmail().isEmpty() ){
            throw new PersonException("Person email is required", ErrorType.PERSON_INVALID_INPUT);
        }
        if (person.getPhone() == null || person.getPhone().isEmpty() ){
            throw new PersonException("Person phone is required", ErrorType.PERSON_INVALID_INPUT);
        }
        if (person.getPictureUrl() == null || person.getPictureUrl().isEmpty() ){
            dto.setPictureUrl("https://www.gravatar.com/avatar/00000000000000000000000000000000?d=mp&f=y");
        } else {
            dto.setPictureUrl(person.getPictureUrl());
        }


        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setEmail(person.getEmail());
        dto.setPhone(person.getPhone());
        dto.setPictureUrl(person.getPictureUrl());
        return dto;
    }
}
