package tw.main;

import java.util.HashMap;

public class UserList {
    private static UserList userList;
    private static HashMap<String, String> users;
    private UserList() {
        String[] usernames = {"111-1111","111-1112","111-1113","111-1114","111-1115","111-1116"};
        String[] passwords = {"pw1","pw2","pw3","pw4","pw5","pw6"};
        users = new HashMap<String, String>();
        for(int i=0; i<6; i++){
            users.put(usernames[i],passwords[i]);
        }
    }

    public static UserList getInstance(){
        if(userList==null) userList = new UserList();
        return userList;
    }

    public boolean canLogin(String username, String password){
        return password.equals(users.get(username));
    }
}
