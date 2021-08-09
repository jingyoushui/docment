package Observer0;

import java.util.ArrayList;

//管理者
public class Manager implements IManager{
    private String name;

    private String position;
    //他的手下列表
    ArrayList<Staff> subordinateList = new ArrayList<Staff>();

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    //增加一个手下
    @Override
    public void addSubordinate(Staff staff) {
        this.subordinateList.add(staff);

    }

    @Override
    public void removeSubordinate(Staff staff) {
        this.subordinateList.remove(staff);

    }

    //查看我的手下
    @Override
    public ArrayList<Staff> getSubordinate() {
        return this.subordinateList;
    }

    @Override
    public String getInfo() {
        String info = "姓名："+this.name+"，职位："+this.position;
        return info;
    }

    @Override
    public void doSomething(String notice) {
        System.out.println(this.name+","+this.position+","+notice);
    }
    //通知手下的方法
    @Override
    public void notifyStaff(String notice1,String notice2){
        ArrayList<Staff> subordinateList = this.getSubordinate();
        for(Staff s:subordinateList){
            //如果手下是程序员，调用程序员的接收通知的方法
            if(s instanceof Programmer){
                ((Programmer) s).doSomething(notice1);
            }else {
                //手下是管理者，调用管理者的接收通知的方法，同时将通知再向下级传递
                ((Manager) s).doSomething(notice2);
                ((Manager) s).notifyStaff(notice1,notice2);
            }
        }
    }


}
