import java.util.Scanner;

abstract public class Quat {
    private String masp;
    private String tensp;
    private String ngaysanxuat;
    private String soluong;
    private double gia;
    private String thuonghieu;
    private String trongluong;
    private String congsuat;

    public String getMaSP() {
        return masp;

    }

    public double getGia() {
        return gia;
    }

    public void setMaSP(String masp) {
        this.masp = masp;

    }

    public void setGia(double gia) {
        this.gia = gia;

    }

    public Quat() {

    }

    public Quat(Quat temp) {
        this.masp = temp.masp;
        this.tensp = temp.tensp;
        this.ngaysanxuat = temp.ngaysanxuat;
        this.soluong = temp.soluong;
        this.gia = temp.gia;
        this.thuonghieu = temp.thuonghieu;
        this.trongluong = temp.trongluong;
        this.congsuat = temp.congsuat;

    }

    public Quat(String masp, String tensp, String ngaysanxuat, String soluong, double gia, String thuonghieu,
            String trongluong, String congsuat) {
        this.masp = masp;
        this.tensp = tensp;
        this.ngaysanxuat = ngaysanxuat;
        this.soluong = soluong;
        this.gia = gia;
        this.thuonghieu = thuonghieu;
        this.trongluong = trongluong;
        this.congsuat = congsuat;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("masp : ");
        masp = scanner.nextLine();
        System.out.print("tensp : ");
        tensp = scanner.nextLine();
        System.out.print("ngay san xuat : ");
        ngaysanxuat = scanner.nextLine();
        System.out.print("so luong : ");
        soluong = scanner.nextLine();
        System.out.print("gia : ");
        gia = scanner.nextDouble();
        System.out.print("thuong hieu : ");
        thuonghieu = scanner.nextLine();
        System.out.print("trong luong : ");
        trongluong=scanner.nextLine();
        System.out.print("cong suat : ");
        congsuat=scanner.nextLine();

    }
    public void xuat()
    {
        System.out.printf("%-14s %-19s %-17s %-10s %-10.2f %-15s %-13s %-13s\n", 
            masp, tensp, ngaysanxuat, soluong, gia, thuonghieu, trongluong, congsuat);

    }

}
