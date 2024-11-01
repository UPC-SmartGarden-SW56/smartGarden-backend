package com.pe.upc.smartgardenbackend.profiles.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.profiles.domain.model.commands.CreateProfileCommand;
import com.pe.upc.smartgardenbackend.profiles.domain.model.valueobjects.EmailAddress;
import com.pe.upc.smartgardenbackend.profiles.domain.model.valueobjects.PersonName;
import com.pe.upc.smartgardenbackend.profiles.domain.model.valueobjects.StreetAddress;
import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;

@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {
    @Embedded
    private PersonName name;

    @Embedded
    EmailAddress email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "number", column = @Column(name = "address_number")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "address_postal_code")),
            @AttributeOverride(name = "country", column = @Column(name = "address_country"))})
    private StreetAddress address;

    public Profile(String firstName, String lastName, String email, String number, String city, String postalCode, String country) {
        this.name = new PersonName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.address = new StreetAddress(number, city, postalCode, country);
    }

    public Profile(CreateProfileCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.address = new StreetAddress(command.number(), command.city(), command.postalCode(), command.country());
    }

    public Profile() {
    }

    public void updateName(String firstName, String lastName) {
        this.name = new PersonName(firstName, lastName);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public void updateAddress(String number, String city, String postalCode, String country) {
        this.address = new StreetAddress(number, city, postalCode, country);
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getEmailAddress() {
        return email.address();
    }

    public String getStreetAddress() {
        return address.getStreetAddress();
    }

}
