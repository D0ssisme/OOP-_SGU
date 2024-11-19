import java.util.Arrays;
import java.util.Scanner;
public class DSChiTietPhieuNhap {
    private int n;
    public static ChiTietPhieuNhap[] dschitietphieunhap =new ChiTietPhieuNhap[1];
    public ChiTietPhieuNhap[] getDanhSach()
    {
        return dschitietphieunhap;
    }
    public DSChiTietPhieuNhap()
    {

    }
    public DSChiTietPhieuNhap(DSChiTietPhieuNhap temp)
    {
        this.n=temp.n;
        this.dschitietphieunhap =temp.dschitietphieunhap;
    }
    public DSChiTietPhieuNhap(int n,ChiTietPhieuNhap[]ds)
    {
        this.n=n;
        this.dschitietphieunhap =ds;
    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập số lượng chi tiết phiếu nhập :");
        n=scanner.nextInt();
        dschitietphieunhap =new ChiTietPhieuNhap[n];
        for(int i=0;i<n;i++)
        {
            dschitietphieunhap[i]=new ChiTietPhieuNhap ();
            dschitietphieunhap[i].nhap();

        }

    }
    public void xuat()
    {
        for(int i=0;i<n;i++)
        {
            dschitietphieunhap[i].xuat();
        }
    }
    public void them()
    {
        dschitietphieunhap = Arrays.copyOf(dschitietphieunhap, dschitietphieunhap.length+1);
        dschitietphieunhap[n]=new ChiTietPhieuNhap();
        dschitietphieunhap[n].nhap();
        n++;
    }
    public void them(ChiTietPhieuNhap temp)
    {
        dschitietphieunhap =Arrays.copyOf(dschitietphieunhap, dschitietphieunhap.length+1);
        dschitietphieunhap[n]=new ChiTietPhieuNhap(temp);
        n++;
    }
    public void xoa(String mapn)
    {
        for(int i=0;i<n;i++)
        {
            if(dschitietphieunhap[i].getMapn().equals(mapn))
            {
                for(int j=i;j<n-1;j++)
                {
                    dschitietphieunhap[j]= dschitietphieunhap[j+1];

                }
                dschitietphieunhap =Arrays.copyOf(dschitietphieunhap, dschitietphieunhap.length-1);
                n--;
            }

        }
    }
    public void sua(String mapnold,String mapnnew)
    {

        for(int i=0;i<n;i++)
        {
            if(dschitietphieunhap[i].getMapn().equals(mapnold))
            {

                dschitietphieunhap[i].setMaPN(mapnnew);

            }
        }


    }
    public ChiTietPhieuNhap timKiemTheoMaPN(String mapn)
    {
        for(int i=0;i<n;i++)
        {
            if(dschitietphieunhap[i].getMapn().equals(mapn))
            {
                return dschitietphieunhap[i];
            }

        }
        return null;

    }
    public double tinhTongTienTheoMaPN(String mapn)
    {
        double tongtien=0;
        for(int i=0;i<n;i++)
        {
            if(dschitietphieunhap[i].getMapn().equals(mapn))
            {
                tongtien=tongtien+ dschitietphieunhap[i].getThanhTien();
            }
        }
        return tongtien;
    }

}
