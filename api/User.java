package api;

import java.io.Serializable;
import java.util.Objects;

/**
 * Η κλάση αυτή αναπαριστά ένα χρήστη
 * @author trifon
 */
public class User implements Serializable {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String type;

    public User(String name, String surname, String username, String password, String type){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    /**
     * Ελέγχει την ισότητα δύο αντεικιμένων
     * @param user
     * @return true αν τα αντεικίμενα είναι ίσα, false αντίθετα
     */
    public boolean equals(User user) {

        return Objects.equals(this.name, user.name) &&
                Objects.equals(this.type, user.type) &&
                Objects.equals(this.surname, user.surname) &&
                Objects.equals(this.username, user.username) &&
                Objects.equals(this.password, user.password);
    }
}
