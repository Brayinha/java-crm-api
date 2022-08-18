package com.example.application.foundation.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@ToString
@AllArgsConstructor
@Entity
@Table(name = "TB_Customer")
@NoArgsConstructor
@Data
@Builder
public class Customer {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(length = 20)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    @Column(length = 30)
    private String email;
    @Column(nullable = true, length = 30)
    private String company;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return id != null && Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
