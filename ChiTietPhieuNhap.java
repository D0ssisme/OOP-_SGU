import java.util.Arrays;
import java.util.Scanner;

public class ChiTietPhieuNhap {
    private String mapn;
    private String masp;
    private int soluong;
    private double dongia;
    private double thanhtien;

    public ChiTietPhieuNhap()
    {

    }
    public ChiTietPhieuNhap(String mapn,String masp,int soluong,double dongia)
    {
        this.mapn=mapn;
        this.masp=masp;
        this.soluong=soluong;
        this.dongia=dongia;
        this.thanhtien=getThanhTien();

    }
    public ChiTietPhieuNhap(ChiTietPhieuNhap temp)
    {
        this.mapn=temp.mapn;
        this.masp=temp.masp;
        this.soluong=temp.soluong;
        this.dongia=temp.dongia;
        this.thanhtien=getThanhTien();
    }
    public String getMapn()
    {
        return mapn;
    }
    public int getSoluong()
    {
        return soluong;
    }
    public double getDonGia()
    {
        return dongia;
    }
    public double getThanhTien()
    {
        return this.soluong*this.dongia;
    }
    public void setMaPN(String mapn)
    {
        this.mapn=mapn;
    }
    public void setMaSP(String masp){this.masp=masp;}

    public void setSoLuong(int soluong)
    {
        this.soluong=soluong;
    }
    public void setDongia(double dongia)
    {
        this.dongia=dongia;

    }
    public void setThanhTien(double thanhtien)
    {
        this.thanhtien=thanhtien;
    }
    public void nhap()
    {
        DSQuat dsQuat=new DSQuat();
        dsQuat.dsquat=Arrays.copyOf(QLBH.dsquat,QLBH.dsquat.length);
        dsQuat.n=QLBH.dsquat.length;

        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập mã phiếu nhập : ");
        mapn=scanner.nextLine();
        System.out.print("nhập mã sản phẩm : ");
        masp=scanner.nextLine();
        System.out.print("số lượng : ");
        soluong=scanner.nextInt();
        dsQuat.timKiemTheoMaSP(masp).setSoLuong(dsQuat.timKiemTheoMaSP(masp).getSoLuong()+soluong);
        System.out.print("đơn giá : ");
        dongia=scanner.nextDouble();
        System.out.print("thành tiền = đơn giá * số lượng ");
    }
    public void nhap(String mapn)
    {
        Scanner scanner=new Scanner(System.in);
        DSQuat dsQuat=new DSQuat();
        dsQuat.dsquat=Arrays.copyOf(QLBH.dsquat,QLBH.dsquat.length);
        dsQuat.n=QLBH.dsquat.length;
        this.mapn=mapn;
        System.out.print("nhập mã sản phẩm : ");
        masp=scanner.nextLine();
        System.out.print("số lượng : ");
        soluong=scanner.nextInt();
        dsQuat.timKiemTheoMaSP(masp).setSoLuong(dsQuat.timKiemTheoMaSP(masp).getSoLuong()+soluong);
        System.out.print("đơn giá : ");
        dongia=scanner.nextDouble();
        System.out.print("thành tiền = đơn giá * số lượng ");
    }
    public void xuat() {
        System.out.println("----- Chi Tiết Phiếu Nhập -----");
        System.out.printf("%-20s: %s\n", "Mã phiếu nhập", mapn);
        System.out.printf("%-20s: %s\n", "Mã sản phẩm", masp);
        System.out.printf("%-20s: %d\n", "Số lượng", soluong);
        System.out.printf("%-20s: %.0f VND\n", "Đơn giá", dongia); // Không có thập phân
        System.out.printf("%-20s: %.0f VND\n", "Thành tiền", getThanhTien()); // Không có thập phân
        System.out.println("--------------------------------");
        System.out.println("\n\n");
    }




}
