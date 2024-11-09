import java.util.Scanner;

public class QuatHoiNuoc extends Quat {
    private String dungtich;
    private String chedophun;

    public String getDungTich() {
        return dungtich;

    }

    public String getCheDoPhun() {
        return chedophun;
    }

    public void setDungTich(String dungtich) {
        this.dungtich = dungtich;

    }

    public void setCheDoPhun() {
        this.chedophun = chedophun;
    }

    public QuatHoiNuoc(String masp, String tensp, String ngaysanxuat, String soluong, double gia, String thuonghieu,
            String trongluong, String congsuat, String dungtich, String chedophun) {
        super(masp, tensp, ngaysanxuat, soluong, gia, thuonghieu, trongluong, congsuat);
        this.dungtich = dungtich;
        this.chedophun = chedophun;

    }
    public QuatHoiNuoc(QuatHoiNuoc temp)
    {
        super((Quat)temp);
        this.chedophun=temp.chedophun;
        this.dungtich=temp.dungtich;

    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        super.nhap();
        System.out.print("dung tich : ");
        dungtich=scanner.nextLine();
        System.out.print("che do phun : ");
        chedophun=scanner.nextLine();
    }
    public void xuat()
    {
        super.xuat();
        System.out.printf("",dungtich,chedophun);
    }

}
