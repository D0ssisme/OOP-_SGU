import java.util.Scanner;

public class ChiTietPhieuNhap {
    private String mapn;
    private String masp;
    private double soluong;
    private double dongia;
    private double thanhtien;

    public ChiTietPhieuNhap()
    {

    }
    public ChiTietPhieuNhap(String mapn,String masp,double soluong,double dongia)
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
    public double getSoluong()
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
    public void setSoLuong(double soluong)
    {
        this.soluong=soluong;


    }
    public void setDongia(double dongia)
    {
        this.dongia=dongia;

    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập mã phiếu nhập : ");
        mapn=scanner.nextLine();
        System.out.print("nhập mã sản phẩm : ");
        masp=scanner.nextLine();
        System.out.print("số lượng : ");
        soluong=scanner.nextDouble();
        System.out.print("đơn giá : ");
        dongia=scanner.nextDouble();
        System.out.print("thành tiền = đơn giá * số lượng ");
    }
    public void xuat()
    {
        System.out.print("mã phiếu nhập : "+mapn);
        System.out.print("mã sản phẩm : "+masp);
        System.out.print("số lượng : "+soluong);
        System.out.print("đơn giá : "+dongia);
        System.out.print("thành tiền : "+getThanhTien());
    }





}
