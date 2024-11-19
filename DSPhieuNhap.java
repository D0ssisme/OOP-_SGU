import java.util.Arrays;
import java.util.Scanner;
public class DSPhieuNhap {
    private int n;
    public  PhieuNhap[]ds=new PhieuNhap[1];
    public DSPhieuNhap()
    {

    }
    public DSPhieuNhap(DSPhieuNhap temp)
    {
        this.n=temp.n;
        this.ds=temp.ds;
    }
    public DSPhieuNhap(int n,PhieuNhap[]ds)
    {
        this.n=n;
        this.ds=ds;

    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập số lượng phiếu nhập");
        n=scanner.nextInt();
        ds=new PhieuNhap[n];
        for(int i=0;i<n;i++)
        {
            ds[i]=new PhieuNhap();
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
    public void them()
    {
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[n]=new PhieuNhap();
        ds[n].nhap();
        n++;
    }
    public void them(PhieuNhap temp)
    {
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[n]=new PhieuNhap(temp);
        n++;
    }
    public void sua(String mapn)
    {
        
    }


    public void xoaTheoMaPN(String mapn)
    {
        for(int i=0;i<n;i++)
        {
            if(ds[i].getMaPN().equals(mapn))
            {
                for(int j=i;j<n-1;j++)
                {
                    ds[j]=ds[j+1];
                }
                ds= Arrays.copyOf(ds,ds.length-1);
                n--;
            }
        }
    }


}
