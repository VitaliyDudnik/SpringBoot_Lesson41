package com.tms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "calc")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double num1;
    private double num2;
    private double result;
    private String operation;
    private LocalDate date;

    @OneToOne(cascade = CascadeType.REMOVE)
    private User user;

    public Operation(double num1, double num2, double result, String operation, LocalDate date, User user ) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.operation = operation;
        this.user = user;
        this.date = date;

    }
}
