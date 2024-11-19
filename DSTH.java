import java.util.Scanner;
import java.util.Arrays;
public class DSTH {
    private int n;
    private ThuongHieu[] ds=new ThuongHieu[1];
    public DSTH()
    {

    }
    public DSTH(DSTH temp)
    {
        this.n=temp.n;
        this.ds=temp.ds;

    }
    public DSTH(int n,ThuongHieu[] temp)
    {
        this.n=n;
        this.ds= temp;
    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập số lượng thương hiệu : ");
        n=scanner.nextInt();
        ds=new ThuongHieu[n];
        for(int i=0;i<n;i++) {
            ds[i] = new ThuongHieu();
            ds[i].nhap();
        }

    }
    public void xuat()
    {

    }
    public void them()
    {
        ds=Arrays.copyOf(ds,ds.length);
        ds[n]=new ThuongHieu();
        ds[n].nhap();
        n++;
    }
    public void them(ThuongHieu temp)
    {
        ds=Arrays.copyOf(ds,ds.length+1);
        ds[n]=new ThuongHieu(temp);
        n++;
    }
    public void xoa(String mathuonghieu)
    {
        for(int i=0;i<n;i++)
        {
            if(ds[i].getMaThuongHieu().equals(mathuonghieu))
            {
                for(int j=i;j<n-1;j++)
                {
                    ds[j]=ds[j+1];

                }
                ds=Arrays.copyOf(ds,ds.length-1);
                n--;
                return;
            }
        }
        System.out.print("không tìm thấy mã thương hiệu nào như trên !");

    }
    public void sua(String mathuonghieu)
    {
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<n;i++)
        {
            if(ds[i].getMaThuongHieu().equals(mathuonghieu))
            {
                System.out.print("nhập vào mã thương hiệu mới : ");
                String mathuonghieunew=scanner.nextLine();
                ds[i].setMathuonghieu(mathuonghieunew);
                return;

            }

        }

    }
    public ThuongHieu timkiemtheomathuonghieu(String mathuonghieu)
    {
        for(int i=0;i<n;i++)
        {
            if(ds[i].getMaThuongHieu().equals(mathuonghieu))
            {
                return ds[i];
            }
        }
        return null;
    }
}
