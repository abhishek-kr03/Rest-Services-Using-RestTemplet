package com.restservices.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.restservices.entity.User;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    // GET request to fetch all users with pretty-printed JSON
    public String getUsers() {
        String url = "https://reqres.in/api/users?page=2";
        String response = restTemplate.getForObject(url, String.class);

        try {
            // Parse the JSON response and pretty-print it
            JSONObject jsonObject = new JSONObject(response);
            return jsonObject.toString(4); // Indent with 4 spaces
        } catch (Exception e) {
            e.printStackTrace();
            return "Error formatting JSON";
        }
    }

    // POST request to create a new user
    public String createUser() {
        String url = "https://reqres.in/api/users";
        User newUser = new User("John Doe", "Developer");

        ResponseEntity<String> response = restTemplate.postForEntity(url, newUser, String.class);
        return response.getBody();
    }

    // PUT request to update an existing user
    public void updateUser() {
        String url = "https://reqres.in/api/users/2";
        User updatedUser = new User("Jane Doe", "Manager");

        restTemplate.put(url, updatedUser);
        System.out.println("User updated successfully");
    }

    // DELETE request to delete a user
    public void deleteUser() {
        String url = "https://reqres.in/api/users/2";
        restTemplate.delete(url);
        System.out.println("User deleted successfully");
    }
}
