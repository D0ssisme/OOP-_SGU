import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class DSChiTietPhieuNhap implements DanhSach {
    public int n;
    public  ChiTietPhieuNhap[] dschitietphieunhap =new ChiTietPhieuNhap[1];
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



    public void docfile() {
        int i = 0;
        String filePath = "chitietphieunhap.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            this.dschitietphieunhap = new ChiTietPhieuNhap[Integer.parseInt(line)];

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                this.dschitietphieunhap[i] = new ChiTietPhieuNhap();
                this.dschitietphieunhap[i].setMaPN(data[0]);
                this.dschitietphieunhap[i].setMaSP(data[1]);
                this.dschitietphieunhap[i].setSoLuong(Integer.parseInt(data[2]));
                this.dschitietphieunhap[i].setDongia(Double.parseDouble(data[3]));
                this.dschitietphieunhap[i].setThanhTien(Double.parseDouble(data[4]));

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
    public void sua(String mapn)
    {
Scanner scanner=new Scanner(System.in);
String mapnnew=scanner.nextLine();
        for(int i=0;i<n;i++)
        {
            if(dschitietphieunhap[i].getMapn().equals(mapn))
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
