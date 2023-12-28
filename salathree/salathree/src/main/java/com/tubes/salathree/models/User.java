package com.tubes.salathree.models;
//import java.time.LocalDateTime;

//import java.util.List;

//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator
    private String user_id;

    @Column(name = "username", length = 32)
    private String username;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

    public User() {
    }

    // Setter & Getter
    public User(String IDUser, String username, String email, String password) {
        this.user_id = IDUser;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

}
