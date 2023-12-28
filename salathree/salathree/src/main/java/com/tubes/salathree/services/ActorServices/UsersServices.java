package com.tubes.salathree.services.ActorServices;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

// import com.TubesDiKaosan.ecommerce.models.Roles;
import com.tubes.salathree.models.User;
import com.tubes.salathree.payloads.Requests.UserRequest;
import com.tubes.salathree.payloads.Response.Response;
import com.tubes.salathree.repositories.UserRepositories;
import com.tubes.salathree.services.BaseServices;

@Service
public abstract class UsersServices extends BaseServices<UserRequest, String> {
    protected final UserRepositories userRepositories;

    @Autowired
    public UsersServices(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Override
    public final Response findDataByID(String id) throws SQLException {
        if (userRepositories.findById(id).isPresent()) {
            User data = userRepositories.findById(id).get();
            return new Response(HttpStatus.OK.value(), "success", data);
        } else
            return new Response(HttpStatus.NOT_FOUND.value(), "Data not found", null);
    }

    public final User findByEmail(String email) {
        return userRepositories.findByEmail(email);
    }

    public final Response login(String email, String password) throws SQLException {
        User user = findByEmail(email);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return new Response(HttpStatus.OK.value(), "success", user);
            } else {
                return new Response(HttpStatus.BAD_REQUEST.value(), "Wrong password", null);
            }
        } else {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Email not found", null);
        }
    }

    @Override
    public Response updateDataById(String id, UserRequest request) throws SQLException {
        try {
            Optional<User> optionalUser = userRepositories.findById(id);

            if (optionalUser.isPresent()) {
                User data = optionalUser.get();
                data.setUsername(request.getUsername());
                data.setEmail(request.getEmail());
                data.setPassword(request.getPassword());

                // Fetch role information
                // Response roleResponse = rolesService.findDataByID(request.getRole());
                // if (roleResponse.getStatus() != HttpStatus.OK.value()) {
                // return new Response(HttpStatus.BAD_REQUEST.value(), "Invalid role ID!",
                // null);
                // }

                // Save the updated user
                userRepositories.save(data);

                return new Response(HttpStatus.OK.value(), "Success", data);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Data not found", null);
            }
        } catch (Exception e) {
            // Handle specific exceptions and log the error
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error updating user", null);
        }
    }

    public boolean isEmpty() {
        return userRepositories.findAll().isEmpty();
    }
}