package HomeWork.SpeedLimiter;

import java.io.*;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(System.in);
        /*File fl = new File("F://云盘");
        File[] name = fl.listFiles();
        for (File file : name) {
            System.out.println(file);
        }
        System.out.println("请输入要下载的文件名称");
        String downName = sc1.nextLine();
        FileInputStream f1 = null;

        byte[] bt = new byte[4096];
        f1 = new FileInputStream(new File(downName));*/

        //上传文件
        FileOutputStream fos = new FileOutputStream("F://云盘//abc.txt");
        String str = sc1.nextLine();
        BandwidthLimiter bl = new BandwidthLimiter(1);
        UploadLimiter ull = new UploadLimiter(fos, bl);
        ull.write(str.getBytes());
        /*f1.read(bt);
        System.out.println(new String(bt,StandardCharsets.UTF_8));*//*
        BandwidthLimiter bl = new BandwidthLimiter(1);
        DownloadLimiter dll = new DownloadLimiter(f1, bl);
        dll.read(bt);
        System.out.println(new String(bt,StandardCharsets.UTF_8));*/

    }
}
