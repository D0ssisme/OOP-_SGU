
import java.util.Arrays;
import java.util.Scanner;
public class DSNCC {
    private int n;
    private NhaCungCap[]ds=new NhaCungCap[1];
    public DSNCC()
    {

    }
    public DSNCC(DSNCC temp)
    {
        this.n=temp.n;
        this.ds=temp.ds;
    }
    public DSNCC(int n,NhaCungCap[]ds)
    {
        this.n=n;
        this.ds=ds;
    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập số lượng nhà cung cấp : ");
        n=scanner.nextInt();
        ds=new NhaCungCap[n];
        for(int i=0;i<n;i++)
        {
            ds[i]=new NhaCungCap();
            ds[i].nhap();
        }

    }
    public void xuat()
    {

    }
    public void them()
    {
        ds= Arrays.copyOf(ds,ds.length+1);
        ds[n]=new NhaCungCap();
        ds[n].nhap();
        n++;
    }
    public void them(NhaCungCap temp)
    {
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[n]=new NhaCungCap(temp);
        n++;

    }
    public void sua(String mancc)
    {
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<n;i++)
        {
            if(ds[i].getMaNCC().equals(mancc))
            {
                String manccnew=scanner.nextLine();
                ds[i].setMaNCC(manccnew);

            }
        }
    }
    public void xoa(String mancc)
    {
        for(int i=0;i<n;i++)
        {
            if(ds[i].getMaNCC().equals(mancc))
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
    public NhaCungCap timKiemTheoMaNCC(String mancc)
    {
        for(int i=0;i<n;i++)
        {
            if(ds[i].getMaNCC().equals(mancc))
            {
                return ds[i];
            }
        }
        return null;
    }


}
