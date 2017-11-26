package com.example;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *  main()方法
 * @author seon
 *2017年11月24日16:14:40
 */

@SpringBootApplication
public class Fib {
	@Autowired
	private StuService stuService;
	public static void main(String[] args) {
		  //上台阶问题
	    Stream<Long> longStream = Stream.generate(new FibonacciSupplier());
	    System.out.println("Fib.main(台阶问题：)");
	    longStream.limit(10).forEach(System.out::println);
	    //签到问题
		SpringApplication.run(Fib.class, args);
	}
	
	/**
	 * CommandLineRunner这个接口只有一个函数：public void run(String... args)，
	 * 最重要的是：这个方法会在应用程序启动后首先被调用。
	 * @return
	 */
	@Bean
	public CommandLineRunner	 runner() {
	    //自动生成100个对象
	    List<Student> stuList = stuService.proStu();
	    while (true) {
			System.out.println("请选择功能：1.签到  2.统计签到人数  3.查询是否签到  4.查询所有已签到人信息  5.查询所有人信息 6.退出");
		    Scanner sc  = new Scanner(System.in);
		    int n = sc.nextInt();
		    switch (n) {
				case 1:
					stuService.toInCome();
					break;
				case 2:
					stuService.InNum();
					break;
				case 3:
					stuService.IsInCome();
					break;
				case 4:
					stuService.ShowInList();
					break;
				case 5:
					stuService.ShowList();
					break;
				case 6:
					System.out.println("已成功退出");
					System.exit(0);
//						break;
				default:
					System.out.println("命令输入错误，请重新输入：");
					break;
			}
		}
	   
	}

}
