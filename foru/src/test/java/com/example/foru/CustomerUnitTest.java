package com.example.foru;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.foru.entities.Customer;
import org.junit.Test;

public class CustomerUnitTest {

    @Test
    public void whenCalledGetName_thenCorrect() {
        Customer customer = new Customer("ABC", "John Sad", "john@domain.com", "potential client, contact after Xmas");

        assertThat(customer.getContactName()).isEqualTo("John Sad");
    }

    @Test
    public void whenCalledGetEmail_thenCorrect() {
        Customer customer = new Customer("ABC", "John Sad", "john@domain.com", "potential client, contact after Xmas");

        assertThat(customer.getEmail()).isEqualTo("john@domain.com");
    }

    @Test
    public void whenCalledSetName_thenCorrect() {
        Customer customer = new Customer("ABC", "John Sad", "john@domain.com", "potential client, contact after Xmas");

        customer.setContactName("John");

        assertThat(customer.getContactName()).isEqualTo("John");
    }

    @Test
    public void whenCalledSetEmail_thenCorrect() {
        Customer customer = new Customer("ABC", "John Sad", "john@domain.com", "potential client, contact after Xmas");

        customer.setEmail("john@domain.com");

        assertThat(customer.getEmail()).isEqualTo("john@domain.com");
    }

}
