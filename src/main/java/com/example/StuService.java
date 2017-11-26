package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class StuService {
	//全部学生列表
		static List<Student> stuList ;
	
	 /**
	   * 展示所有学生信息
	   */
	  void ShowList() {
		System.out.println(stuList);
		
	}

	/**
	   * 查询所有签到人信息
	   */
	  void ShowInList() {
		  for(int i = 0;i<100;i++) {
		    		if(stuList.get(i).getIncome() == 1) {
		    			System.out.println(stuList.get(i));
		    		}
		    }
	}

	  /**
	   * 根据ID查询是否签到
	   */
	void IsInCome() {
		  System.out.println("请输入学号进行查询：");
		    Scanner sc  = new Scanner(System.in);
		    int inid = sc.nextInt();
		    int num = 0;
		    //对输入的学号进行判断是否正确
		    for(int i = 0;i<100;i++) {
		    	if( stuList.get(i).getId()==inid) {
		    		if(stuList.get(i).getIncome() == 1) {
		    			System.out.println(stuList.get(i).getName() +" 已签到");
		    		}else {
		    			System.out.println(stuList.get(i).getName() +" 未签到");
		    		}
		    		  num = 1;
		    	}
		    }
		    if(num == 0) {
		    	 System.out.println("ID错误 ");
		    }
		
	}

	/**
	   * 生成100个学生对象
	   * @return
	   */
	  public  List<Student> proStu() {
		  stuList = new ArrayList<>();
		    for(int i = 0;i<100;i++) {
		    	Student s  = new Student();
		    	s.setId(i);
		    	s.setName("Seon "+i);
		    	s.setIncome(-1);
		    	stuList.add(s);
		    }
		    return stuList;
	}
	  
	  /**
	   * 签到
	   */
	  public  void toInCome() {
		  //签到问题
		    System.out.println("请输入学号进行签到：");
		    Scanner sc  = new Scanner(System.in);
		    int inid = sc.nextInt();
		    //做签到失败条件
		    int num = 0;
		    //对输入的学号进行判断是否正确
		    for(int i = 0;i<100;i++) {
		    	if( stuList.get(i).getId()==inid) {
		    		 stuList.get(i).setIncome(stuList.get(i).getIncome() * -1) ;
		    		 System.out.println(stuList.get(i).getName()+" 签到成功");
		    		  num = 1;
		    	}
		    }
		    if(num == 0) {
		    	 System.out.println("ID错误 签到失败");
		    }
	}
	  /**
	   * 查询签到人数
	   * 
	   */
	  public void InNum() {
		//签到人数
		 	int innum=0;
		 	 for(int i = 0;i<100;i++) {
		     	if( stuList.get(i).getIncome()==1) {
		     		innum += 1;
		     	}
		     }
		 	System.out.println("Fib.main(已签到人数：)"+innum);
	}
}
