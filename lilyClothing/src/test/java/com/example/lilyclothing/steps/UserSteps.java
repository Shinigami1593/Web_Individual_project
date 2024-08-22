package com.example.lilyclothing.steps;

import com.example.lilyclothing.Entity.User;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class UserSteps {

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;

    private String baseUrl;
    private ResponseEntity<String> response;
    private Long userId;
    private String userName;
    private String userPassword;
    private String userAddress;
    private Long userPhone;

    @Given("the user name is {string}")
    public void theUserNameIs(String userName) {
        this.userName = userName;
    }

    @And("the user password is {string}")
    public void theUserPasswordIs(String userPassword) {
        this.userPassword = userPassword;
    }

    @And("the user address is {string}")
    public void theUserAddressIs(String userAddress) {
        this.userAddress = userAddress;
    }

    @And("the user phone is {long}")
    public void theUserPhoneIs(Long userPhone) {
        this.userPhone = userPhone;
    }

    @When("the user sends a request to create the user")
    public void theUserSendsARequestToCreateTheUser() {
        baseUrl = "http://localhost:" + port + "/app_users";
        User user = new User();
        user.setUsername(userName);
        user.setPassword(userPassword);
        user.setAddress(userAddress);
        user.setPhone(userPhone);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        response = restTemplate.postForEntity(baseUrl + "/save", request, String.class);
    }

    @Then("the user is created successfully")
    public void theUserIsCreatedSuccessfully() {
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @When("the user sends a request to fetch all users")
    public void theUserSendsARequestToFetchAllUsers() {
        baseUrl = "http://localhost:" + port + "/app_users";
        response = restTemplate.getForEntity(baseUrl + "/getAll", String.class);
    }

    @Then("the list of users is fetched successfully")
    public void theListOfUsersIsFetchedSuccessfully() {
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Given("the user ID is {long}")
    public void theUserIDIs(Long id) {
        this.userId = id;
    }

    @When("the user sends a request to fetch the user data")
    public void theUserSendsARequestToFetchTheUserData() {
        baseUrl = "http://localhost:" + port + "/app_users";
        response = restTemplate.getForEntity(baseUrl + "/getById/" + userId, String.class);
    }

    @Then("the user data is fetched successfully")
    public void theUserDataIsFetchedSuccessfully() {
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @And("the new user name is {string}")
    public void theNewUserNameIs(String userName) {
        this.userName = userName;
    }

    @And("the new user password is {string}")
    public void theNewUserPasswordIs(String userPassword) {
        this.userPassword = userPassword;
    }

    @And("the new user address is {string}")
    public void theNewUserAddressIs(String userAddress) {
        this.userAddress = userAddress;
    }

    @And("the new user phone is {long}")
    public void theNewUserPhoneIs(Long userPhone) {
        this.userPhone = userPhone;
    }

    @When("the user sends a request to update the user data")
    public void theUserSendsARequestToUpdateTheUserData() {
        baseUrl = "http://localhost:" + port + "/app_users";
        User user = new User();
        user.setUsername(userName);
        user.setPassword(userPassword);
        user.setAddress(userAddress);
        user.setPhone(userPhone);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        response = restTemplate.exchange(baseUrl + "/update/" + userId, HttpMethod.PUT, request, String.class);
    }

    @Then("the user data is updated successfully")
    public void theUserDataIsUpdatedSuccessfully() {
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @When("the user sends a request to delete the user")
    public void theUserSendsARequestToDeleteTheUser() {
        baseUrl = "http://localhost:" + port + "/app_users";
        response = restTemplate.exchange(baseUrl + "/delete/" + userId, HttpMethod.DELETE, null, String.class);
    }

    @Then("the user is deleted successfully")
    public void theUserIsDeletedSuccessfully() {
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
