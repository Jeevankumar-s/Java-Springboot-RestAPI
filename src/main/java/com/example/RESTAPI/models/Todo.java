package com.example.RESTAPI.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;
import org.antlr.v4.runtime.misc.NotNull;

//Lambok - getter and setter will be done automatically
// Getter is used only to get the values
// Setter is used only to set the values

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    Long id;
    @NotBlank
    @NonNull
    @Size(min=2, max=15)
    String title;
    @NotBlank
    @NonNull
    @Size(min=5, max=20)
    String description;
    Boolean isCompleted;
    @Email
    String email;
}
