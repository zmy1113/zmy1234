package HomeWork.Pan_Users;

import HomeWork.SpeedLimiter.BandwidthLimiter;
import HomeWork.SpeedLimiter.DownloadLimiter;
import HomeWork.SpeedLimiter.UploadLimiter;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
文件输入输出流
        下载：使用文件读取，从本地读取某些文件，并限制下载速度，用每次读取字节的长度作为下载速度的约束
             文件读取使用  file类，用文件输入输出流限制其读取速度
        上传：模拟上传，展示一下某文件，用scanner
 */
//文件下载
public class downAndUp {
    private String upName;
    private String downName;
    Scanner sc1 = new Scanner(System.in);

    public downAndUp() {
    }

    public downAndUp(String l_Name, String down_Name) {
        upName = l_Name;
        downName = down_Name;
    }

    public void downFile() throws Exception {
        //下载，使用自定义的限速器，限制速度
        Scanner sc1 = new Scanner(System.in);
        File f = new File("F://云盘");
        File[] name = f.listFiles();
        for (File file : name) {
            System.out.println(file);
        }
        System.out.println("请输入要下载的文件名称");
        downName = sc1.nextLine();
        FileInputStream f1 = null;
        try {
            f1 = new FileInputStream(new File(downName));
            byte[] bt = new byte[4096];
            BandwidthLimiter bl = new BandwidthLimiter(1);//使用限速器模拟限制下载速度
            DownloadLimiter dll = new DownloadLimiter(f1, bl);
            dll.read(bt);
            System.out.print(new String(bt, StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
        f1.close();
    }


    public void downLoad_valuePerson() throws Exception {//会员下载器
        Scanner sc1 = new Scanner(System.in);
        File f = new File("F://云盘");
        File[] name = f.listFiles();
        for (File file : name) {
            System.out.println(file);
        }
        System.out.println("请输入要下载的文件名称");
        downName = sc1.nextLine();
        FileInputStream f1 = null;
        try {
            f1 = new FileInputStream(new File(downName));
            byte[] bt = new byte[4096];
            f1.read(bt);
            System.out.print(new String(bt, StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
        f1.close();
    }


    //上传，速度未限制
    public void upFile(String pName) throws Exception {
        File file = new File("F://云盘//" + pName);
        File[] listFiles = file.listFiles();
        if (listFiles.length > 0) {
            FileOutputStream f1 = null;
            System.out.println("请输入想要上传的文件");
            String upName = sc1.nextLine();
            try {
                FileInputStream fis = new FileInputStream(upName);
                f1 = new FileOutputStream("F://云盘//公共文件夹//" + upName + "上传的文件");
                byte[] bt1 = new byte[4096];
                BandwidthLimiter bl = new BandwidthLimiter(1);
                UploadLimiter upl = new UploadLimiter(f1, bl);
                upl.write(fis.read(bt1));

            } catch (Exception e) {
                e.printStackTrace();
            }
            f1.close();
        } else {
            System.out.println("该文件夹暂无文件");
        }
    }

    public void upFile_valuePerson(String pName) throws Exception {//会员上传器
        File file = new File("F://云盘//" + pName);
        File[] listFiles = file.listFiles();
        if (listFiles.length > 0) {
            FileOutputStream f1 = null;
            System.out.println("请输入想要上传的文件");
            String upName = sc1.nextLine();
            try {
                FileInputStream fis = new FileInputStream(upName);
                f1 = new FileOutputStream("F://云盘//公共文件夹//" + upName + "上传的文件");
                byte[] bt1 = new byte[4096];
                f1.write(fis.read(bt1));

            } catch (Exception e) {
                e.printStackTrace();
            }
            f1.close();
        } else {
            System.out.println("此文件夹暂无文件");
        }
    }
}
