package HomeWork.Pan_Users;

import java.io.File;
import java.io.FileInputStream;

/**
 * 该云盘有一定的缺陷，只能在控制台运行，代码中的文件路径存在于我的电脑里，可能在其他电脑上没有该路径
 * 下载设有一个限速器进行模拟，非会员限速这一功能
 * 上传是从自己的专属文件夹里选取文件，若该文件夹内无内容则会告诉使用者“该文件夹无内容”的提示，然后重新选择下载或上传
 * 该系统功能暂时不完备，不具有断点续传的功能。
 */
public class c {
    public static void main(String[] args) {
        String str = "zmy";
        File f = new File("F://云盘//" + str);
        boolean mkdir = f.mkdir();
        System.out.println(mkdir);
    }
}
