
import java.util.Arrays;
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
    public void setMaHD(String mahd)
    {
        this.mahd=mahd;

    }
    public void setMaSp(String masp)
    {
        this.masp=masp;
    }
    public void setSoLuong(int soluong)
    {
        this.soluong=soluong;

    }
    public void setDonGia(double dongia)
    {
        this.dongia=dongia;
    }
    public void setThanhTien(double thanhtien)
    {
        this.thanhtien=thanhtien;
    }


    public void tinhDonGia(String masp)
    {
        DSQuat dsquat=new DSQuat();
        dsquat.dsquat=Arrays.copyOf(QLBH.dsquat,QLBH.dsquat.length);
        dsquat.n=QLBH.dsquat.length;

        for (Quat q : dsquat.dsquat)
        {
            if(q.getMaSP().equals(masp))
            {
                this.dongia=q.getGia();
            }
        }

    }

    public void tinhThanhTien()
    {
        this.thanhtien=this.soluong*this.dongia;
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
        DSQuat dsQuat=new DSQuat();
        dsQuat.dsquat=Arrays.copyOf(QLBH.dsquat, QLBH.dsquat.length);
        dsQuat.n= QLBH.dsquat.length;
        this.mahd=mahd;
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập mã sản phẩm : ");
        masp=scanner.nextLine();
        tinhDonGia(masp);
        do{
            System.out.print("nhập số lượng : ");
            soluong=scanner.nextInt();
            if(dsQuat.checksoluongtonkho(masp,soluong)==false)
            {
                System.out.print(" hiện số lượng trong kho không đủ chỉ còn "+dsQuat.timKiemTheoMaSP(this.masp).getSoLuong());
            }


        }
        while(dsQuat.checksoluongtonkho(masp,soluong)==false);
        dsQuat.timKiemTheoMaSP(this.masp).setSoLuong(dsQuat.timKiemTheoMaSP(this.masp).getSoLuong()-soluong);
        tinhDonGia(masp);
        tinhThanhTien();
    }
    public void nhap()
    {
        DSQuat dsQuat=new DSQuat();
        dsQuat.dsquat=Arrays.copyOf(QLBH.dsquat, QLBH.dsquat.length);
        dsQuat.n= QLBH.dsquat.length;

        Scanner scanner=new Scanner(System.in);
        System.out.print("mã hóa đơn :");
        mahd=scanner.nextLine();
        System.out.print("mã sản phẩm : ");
        masp=scanner.nextLine();
        tinhDonGia(masp);
        do {
            System.out.print("nhập số lượng : ");
            soluong = scanner.nextInt();

                if (dsQuat.checksoluongtonkho(masp, soluong) == false) {
                    System.out.print(" hiện số lượng trong kho không đủ chỉ còn : " + dsQuat.timKiemTheoMaSP(this.masp).getSoLuong());
                    System.out.println("\n");
                }



        }
        while(dsQuat.checksoluongtonkho(masp,soluong)==false);
        dsQuat.timKiemTheoMaSP(this.masp).setSoLuong(dsQuat.timKiemTheoMaSP(this.masp).getSoLuong()-soluong);
        tinhDonGia(masp);
        tinhThanhTien();
    }
    public void xuat() {
        System.out.println("----- Chi Tiết Hóa Đơn -----");
        System.out.printf("%-15s: %s\n", "Mã hóa đơn", mahd);
        System.out.printf("%-15s: %s\n", "Mã sản phẩm", masp);
        System.out.printf("%-15s: %d\n", "Số lượng", soluong);
        System.out.printf("%-15s: %.0f VND\n", "Đơn giá", dongia);
        System.out.printf("%-15s: %.0f VND\n", "Thành tiền", thanhtien);
        System.out.println("---------------------------");
    }




}
