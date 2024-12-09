import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class DSChiTietHoaDon implements DanhSach {
    public int n;
    public  ChiTietHoaDon[] dschitiethoadon =new ChiTietHoaDon[1];
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


    public void docfile() {
        int i = 0;
        String filePath = "chitiethoadon.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            this.dschitiethoadon = new ChiTietHoaDon[Integer.parseInt(line)];

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                this.dschitiethoadon[i] = new ChiTietHoaDon();
                this.dschitiethoadon[i].setMaHD(data[0]);
                this.dschitiethoadon[i].setMaSp(data[1]);
                this.dschitiethoadon[i].setSoLuong(Integer.parseInt(data[2]));
                this.dschitiethoadon[i].setDonGia(Double.parseDouble(data[3]));
                this.dschitiethoadon[i].setThanhTien(Double.parseDouble(data[4]));

                i++;
            }

            System.out.println("Đã đọc xong!");
            this.n=i;


        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi đọc file: " + e.getMessage());
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
    public void xoa(String mahd)
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
    public void sua(String mahd)
    {
        Scanner scanner=new Scanner(System.in);
        String mahdnew=scanner.nextLine();
        for(int i=0;i<n;i++)
        {
            if(dschitiethoadon[i].getMaHD().equals(mahd))
            {
                dschitiethoadon[i].setMaHD(mahdnew);
            }
        }
    }

    public void timChiTietHoaDonTheoMaHD(String mahd)
    {
        for(int i=0;i<n;i++)
        {
            if(dschitiethoadon[i].getMaHD().equals(mahd))
            {
                dschitiethoadon[i].xuat();
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
