package com.example.foru.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Size(min = 1, max = 50, message = "Should be between 2 and 50 symbols")
        @NotBlank(message = "Company is mandatory")
        private String company;

        @Size(min = 1, max = 100, message = "Should be between 2 and 100 symbols")
        @NotBlank(message = "Name is mandatory")
        private String contactName;

        @Email(message = "Email should be valid")
        @NotBlank(message = "Email is mandatory")
        private String email;

        private String comments;

        public Customer() {
        }

        public Customer(String company, String contactName, String email, String comments) {
                this.company = company;
                this.contactName = contactName;
                this.email = email;
                this.comments = comments;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }


        public String getCompany() {
                return company;
        }

        public void setCompany(String company) {
                this.company = company;
        }

        public String getContactName() {
                return contactName;
        }

        public void setContactName(String contactName) {
                this.contactName = contactName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getComments() {
                return comments;
        }

        public void setComments(String comments) {
                this.comments = comments;
        }

 }
