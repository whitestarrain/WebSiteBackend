package cn.edu.neu.tlog;

import java.util.Scanner;

/**
 * @author liyu
 */
public class Switcher implements Runnable{
    public static boolean toggle = true;
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            if("exit".equals(scanner.nextLine())){
                Switcher.toggle=false;
                return;
            }
        }
    }
}
