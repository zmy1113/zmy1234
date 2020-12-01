package HomeWork.Pan_Users;

public class Users {
    private String Users_Name;
    private String Users_keys;


    public Users() {
    }

    public Users(String pName, String pKeys) {//全参构造函数：用户的各种数据
        this.Users_Name = pName;
        this.Users_keys = pKeys;
    }

    public String getUsers_Name() {
        return Users_Name;
    }

    public void setUsers_Name(String users_Name) {
        Users_Name = users_Name;
    }

    public String getUsers_keys() {
        return Users_keys;
    }

    public void setUsers_keys(String users_keys) {
        Users_keys = users_keys;
    }

    @Override
    public String toString() {
        return "Users{" +
                "Users_Name='" + Users_Name + '\'' +
                ", Users_keys='" + Users_keys + '\'' +
                '}';
    }
}

