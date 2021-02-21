package com.atguigu.boot05webadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class TableController {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入第一行
        String n = sc.nextLine();
        String[] inputLine=n.split(" ");
        Integer thingNum=Integer.parseInt(inputLine[0]);
        Integer bagWeight=Integer.parseInt(inputLine[1]);

        //输入第二行
        String thing=sc.nextLine();
        String[] thingLine=thing.split(" ");


        int a[]=new int[thingNum+1];
        for(int i=0;i<thingLine.length;i++){
            a[i]=Integer.parseInt(thingLine[i]);
        }
        int f[]=new int[bagWeight+1];
        for(int i=0;i<thingNum;i++)
        {
            for(int j=bagWeight;j>=a[i];j--)
            {
                f[j]=Math.max(f[j],f[j-a[i]]+a[i]);
            }
        }
        if(f[bagWeight]==bagWeight){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

    }


    @GetMapping("/dynamic_table")
    public String dynamic_table(){
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/respinsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
