import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable , HttpSessionBindingListener {
    private String Name;
    private String Passwd;

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        ServletContext servletContext = event.getSession().getServletContext();
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

    }

    public User(String name, String passwd) {
        Name = name;
        Passwd = passwd;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Passwd='" + Passwd + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setPasswd(String passwd) {
        Passwd = passwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Name, user.Name) && Objects.equals(Passwd, user.Passwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Passwd);
    }
}
