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

    public void setCheDoPhun(String chedophun) {
        this.chedophun = chedophun;
    }

    public QuatHoiNuoc() {
        super();
    }

    public QuatHoiNuoc(String masp, String tensp, String ngaysanxuat, String soluong, double gia, String thuonghieu,
            String trongluong, String congsuat, String dungtich, String chedophun) {
        super(masp, tensp, ngaysanxuat, soluong, gia, thuonghieu, trongluong, congsuat);
        this.dungtich = dungtich;
        this.chedophun = chedophun;

    }

    public QuatHoiNuoc(QuatHoiNuoc temp) {
        super((Quat) temp);
        this.chedophun = temp.chedophun;
        this.dungtich = temp.dungtich;

    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        super.nhap();
        System.out.print("dung tich : ");
        dungtich = scanner.nextLine();
        System.out.print("che do phun : ");
        chedophun = scanner.nextLine();
    }

    public void xuat() {
        super.xuat(); // Gọi phương thức xuat() của lớp cha để in các thông tin chung
        // In các thông tin riêng của QuatHoiNuoc
        System.out.printf("%-16s %-17s %-17s %-17s%n",
                "-", "-", dungtich, chedophun);
    }


}
