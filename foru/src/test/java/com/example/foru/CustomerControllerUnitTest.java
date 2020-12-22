package com.example.foru;

import com.example.foru.controllers.CustomerController;
import com.example.foru.entities.Customer;
import com.example.foru.repository.CustomerRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerControllerUnitTest {

    private static CustomerController customerController;
    private static CustomerRepository mockedCustomerRepository;
    private static BindingResult mockedBindingResult;
    private static Model mockedModel;

    @BeforeClass
    public static void setUpUserControllerInstance() {
        mockedCustomerRepository = mock(CustomerRepository.class);
        mockedBindingResult = mock(BindingResult.class);
        mockedModel = mock(Model.class);
        customerController = new CustomerController(mockedCustomerRepository);
    }

    @Test
    public void whenCalledshowSignUpForm_thenCorrect() {
        Customer customer = new Customer("ABC", "John Sad", "john@domain.com", "potential client, contact after Xmas");

        assertThat(customerController.showSignUpForm(customer)).isEqualTo("add-user");
    }

    @Test
    public void whenCalledaddUserAndValidUser_thenCorrect() {
        Customer customer = new  Customer("ABC", "John Sad", "john@domain.com", "potential client, contact after Xmas");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(customerController.addUser(customer, mockedBindingResult, mockedModel)).isEqualTo("redirect:/index");
    }

    @Test
    public void whenCalledaddUserAndInValidUser_thenCorrect() {
        Customer customer = new  Customer("ABC", "John Sad", "john@domain.com", "potential client, contact after Xmas");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(customerController.addUser(customer, mockedBindingResult, mockedModel)).isEqualTo("add-user");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalledshowUpdateForm_thenIllegalArgumentException() {
        assertThat(customerController.showUpdateForm(0, mockedModel)).isEqualTo("update-user");
    }

    @Test
    public void whenCalledupdateUserAndValidUser_thenCorrect() {
        Customer customer = new  Customer("ABC", "John Sad", "john@domain.com", "potential client, contact after Xmas");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(customerController.updateUser(1l, customer, mockedBindingResult, mockedModel)).isEqualTo("redirect:/index");
    }

    @Test
    public void whenCalledupdateUserAndInValidUser_thenCorrect() {
        Customer customer = new  Customer("ABC", "John Sad", "john@domain.com", "potential client, contact after Xmas");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(customerController.updateUser(1l, customer, mockedBindingResult, mockedModel)).isEqualTo("update-user");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalleddeleteUser_thenIllegalArgumentException() {
        assertThat(customerController.deleteUser(1l, mockedModel)).isEqualTo("index");
    }
}
