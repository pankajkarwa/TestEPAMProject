package com.epam.microservices.userservice.controller;


import com.epam.microservices.userservice.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Controller is consisting of the services for storing, retrieval and updating User Profile
 *
 */

@Api(value = "User Information", description = "Services for storing, retrieval and updating User Profile")
@RequestMapping("/users")
public interface UserController {

    @ApiOperation(value = "User information Service.", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User information stored successfully."),
            @ApiResponse(code = 401, message = "Authentication failure."),
            @ApiResponse(code = 403, message = "Unauthorized to perform the operation."),
            @ApiResponse(code = 404, message = "Resource not found.")

    })

    /**
     * This method is used to add new User profile.This is
     *
     * @param user This is the request body paramter
     * to create the User Profile
     *
     * @return ResponseEntity<User> This returns created User Object.
     **/

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
   // @PreAuthorize("hasRole('GUEST')")
    public ResponseEntity<User> addNewUser(@RequestBody User user);

    /**
     * This method is used to Fetch User profile based on ID.
     *
     * @param userId This is the parameter which is used to fetch the user
     * @return ResponseEntity<User> This returns the User Object with specific ID.
     **/

    @ApiOperation(value = "Fetch Information of User Based on ID.")
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('GUEST')")
    public ResponseEntity<User> getUser(@PathVariable("userId") Long userId);

    /**
     * This method is used to Update User Stay Information for stay history
     *
     * @param userId This is the parameter which is used to update the stay
     * @param stay    This is the parameter reservationID which is used to fetch the user
     * @return ResponseEntity<User> This returns the User Object with specific ID.
    **/

    @ApiOperation(value = "Update User Stay Information for stay history.")
    @PutMapping(value = "/{userId}/stay", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('GUEST')")
    public ResponseEntity<User> addStayByUser(@PathVariable("userId") Long userId, @RequestParam("reservationId") Long stay);

    /**
     * This method is used to Fetch the list of User based on ID
     *
     * @param userIds This is the parameter which signifies list of user ID's
     * @return ResponseEntity<List < User>> This returns the List of User Objects with specific ID.
     **/

    @ApiOperation(value = "Fetch the Information for multiple users based on list of ID's.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers(@RequestParam("userId") List<Long> userIds);

}
