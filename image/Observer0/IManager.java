package Observer0;

import java.util.ArrayList;

//管理者接口
public interface IManager extends Staff {
    //增加手下的员工
    public void addSubordinate(Staff staff);
    //获得手下员工的信息
    public ArrayList<Staff> getSubordinate();
    //通知员工
    public void notifyStaff(String note1,String note2);

    //从列表中删除下属成员
    public void removeSubordinate(Staff staff);
}
