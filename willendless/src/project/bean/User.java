package project.bean;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private List<Reserve> reserves;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reserve> getReserves() {
        return reserves;
    }

    public void setReserves(List<Reserve> reserves) {
        this.reserves = reserves;
    }

    public String getAnonymousName() {
        if (name == null)
            return null;

        if (name.length() <= 1)
            return "*";
        else if (name.length() == 2)
            return name.substring(0, 1) + "*";

        char[] cs = name.toCharArray();
        for (int i = 1; i < cs.length - 1; i++)
            cs[i] = '*';
        return new String(cs);
    }
}
