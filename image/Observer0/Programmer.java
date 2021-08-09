package Observer0;

public class Programmer implements IProgrammer{
    private String name;
    private String position;

    public Programmer(String name,String position) {
        this.name = name;
        this.position = position;
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
}
