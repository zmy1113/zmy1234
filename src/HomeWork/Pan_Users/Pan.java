package HomeWork.Pan_Users;

import HomeWork.Pan_Users.Users;
import HomeWork.Pan_Users.downAndUp;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Pan {
    public static void main(String[] args) throws Exception {

        while (true) {
            System.out.println("======欢迎使用zmy网盘=======");
            System.out.println("输入1登录账号");
            System.out.println("输入2注册账号");
            System.out.println("输入3退出系统");
            Scanner sc = new Scanner(System.in);
            String st = sc.nextLine();
            switch (st) {
                case "1":
                    login(array);
                    break;
                case "2":
                    addUsers(array);
                    break;
                case "3":
                    System.out.println("欢迎下次使用");
                    System.exit(0);
                    break;
                default:
                    System.out.println("谢谢使用");
                    break;
            }
        }
    }

    static ArrayList<Users> array = new ArrayList<>();

    public static void login(ArrayList<Users> array) throws Exception {//登录用户，判断登录名称是否符合要求是否重复
        int A = 0;//作为检验是否为会员的标志
        if (array.size() == 0) {
            System.out.println("现在暂无用户数据，请注册账号");
            addUsers(array);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号和密码");
        String pName = sc.nextLine();
        String pKeys = sc.nextLine();

        for (int i = 0; i < array.size(); i++) {
            Users nt = array.get(i);
            if (nt.getUsers_Name().equals(pName))//逐个元素的pName变量与刚获取的变量利用方法进行对比
            {
                if (nt.getUsers_keys().equals(pKeys)) {
                    System.out.println("登陆成功");
                    System.out.println("亲爱的用户，是否充值会员，会员可立即提升十倍下载速度哦~~~");
                    System.out.println("Yes\t\tNO");
                    String choose1 = sc.nextLine();
                    switch (choose1) {
                        case "Yes":
                            System.out.println("充值成功");
                            A = 1;
                            break;
                        case "No":
                            System.out.println("取消充值成功");
                            A = 0;
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println("密码错误");
                }
            } else {
                System.out.println("昵称错误");
            }
            break;
        }
        downAndUp dau = new downAndUp();
        while (true) {
            System.out.println("请选择上传或下载文件");
            System.out.println("输入1上传文件，输入2下载文件，输入3退出系统");
            String choose = sc.nextLine();
            switch (choose) {
                case "1":
                    if (A == 1) {
                        dau.upFile_valuePerson(pName);
                        break;
                    }
                    dau.upFile(pName);
                    break;
                case "2":
                    if (A == 1) {
                        dau.downLoad_valuePerson();
                        break;
                    }
                    dau.downFile();
                    break;
                case "3":
                    System.out.println("欢迎下次使用");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public static void addUsers(ArrayList<Users> array) throws Exception {//注册账号

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号和密码");
        System.out.println("请输入10个字符以内且不为空的登录名称：");
        String pName = sc.nextLine();
        int a = 0;//作为检验是否重复的标志
        //与已经添加的集合元素进行对比，如果相同则输出相应内容
        for (int i = 0; i < array.size(); i++) {
            Users us1 = array.get(i);
            if (us1.getUsers_Name().equals(pName)) {//Name变量与刚获取的pName变量利用equals方法进行逐一对比
                if (pName.length() > 10 || pName.isEmpty()) {
                    System.out.println("该昵称不符合要求，请重新输入");
                }
                System.out.println("该昵称已经存在，请重新输入");
                a++;//重复，检验标志自加
                break;
            }
        }
        if (a == 0) {
            while (true) {
                System.out.println("请输入6-16个字符的登录密码：");
                String pKeys = sc.nextLine();
                Users us2 = new Users();
                if (pKeys.length() >= 6 && pKeys.length() <= 16) {
                    us2.setUsers_keys(pKeys);
                    us2.setUsers_Name(pName);
                    array.add(us2);
                    System.out.println("注册成功");
                    break;
                }
            }
            System.out.println("现在您拥有一个专属的文件夹，名称为您的登录名称");
            File f = new File("F://云盘//" + pName);
            f.mkdir();
        }
    }
}
