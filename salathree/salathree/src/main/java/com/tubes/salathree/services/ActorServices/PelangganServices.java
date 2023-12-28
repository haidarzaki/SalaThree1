package com.tubes.salathree.services.ActorServices;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tubes.salathree.models.User;
import com.tubes.salathree.models.Orders;
import com.tubes.salathree.models.Pelanggan;
import com.tubes.salathree.payloads.Requests.UserRequest;
import com.tubes.salathree.payloads.Requests.PelangganRequest;
import com.tubes.salathree.payloads.Requests.OrdersRequest;
import com.tubes.salathree.payloads.Response.Response;
import com.tubes.salathree.repositories.PelangganRepositories;
import com.tubes.salathree.repositories.UserRepositories;
import com.tubes.salathree.repositories.OrdersRepositories;
import com.tubes.salathree.services.BuyingServices.BuyingServices;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Service
@Primary
public class PelangganServices extends UsersServices {
    @Autowired
    private BuyingServices buyingServices;

    @Autowired
    private OrdersRepositories OrdersRepositories;

    public PelangganServices(UserRepositories userRepositories) {
        super(userRepositories);
    }

    @Override
    public Response getAll() throws SQLException {
        return new Response(HttpStatus.BAD_REQUEST.value(), "Method not allowed", null);
    }

    @Override
    public Response deleteDataByID(String id) throws SQLException {
        return new Response(HttpStatus.BAD_REQUEST.value(), "Method not allowed", null);
    }

    @Override
    public final Response updateDataById(String id, UserRequest request) throws SQLException {
        try {
            Optional<User> optionalUser = super.userRepositories.findById(id);

            if (optionalUser.isPresent()) {
                User data = optionalUser.get();
                data.setUsername(request.getUsername());
                data.setEmail(request.getEmail());
                data.setPassword(request.getPassword());

                userRepositories.save(data);

                return new Response(HttpStatus.OK.value(), "Success", data);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Data not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error updating user", null);
        }
    }

    @Override
    public Response createData(UserRequest request) throws SQLException {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());

        userRepositories.save(user);
        return new Response(HttpStatus.OK.value(), "success", user);
    }

}