import java.util.Scanner;

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


    public void tinhTongTien(String mapn)
    {
        double tong=0;
        for(ChiTietPhieuNhap temp:DSChiTietPhieuNhap.dschitietphieunhap)
        {
            if(temp.getMapn().equals(mapn))
            {
                tong=tong+temp.getThanhTien();
            }
        }
        this.tongtien=tong;
    }
    public String getMaPN()
    {
        return mapn;
    }
    public double getTongTien()
    {
        return tongtien;
    }
    public void setMaPN(String mapn,DSChiTietPhieuNhap temp)
    {
        this.mapn=mapn;
        this.tongtien=temp.tinhTongTienTheoMaPN(this.mapn);

    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập mã phiếu nhập ");
        mapn=scanner.nextLine();
        tinhTongTien(mapn);
        System.out.print("nhập ngày nhập : ");
        ngaynhap=scanner.nextLine();
        System.out.print("nhập mã nhân viên : ");
        manv=scanner.nextLine();
        System.out.print("nhập mã nhà cung cấp : ");
        mancc= scanner.nextLine();

    }
    public void xuat( )
    {
        System.out.print("mã phiếu nhập : "+mapn);
        System.out.print("ngày nhập : "+ngaynhap);
        System.out.print("mã nhân viên : "+manv);
        System.out.print("mã nhà cung cấp : "+mancc);
        System.out.print("tổng tiền "+tongtien);

    }


}
