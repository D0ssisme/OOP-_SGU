import java.util.Scanner;

public class QuatDien extends Quat {
    private int socanhquat;
    private String dodaicanhquat;

    public int getSoCanhQuat() {
        return socanhquat;
    }

    public String getCheDoGio() {
        return dodaicanhquat;
    }

    public void setSoCanhQuat(int socanhquat) {
        this.socanhquat = socanhquat;
    }

    public void setCheDoGio(String chedogio) {
        this.dodaicanhquat = chedogio;

    }

    public QuatDien() {
        super();
    }

    public QuatDien(String masp, String tensp, String ngaysanxuat, String soluong, double gia, String thuonghieu,
            String trongluong, String congsuat, int socanhquat, String chedogio) {
        super(masp, tensp, ngaysanxuat, soluong, gia, thuonghieu, trongluong, congsuat);
        this.socanhquat = socanhquat;
        this.dodaicanhquat = chedogio;

    }

    public QuatDien(QuatDien temp) {
        super((Quat) temp);
        socanhquat = temp.socanhquat;
        dodaicanhquat = temp.dodaicanhquat;

    }

    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("so canh quat : ");
        socanhquat = scanner.nextInt();
        scanner.nextLine();
        System.out.print("che do gio : ");
        dodaicanhquat = scanner.nextLine();

    }

    public void xuat() {
        super.xuat(); // Gọi phương thức xuat() của lớp cha để in các thông tin chung
        // In các thông tin riêng của QuatDien
        System.out.printf("%-16s %-17s %-17s %-17s%n",
                socanhquat, dodaicanhquat, "-", "-");
    }
}
