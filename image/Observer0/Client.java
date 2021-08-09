package Observer0;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) throws InterruptedException {
//        Li_Boss boss = new Li_Boss();
//        Programmer programmer1 = new Programmer("小强","程序员");
//        Programmer programmer2 = new Programmer("小华","程序员");
//        //将上面两个程序员添加到老板类里的程序员列表中
//        boss.attach(programmer1);
//        boss.attach(programmer2);
//        //老板发布通知，今晚加班
//        boss.notify("今晚加班");
        Manager boss = new Manager("李大头","老板");
        Manager RDManger = new Manager("张三","研发部经理");
        Manager marketingManager  = new Manager("李四","市场部经理");
        Manager group1 = new Manager("王五","研发部组长一");
        Manager group2 = new Manager("赵六","研发部组长二");
        Programmer programmer1 = new Programmer("小强","java程序员");
        Programmer programmer2 = new Programmer("小华","java程序员");
        Programmer programmer3 = new Programmer("小甲","python程序员");
        Programmer programmer4 = new Programmer("小乙","c++程序员");

        boss.addSubordinate(RDManger);
        boss.addSubordinate(marketingManager);
        RDManger.addSubordinate(group1);
        RDManger.addSubordinate(group2);


        group1.addSubordinate(programmer1);
        group1.addSubordinate(programmer2);
        group2.addSubordinate(programmer3);
        group2.addSubordinate(programmer4);
        boss.notifyStaff("今晚加班","来开会");
//        System.out.println(boss.getInfo());
//        System.out.println(getAllInfo(boss));
//        getAllInfo(boss);


    }
    public static String getAllInfo(Manager manager){
        ArrayList<Staff> subordinateList = manager.getSubordinate();
        String info = "";
        for(Staff s:subordinateList){
            if(s instanceof Programmer){
                info = info + s.getInfo() +"\n";
            }else {
                info = info +s.getInfo() +"\n" + getAllInfo((Manager)s);
            }
        }
        return info;
    }
}
