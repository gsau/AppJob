package uf1.infobosccoma.appjob;

/**
 * Created by Gerard on 06/02/2015.
 */
public class Persona implements Comparable<Persona> {
    private String user, pass;

    public Persona(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public int compareTo(Persona another) {
        return (this.user+this.pass).compareTo(another.getUser()+another.getPass());
    }
}
