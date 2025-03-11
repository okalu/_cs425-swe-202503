package edu.miu.cs.cs425.citylibraryapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.StringJoiner;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer publisherId;
    @Column(length = 64,  nullable = false) // "", "  "
    @NotNull(message = "Publisher is required and cannot be null")
    @NotEmpty(message = "Publisher cannot be empty")
    @NotBlank(message = "Publisher cannot be blank")
    private String name;
    private String email;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_address_id", nullable = true, unique = true)
    private Address primaryAddress;

    public Publisher(Integer publisherId, String name, String email, String phoneNumber, Address primaryAddress) {
        this.publisherId = publisherId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.primaryAddress = primaryAddress;
    }

    public Publisher() {
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Publisher.class.getSimpleName() + "[", "]")
                .add("publisherId=" + publisherId)
                .add("name='" + name + "'")
                .add("email='" + email + "'")
                .add("phoneNumber='" + phoneNumber + "'")
                .add("primaryAddress='" + primaryAddress + "'")
                .toString();
    }
}
