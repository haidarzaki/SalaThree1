package com.tubes.salathree.services.ActorServices;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tubes.salathree.models.Pelanggan;
import com.tubes.salathree.models.Orders;
import com.tubes.salathree.models.User;
import com.tubes.salathree.models.Sorted_Menu;
import com.tubes.salathree.payloads.Requests.UserRequest;
import com.tubes.salathree.payloads.Response.Response;
import com.tubes.salathree.repositories.UserRepositories;
import com.tubes.salathree.repositories.OrdersRepositories;
import com.tubes.salathree.repositories.PelangganRepositories;
import com.tubes.salathree.repositories.SortedMenuRepositories;

@Service
@Primary
public class RestoServices extends UsersServices {
    @Autowired
    private SortedMenuRepositories SortedMenuRepositories;
    @Autowired
    private OrdersRepositories OrdersRepositories;

    @Autowired
    private PelangganRepositories PelangganRepositories;

    public RestoServices(UserRepositories userRepositories) {
        super(userRepositories);
    }

    @Override
    public final Response getAll() throws SQLException {
        if (userRepositories.findAll().isEmpty())
            return new Response(HttpStatus.NOT_FOUND.value(), "NO Data!", null);
        else {
            List<User> data = userRepositories.findAll();
            return new Response(HttpStatus.OK.value(), "success", data);
        }
    }

    @Override
    public final Response deleteDataByID(String id) throws SQLException {
        if (userRepositories.findById(id).isPresent()) {
            userRepositories.deleteById(id);
            return new Response(HttpStatus.OK.value(), "success", null);
        } else
            return new Response(HttpStatus.NOT_FOUND.value(), "Data not found", null);
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

    // ORDERS & CARTS

    public Response getAllOrders() throws SQLException { // LIST ORDERS FOR ADMIN
        if (OrdersRepositories.findAll().isEmpty())
            return new Response(HttpStatus.NOT_FOUND.value(), "NO Data!", null);
        else {
            List<Orders> data = OrdersRepositories.findAll();
            return new Response(HttpStatus.OK.value(), "success", data);
        }
    }

    public Response getDataCart(Integer orderID, String UserID) throws SQLException { // GET ALL ITEM IN CART
        if (OrdersRepository.getAllItemInCart(orderID).isEmpty())
            return new Response(HttpStatus.NOT_FOUND.value(), "NO Data!", null);
        else {
            List<OrdersItem> data = OrderItemRepository.getAllItemInCart(orderID);
            return new Response(HttpStatus.OK.value(), "success", data);
        }
    }

    public Response getOrderById(Integer id) throws SQLException { // GET ORDER BY ID
        if (OrdersRepositories.findById(id).isPresent()) {
            Orders data = OrdersRepositories.findById(id).get();
            return new Response(HttpStatus.OK.value(), "success", data);
        } else
            return new Response(HttpStatus.NOT_FOUND.value(), "Data not found", null);
    }

    public Response getOrderDetail(Integer id) throws SQLException { // GET ORDER DETAIL BY ID
        if (OrdersRepositories.findById(id).isPresent()) {
            List<OrdersItem> data = OrderItemRepositories.getOrderDetail(id);
            return new Response(HttpStatus.OK.value(), "success", data);
        } else
            return new Response(HttpStatus.NOT_FOUND.value(), "Data not found", null);
    }

    public Response getAddressCustomer(String UserID) throws SQLException {
        if (PelangganRepositories.findByPelanggan(UserID) == null)
            return new Response(HttpStatus.NOT_FOUND.value(), "NO Data!", null);
        else {
            Pelanggan data = PelangganRepositories.findByPelanggan(UserID);
            return new Response(HttpStatus.OK.value(), "success", data);
        }
    }

    public Response updateStatusOrder(Integer orderID, String status) {
        if (OrdersRepositories.findById(orderID).isPresent()) {
            Orders data = OrdersRepositories.findById(orderID).get();
            OrdersRepositories.save(data);
            return new Response(HttpStatus.OK.value(), "success", data);
        } else
            return new Response(HttpStatus.NOT_FOUND.value(), "Data not found", null);
    }
}