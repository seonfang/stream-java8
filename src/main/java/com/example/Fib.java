package com.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *  main()方法
 * @author seon
 *2017年11月24日16:14:40
 */
public class Fib {
	//全部学生列表
	static List<Student> stuList ;
	//已签到学生列表
	static List<Student> stuInList;
	
  public static void main(String[] args) {
	  //上台阶问题
    Stream<Long> longStream = Stream.generate(new FibonacciSupplier());
    System.out.println("Fib.main(台阶问题：)");
    longStream.limit(10).forEach(System.out::println);
  
    //自动生成100个对象
    stuList = proStu();
    while (true) {
		System.out.println("请选择功能：1.签到  2.统计签到人数  3.查询是否签到  4.查询所有已签到人信息  5.查询所有人信息 6.退出");
	    Scanner sc  = new Scanner(System.in);
	    int n = sc.nextInt();
	    switch (n) {
			case 1:
				toInCome();
				break;
			case 2:
				InNum();
				break;
			case 3:
				IsInCome();
				break;
			case 4:
				ShowInList();
				break;
			case 5:
				ShowList();
				break;
			case 6:
				System.out.println("已成功退出");
					return;
			default:
				System.out.println("命令输入错误，请重新输入：");
				break;
		}
	}
  }
  
  /**
   * 展示所有学生信息
   */
  private static void ShowList() {
	System.out.println(stuList);
	
}

/**
   * 查询所有签到人信息
   */
  private static void ShowInList() {
	  for(int i = 0;i<100;i++) {
	    		if(stuList.get(i).getIncome() == 1) {
	    			System.out.println(stuList.get(i));
	    		}
	    }
}

  /**
   * 根据ID查询是否签到
   */
private static void IsInCome() {
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
  public static List<Student> proStu() {
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
  public static void toInCome() {
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
  private static void InNum() {
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
