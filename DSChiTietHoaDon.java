import java.util.Arrays;
import java.util.Scanner;
public class DSChiTietHoaDon {
    private int n;
    public static ChiTietHoaDon[] dschitiethoadon =new ChiTietHoaDon[1];
    public DSChiTietHoaDon()
    {

    }
    public DSChiTietHoaDon(int n,ChiTietHoaDon[]ds)
    {
        this.n=n;
        this.dschitiethoadon =ds;
    }
    public DSChiTietHoaDon(DSChiTietHoaDon temp)
    {
        this.n=temp.n;
        this.dschitiethoadon =temp.dschitiethoadon;
    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập số lượng chi tiết hóa đơn :");
        n=scanner.nextInt();
        dschitiethoadon =new ChiTietHoaDon[n];
        for(int i=0;i<n;i++)
        {
            dschitiethoadon[i]=new ChiTietHoaDon();
            dschitiethoadon[i].nhap();

        }

    }
    public void xuat()
    {
        for(int i=0;i<n;i++)
        {
            dschitiethoadon[i].xuat();
        }

    }
    public void them()
    {
        dschitiethoadon = Arrays.copyOf(dschitiethoadon, dschitiethoadon.length+1);
        dschitiethoadon[n]=new ChiTietHoaDon();
        dschitiethoadon[n].nhap();
        n++;
    }
    public void them(ChiTietHoaDon ds1)
    {
        dschitiethoadon =Arrays.copyOf(dschitiethoadon, dschitiethoadon.length+1);
        dschitiethoadon[n]=new ChiTietHoaDon(ds1);
        n++;

    }
    public void xoaTheoMaHD(String mahd)
    {
        for(int i=0;i<n;i++)
        {
            if(dschitiethoadon[i].getMaHD().equals(mahd))
            {
                for(int j=i;j<n-1;j++)
                {
                    dschitiethoadon[j]= dschitiethoadon[j+1];
                }
                dschitiethoadon =Arrays.copyOf(dschitiethoadon, dschitiethoadon.length-1);
                n--;
            }
        }
    }
    public void sua(String mahdold,String mahdnew)
    {
        for(int i=0;i<n;i++)
        {
            if(dschitiethoadon[i].getMaHD().equals(mahdold))
            {
                dschitiethoadon[i].setMaHD(mahdnew);
            }
        }
    }
    public double tinhTongTien(String mahd)
    {
        double tongtien=0;
        for(int i=0;i<n;i++)
        {
            if(dschitiethoadon[i].getMaHD().equals(mahd))
            {
                tongtien=tongtien+ dschitiethoadon[i].getThanhTien();
            }
        }
        return tongtien;
    }
}
