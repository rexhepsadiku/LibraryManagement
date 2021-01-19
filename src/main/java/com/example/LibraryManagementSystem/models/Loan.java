package com.example.LibraryManagementSystem.models;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "loan")
public class Loan {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="loan_start")
    private String loan_start;
    @Column(name="loan_end")
    private String loanEnd;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
}
