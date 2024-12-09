
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class DSNCC implements DanhSach{
    public int n;
    public NhaCungCap[] dsnhacungcap =new NhaCungCap[1];
    public DSNCC()
    {

    }
    public DSNCC(DSNCC temp)
    {
        this.n=temp.n;
        this.dsnhacungcap =temp.dsnhacungcap;
    }
    public DSNCC(int n,NhaCungCap[]ds)
    {
        this.n=n;
        this.dsnhacungcap =ds;
    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập số lượng nhà cung cấp : ");
        n=scanner.nextInt();
        dsnhacungcap =new NhaCungCap[n];
        for(int i=0;i<n;i++)
        {
            dsnhacungcap[i]=new NhaCungCap();
            dsnhacungcap[i].nhap();
        }

    }

    public void xuat() {
        if (n == 0) {
            System.out.print("danh sach hien dang rong !");
            return;
        }

        for (int i = 0; i < n; i++) {
            dsnhacungcap[i].xuat();
        }

    }



    public void docfile() {
        int i = 0;
        String filePath = "nhacungcap.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            this.dsnhacungcap = new NhaCungCap[Integer.parseInt(line)];

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                this.dsnhacungcap[i] = new NhaCungCap();
                this.dsnhacungcap[i].setMaNCC(data[0]);
                this.dsnhacungcap[i].setTenNCC(data[1]);
                this.dsnhacungcap[i].setSDTNCC(data[2]);
                this.dsnhacungcap[i].setDiaChiNCC(data[3]);


                i++;
            }

            System.out.println("Đã đọc xong!");
            this.n=i;


        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi đọc file: " + e.getMessage());
        }
    }


    public boolean checkmancc(String macc)
    {
        DSNCC ds=new DSNCC();
        ds.dsnhacungcap=Arrays.copyOf(QLBH.dsnhacungcap,QLBH.dsnhacungcap.length);
        for(NhaCungCap q:dsnhacungcap)
        {
            if(q.getMaNCC().equals(macc))
            {
                return false;
            }
        }
        return true;
    }


















    public void them()
    {
        dsnhacungcap = Arrays.copyOf(dsnhacungcap, dsnhacungcap.length+1);
        dsnhacungcap[n]=new NhaCungCap();
        dsnhacungcap[n].nhap();
        n++;
    }
    public void them(NhaCungCap temp)
    {
        dsnhacungcap =Arrays.copyOf(dsnhacungcap, dsnhacungcap.length+1);
        dsnhacungcap[n]=new NhaCungCap(temp);
        n++;

    }
    public void sua(String mancc)
    {
        Scanner scanner=new Scanner(System.in);
        String manew=scanner.nextLine();
        for(int i=0;i<n;i++)
        {
            if(dsnhacungcap[i].getMaNCC().equals(mancc))
            {

                dsnhacungcap[i].setMaNCC(manew);

            }
        }
    }
    public void xoa(String mancc)
    {
        for(int i=0;i<n;i++)
        {
            if(dsnhacungcap[i].getMaNCC().equals(mancc))
            {
                for(int j=i;j<n-1;j++)
                {
                    dsnhacungcap[j]= dsnhacungcap[j+1];

                }
                dsnhacungcap =Arrays.copyOf(dsnhacungcap, dsnhacungcap.length-1);
                n--;
            }
        }
    }
    public NhaCungCap timKiemTheoMaNCC(String mancc)
    {
        for(int i=0;i<n;i++)
        {
            if(dsnhacungcap[i].getMaNCC().equals(mancc))
            {
                return dsnhacungcap[i];
            }
        }
        return null;
    }


}
