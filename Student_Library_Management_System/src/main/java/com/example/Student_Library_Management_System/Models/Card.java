package com.example.Student_Library_Management_System.Models;

import com.example.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="card")
public class Card {

    // plan is to save card into the DB
    // Before Saving I have to set Its Attribute : Rule 1
    // don't forgave Rule : 1 this is a Rule : 2



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // its Auto Generated

    @CreationTimestamp
    private Date createdOn; // time stamp when entry is created

    @UpdateTimestamp
    private Date updatedOn;   // time stamp when entry is updated

    @Enumerated(value =  EnumType.STRING)
    private CardStatus cardStatus;

    @OneToOne
    @JoinColumn
    private Student studentVariableName; // this variable used in parent class.
    //while doing the bidirectional mapping


    public Student getStudentVariableName(Student student) {
        return studentVariableName;
    }

    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }

    public Card() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public CardStatus getCardStatus(CardStatus activated) {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }
}
