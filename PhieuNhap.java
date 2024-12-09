import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;

public class PhieuNhap {
    private String mapn;
    private String ngaynhap;
    private String manv;
    private String mancc;
    private double tongtien;
    public PhieuNhap()
    {

    }
    public PhieuNhap(PhieuNhap temp)
    {
        this.mapn=temp.mapn;
        this.ngaynhap=temp.ngaynhap;
        this.manv=temp.manv;
        this.mancc=temp.mancc;
        this.tongtien=temp.tongtien;


    }
    public PhieuNhap(String mapn,String ngaynhap,String manv,String mancc,double tongtien)
    {
        this.mapn=mapn;
        this.ngaynhap=ngaynhap;
        this.manv=manv;
        this.mancc=mancc;
        this.tongtien=tongtien;
    }

//tính tổng tiền phiếu nhập theo tổng thành tiền bên chi tiết pn
    public void tinhTongTien(String mapn)
    {
        double tong=0;
        DSChiTietPhieuNhap dschitietphieunhap=new DSChiTietPhieuNhap();
        for(ChiTietPhieuNhap temp:dschitietphieunhap.dschitietphieunhap)
        {
            if(temp.getMapn().equals(mapn))
            {
                tong=tong+temp.getThanhTien();
            }
        }
        this.tongtien=tong;
    }

    public String getNgayNhap()
    {
        return ngaynhap;
    }
    public String getMaPN()
    {
        return mapn;
    }
    public String getMaNV()
    {
        return manv;
    }
    public String getMaNCC()
    {
        return mancc;
    }
    public double getTongTien()
    {
        return tongtien;
    }
    public void setMaPN(String mapn)
    {
        this.mapn=mapn;
    }
    public void setNgayNhap(String ngaynhap)
    {
        this.ngaynhap=ngaynhap;
    }
    public void setMaNV(String manv)
    {
        this.manv=manv;
    }
    public void setMaNCC(String mancc)
    {
        this.mancc=mancc;
    }
    public void setTongTien(double tongtien)
    {
        this.tongtien=tongtien;
    }
    public void nhap()
    {
        DSPhieuNhap ds=new DSPhieuNhap();
        ds.dsphieunhap= Arrays.copyOf(QLBH.dsphieunhap,QLBH.dsphieunhap.length);

        Scanner scanner=new Scanner(System.in);
        do {
            System.out.print("nhập mã phiếu nhập ");
            mapn = scanner.nextLine();
            if(ds.checkmapn(mapn)==false)
            {
                System.out.println(" ma phieu nhap da ton tai !");
            }

        }while(ds.checkmapn(mapn)==false);

        System.out.print("nhập ngày nhập : ");
        ngaynhap=scanner.nextLine();
        System.out.print("nhập mã nhân viên : ");
        manv=scanner.nextLine();
        System.out.print("nhập mã nhà cung cấp : ");
        mancc= scanner.nextLine();
        System.out.println("nhập tổng tiền : ");
        tongtien=scanner.nextDouble();

    }
    public void nhap(String mapn)
    {

        Scanner scanner=new Scanner(System.in);
        this.mapn=mapn;
        System.out.print("nhập ngày nhập : ");
        ngaynhap=scanner.nextLine();
        System.out.print("nhập mã nhân viên : ");
        manv=scanner.nextLine();
        System.out.print("nhập mã nhà cung cấp : ");
        mancc= scanner.nextLine();
        System.out.println("nhập tổng tiền : ");
        tongtien=scanner.nextDouble();

    }


    public void xuat() {
        // Đảm bảo in số tiền chính xác mà không làm tròn hay định dạng thêm
        System.out.println("----- THÔNG TIN PHIẾU NHẬP -----");
        System.out.printf("Mã phiếu nhập       : %-10s\n", mapn);
        System.out.printf("Ngày nhập           : %-10s\n", ngaynhap);
        System.out.printf("Mã nhân viên        : %-10s\n", manv);
        System.out.printf("Mã nhà cung cấp     : %-10s\n", mancc);
        System.out.printf("Tổng tiền           : %-5.0f VND\n", tongtien);
        System.out.println("-----------------------------------");
    }



}
