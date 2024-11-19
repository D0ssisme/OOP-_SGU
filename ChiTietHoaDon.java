import java.util.Scanner;
public class ChiTietHoaDon {
    private String mahd;
    private String masp;
    private int soluong;
    private double dongia;
    private double thanhtien;
    public String getMaHD()
    {
        return mahd;
    }
    public double getDonGia()
    {
        return dongia;
    }
    public double getThanhTien()
    {
        return thanhtien;
    }
    public String getMasp(){return masp;}

    public void  timDonGia(String masp)
    {
        if(DSQuat.danhsachquat.length>0)
        {
            for (Quat q : DSQuat.danhsachquat) {
                if (q.getMaSP().equals(masp)) {
                    this.dongia = q.getGia();
                    return;
                }
            }
        }

    }

    public void tinhThanhTien()
    {
        this.thanhtien=this.soluong*this.dongia;
    }
    public void setMaHD(String mahd)
    {
        this.mahd=mahd;

    }
    public ChiTietHoaDon()
    {

    }

    public ChiTietHoaDon(ChiTietHoaDon ds )
    {
        this.mahd=ds.mahd;
        this.masp=ds.masp;
        this.soluong=ds.soluong;
        this.dongia=ds.dongia;
        this.thanhtien=ds.thanhtien;

    }
    public ChiTietHoaDon(String mahd,String masp,int soluong,double dongia,double thanhtien)
    {
        this.mahd=mahd;
        this.masp=masp;
        this.soluong=soluong;
        this.dongia=dongia;
        this.thanhtien=thanhtien;
    }

    public void nhap(String mahd)
    {
        this.mahd=mahd;
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập mã sản phẩm : ");
        masp=scanner.nextLine();
        timDonGia(masp);
        System.out.print("nhập số lượng : ");
        soluong=scanner.nextInt();
        tinhThanhTien();
    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("mã hóa đơn :");
        mahd=scanner.nextLine();
        System.out.print("mã sản phẩm : ");
        masp=scanner.nextLine();
        timDonGia(masp);
        System.out.print("số lượng");
        soluong=scanner.nextInt();
        tinhThanhTien();
    }
    public void xuat()
    {
        System.out.print("mã hóa đơn : "+mahd);
        System.out.print("mã sản phẩm : "+masp);
        System.out.print("số lượng : "+soluong);
        System.out.print("đơn giá : "+dongia);
        System.out.print("thành tiền : "+ thanhtien);

    }



}
