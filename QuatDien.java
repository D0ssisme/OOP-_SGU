import java.util.Scanner;

public class QuatDien extends Quat {
    private int socanhquat;
    private String chedogio;

    public int getSoCanhQuat() {
        return socanhquat;
    }

    public String getCheDoGio() {
        return chedogio;
    }

    public void setSoCanhQuat(int socanhquat) {
        this.socanhquat = socanhquat;
    }

    public void setCheDoGio(String chedogio) {
        this.chedogio = chedogio;

    }

    public QuatDien() {
        super();
    }

    public QuatDien(String masp, String tensp, String ngaysanxuat, String soluong, double gia, String thuonghieu,
            String trongluong, String congsuat,int socanhquat,String chedogio)
    {
        super(masp,tensp,ngaysanxuat,soluong,gia,thuonghieu,trongluong,congsuat);
        this.socanhquat=socanhquat;
        this.chedogio=chedogio;

    }
    public QuatDien(QuatDien temp)
    {
        super((Quat)temp);
        socanhquat=temp.socanhquat;
        chedogio=temp.chedogio;

    }
    public void nhap()
    {
        super.nhap();
        Scanner scanner=new Scanner(System.in);
        System.out.print("so canh quat : ");
        socanhquat=scanner.nextInt();
        System.out.print("che do gio : ");
        chedogio=scanner.nextLine();


    }
    public void xuat()
    {
        super.xuat();
        System.out.printf(""+socanhquat,chedogio);



    }

}
