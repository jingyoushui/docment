package Observer0;

//具体的老板-李老板
public class Li_Boss extends Boss {

    //当加班状态发生变化时，要通知程序员最新的加班状态
    public void notify(String note){
        this.notifyProgrammer(note);
    }
}
