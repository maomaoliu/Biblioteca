package tw.main;

import java.io.Console;

public class LoginAction {

    private String username = null;
    private UserList userList = UserList.getInstance();

    public String login(String username, String password) {
        if(userList.canLogin(username,password))     {
           this.username = username;
            return "User " +username+", welcome here!";
        }
        else                   {
            this.username = null;
            return "Username/password is not correct.";
        }
    }

    public String getUsername() {
        return username;  //To change body of created methods use File | Settings | File Templates.
    }

    public void action(){
        Console console =  System.console();
        PrintTools.println("Input username, please.");
        String username = console.readLine();
        PrintTools.println("Input password, please.");
        String password = new String(console.readPassword());
        String output = this.login(username, password);
        PrintTools.println(output);
    }
}
