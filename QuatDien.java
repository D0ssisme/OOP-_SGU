import java.util.Scanner;

public class QuatDien extends Quat {
    private int socanhquat;
    private String dodaicanhquat;

    public int getSoCanhQuat() {
        return socanhquat;
    }
    public String getDoDaiCanhQuat() {return dodaicanhquat;}

    public void setSoCanhQuat(int socanhquat) {
        this.socanhquat = socanhquat;
    }
    public void setDoDaiCanhQuat(String dodaicanhquat) {this.dodaicanhquat = dodaicanhquat;}

    public QuatDien() {
        super();
    }

    public QuatDien(String masp, String tensp, String ngaysanxuat, int soluong, double gia, String thuonghieu,
            String trongluong, String congsuat, int socanhquat, String dodaicanhquat) {
        super(masp, tensp, ngaysanxuat, soluong, gia, thuonghieu, trongluong, congsuat);
        this.socanhquat = socanhquat;
        this.dodaicanhquat = dodaicanhquat;
    }

    public QuatDien(QuatDien temp) {
        super((Quat) temp);
        socanhquat = temp.socanhquat;
        dodaicanhquat = temp.dodaicanhquat;

    }

    public void baoTri()
    {
        System.out.print("vệ sinh cánh quạt thay moter mới ");
    }

    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("số cánh quạt : ");
        socanhquat = scanner.nextInt();
        scanner.nextLine();
        System.out.print("độ dài cánh quạt : ");
        dodaicanhquat = scanner.nextLine();

    }

    public void xuat() {
        super.xuat(); // Gọi phương thức xuat() của lớp cha để in các thông tin chung
        // In các thông tin riêng của QuatDien
        System.out.printf("%-16s %-17s %-17s %-17s%n",
                socanhquat, dodaicanhquat, "-", "-");
    }
}
