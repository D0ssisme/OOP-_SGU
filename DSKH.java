import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class DSKH implements DanhSach {
    public KhachHang [] dskhachhang =new KhachHang[1];
    public int n;

    public DSKH ()
    {

    }
    public DSKH(KhachHang[]ds,int n)
    {
        this.dskhachhang =ds;
        this.n=n;
    }
    public DSKH(DSKH temp)
    {
        this.dskhachhang =temp.dskhachhang;
        this.n=temp.n;

    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập số lượng khách hàng : ");
        n=scanner.nextInt();
        dskhachhang =new KhachHang[n];
        for(int i=0;i<n;i++)
        {
            dskhachhang[i]=new KhachHang();
            dskhachhang[i].nhap();
        }

    }
    public void xuat()
    {
        System.out.println("===========================================================================================");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "Mã KH", "Họ KH", "Tên KH", "Số điện thoại", "Tổng tiền");
        System.out.println("===========================================================================================");
        for(int i=0;i<n;i++)
        {
            dskhachhang[i].xuat();
        }
    }


    public void docfile() {
        int i = 0;
        String filePath = "khachhang.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            this.dskhachhang = new KhachHang[Integer.parseInt(line)];

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                this.dskhachhang[i] = new KhachHang();
                this.dskhachhang[i].setMakh(data[0]);
                this.dskhachhang[i].setHoKH(data[1]);
                this.dskhachhang[i].setTenKH(data[2]);
                this.dskhachhang[i].setSDT(data[3]);
                this.dskhachhang[i].setTongTien(Double.parseDouble(data[4]));

                i++;
            }

            System.out.println("Đã đọc xong!");
            this.n=i;


        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi đọc file: " + e.getMessage());
        }
    }

    public boolean checkmakh(String makh)
    {
        DSKH ds=new DSKH();
        ds.dskhachhang=Arrays.copyOf(QLBH.dskhachhang,ds.dskhachhang.length);
        for(KhachHang q:dskhachhang)
        {
            if(q.getMaKh().equals(makh))
            {
                return false;
            }
        }
        return true;
    }


    public void them()
    {
        dskhachhang =Arrays.copyOf(dskhachhang, dskhachhang.length+1);
        dskhachhang[n]=new KhachHang();
        dskhachhang[n].nhap();
        n++;

    }
    public void them(KhachHang temp)
    {
        dskhachhang =Arrays.copyOf(dskhachhang, dskhachhang.length+1);
        dskhachhang[n]=new KhachHang(temp);
        n++;
    }
    public void xoa(String makh)
    {
        for(int i=0;i<n;i++)
        {
            if(dskhachhang[i].getMaKh().equals(makh))
            {
                for(int j=i;j<n-1;j++)
                {
                    dskhachhang[j]= dskhachhang[j+1];
                }
                n--;
            }

        }

    }
    public void sua(String makhold)
    {
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<n;i++)
        {
            if(dskhachhang[i].getMaKh().equals(makhold))
            {
                System.out.print("nhập vào mã khách hàng mới : ");
                String makhnew=scanner.nextLine();
                dskhachhang[i].setMakh(makhnew);
            }
        }
    }
    public KhachHang timKiemTheoMaKH(String makh)
    {
        for(KhachHang q : dskhachhang)
        {
            if(q.getMaKh().equals(makh))
            {
                return q;
            }
        }
        return null;
    }



}
