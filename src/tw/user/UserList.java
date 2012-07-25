package tw.user;

import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private static ArrayList<User> users;
    private UserList() {
        String[] usernames = {"111-1111","111-1112","111-1113","111-1114","111-1115","111-1116"};
        String[] passwords = {"pw1","pw2","pw3","pw4","pw5","pw6"};
        users = new ArrayList<User>();
        for(int i=0; i<6; i++){
            users.add(new User(usernames[i], passwords[i]));
        }
    }

    public static UserList getInstance(){
        if(userList==null) userList = new UserList();
        return userList;
    }

    public boolean hasUser(User user) {
        return users.contains(user);
    }
}
