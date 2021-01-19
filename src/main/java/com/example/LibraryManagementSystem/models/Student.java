package com.example.LibraryManagementSystem.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="phone")
    private String phone;
    @Column(name="birthday")
    private String birthday;
}
