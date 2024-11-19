import java.util.Scanner;

public class HoaDon {
    private String mahd;
    private String ngaylaphd;
    private String manv;
    private String makh;
    private double tongtien;
    public double getTongTien()
    {
        return tongtien;
    }
    public void tinhTongTien(String mahd)
    {
        double tong=0;
        for(ChiTietHoaDon q:DSChiTietHoaDon.dschitiethoadon)
        {
            if(q.getMaHD().equals(mahd))
            {
                tong=tong+q.getThanhTien();
            }
        }
        this.tongtien=tong;
    }

    public String getMaHD()
    {
        return mahd;
    }
    public String getMaKH()
    {
        return makh;
    }
    public void setMahd(String mahd)
    {
        this.mahd=mahd;
    }
    public HoaDon()
    {

    }
    public HoaDon(String mahd,String ngaylaphd,String manv,String makh,double tongtien)
    {
        this.mahd=mahd;
        this.ngaylaphd=ngaylaphd;
        this.manv=manv;
        this.makh=makh;
        this.tongtien=tongtien;


    }
    public HoaDon(HoaDon temp)
    {
        this.mahd=temp.mahd;
        this.ngaylaphd=temp.ngaylaphd;
        this.manv=temp.manv;
        this.makh= temp.makh;
        this.tongtien=temp.tongtien;

    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập mã hóa đơn : ");
        mahd=scanner.nextLine();
        tinhTongTien(mahd);
        System.out.print("nhập ngày lập hóa đơn : ");
        ngaylaphd=scanner.nextLine();
        System.out.print("nhập mã nhân viên : ");
        manv=scanner.nextLine();
        System.out.print("nhập mã khách hàng ");
        makh=scanner.nextLine();
    }
    public void xuat()
    {
        System.out.print("mã hóa đơn : "+mahd);
        System.out.print("ngày lập hóa đơn : "+ngaylaphd);
        System.out.print("mã nhân viên : "+manv);
        System.out.print("mã khách hàng : "+makh);
        System.out.print("tổng tiền : "+tongtien);

    }
}
