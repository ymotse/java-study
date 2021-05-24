package com.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@SequenceGenerator(name="CONT_SEQ", sequenceName = "CONTACT_SEQ", initialValue = 1, allocationSize = 1)
public class Contact implements Serializable {
    private static final long serialVersionUID = 3800918217076755136L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CONT_SEQ")
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(name = "BIRTH_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    
    private String email;

    @Override
    public String toString() {
        return "Contact [id=" + id + 
                ", name=" + name + 
                ", birthDate=" + birthDate +  
                ", email=" + email + "]";
    }
}
