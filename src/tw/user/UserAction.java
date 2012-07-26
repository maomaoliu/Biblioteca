package tw.user;

import tw.uitools.InputTools;
import tw.uitools.PrintTools;

public class UserAction {

    private String username = null;
    private UserList userList = UserList.getInstance();


    public String login(String username, String password) {
        if(userList.hasUser(new User(username,password)))    {
           this.username = username;
            return "User " +username+", welcome here!";
        }
        else                   {
            this.username = null;
            return "Username/password is not correct.";
        }
    }

    public String getUsername() {
        return username;
    }

    public void action(){
        PrintTools.println("Input username, please.");
        String username = InputTools.getLine();
        PrintTools.println("Input password, please.");
        String password = new String(InputTools.getPassword());
        String output = this.login(username, password);
        PrintTools.println(output);
    }
}
