package com.example.foru.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Person {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Size(min = 1, max = 50, message = "Should be between 2 and 50 symbols")
        @NotBlank(message = "Name is mandatory")
        private String name;

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Email should be valid")
        private String email;

        public Person() {
        }

        public Person(String name, String email) {
                this.name = name;
                this.email = email;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
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

        @Override
        public String toString() {
                return "User{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
        }
 }
