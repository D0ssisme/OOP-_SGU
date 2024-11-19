import java.util.Arrays;
import java.util.Scanner;
public class DSHoaDon {
    private int n;
    private HoaDon[]ds=new HoaDon[1];
    public DSHoaDon()
    {

    }
    public DSHoaDon(DSHoaDon temp)
    {
        this.n=temp.n;
        this.ds=temp.ds;
    }
    public DSHoaDon(int n,HoaDon[]ds)
    {
        this.n=n;
        this.ds=ds;
    }
    public void nhap( )
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập số lượng hóa đơn : ");
        n=scanner.nextInt();
        ds=new HoaDon[n];
        for(int i=0;i<n;i++)
        {
            ds[i]=new HoaDon();
            ds[i].nhap();
        }

    }
    public void xuat( )
    {
        for(int i=0;i<n;i++)
        {
            ds[i].xuat();
        }
    }
    public void them( )
    {
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[n]=new HoaDon();
        ds[n].nhap();
        n++;
    }
    public void them(HoaDon temp)
    {
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[n]=new HoaDon(temp);
        n++;
    }
    public void sua(String mahdold,String mahdnew)
    {
        for(int i=0;i<n;i++)
        {
            if(ds[i].getMaHD().equals(mahdold))
            {
                ds[i].setMahd(mahdnew);
            }
        }
    }
    public void xoaTheoMaHD(String mahd)
    {
        for(int i=0;i<n;i++)
        {
            if(ds[i].getMaHD().equals(mahd))
            {
                for(int j=i;j<n-1;j++)
                {
                    ds[j]=ds[j+1];

                }
                ds=Arrays.copyOf(ds,ds.length-1);
                n--;
            }
        }
    }
    public HoaDon timKiemHoaDonTheoMaHD(String mahd)
    {
        for(int i=0;i<n;i++)
        {
            if(ds[i].getMaHD().equals(mahd))
            {
                return ds[i];
            }
        }
        return null;
    }

    public double tinhTongTienTheoMaKH(String makh)
    {
        double tongtien=0;
        for(int i=0;i<n;i++)
        {
            if(ds[i].getMaKH().equals(makh))
            {
                tongtien=tongtien+ds[i].getTongTien();
            }
        }
        return tongtien;
    }

}
