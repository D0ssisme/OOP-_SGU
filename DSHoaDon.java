import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DSHoaDon implements DanhSach {

    public int n;
    public HoaDon[] dshoadon =new HoaDon[1];

    public HoaDon[] getDSHoaDon()
    {
        return dshoadon;
    }
    public DSHoaDon()
    {

    }
    public DSHoaDon(DSHoaDon temp)
    {
        this.n=temp.n;
        this.dshoadon =temp.dshoadon;
    }
    public DSHoaDon(int n,HoaDon[]ds)
    {
        this.n=n;
        this.dshoadon =ds;
    }
    public void nhap( )
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập số lượng hóa đơn : ");
        n=scanner.nextInt();
        dshoadon =new HoaDon[n];
        for(int i=0;i<n;i++)
        {
            dshoadon[i]=new HoaDon();
            dshoadon[i].nhap();
        }

    }
    public void xuat( )
    {
        for(int i=0;i<n;i++)
        {
            dshoadon[i].xuat();
        }
    }



    public void docfile() {
        int i = 0;
        String filePath = "hoadon.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            this.dshoadon = new HoaDon[Integer.parseInt(line)];

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                this.dshoadon[i] = new HoaDon();
                this.dshoadon[i].setMahd(data[0]);
                this.dshoadon[i].setngayLapHD(data[1]);
                this.dshoadon[i].setMaNV(data[2]);
                this.dshoadon[i].setMaKH(data[3]);
                this.dshoadon[i].setTongTien(Double.parseDouble(data[4]));

                i++;
            }

            System.out.println("Đã đọc xong!");
            this.n=i;


        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi đọc file: " + e.getMessage());
        }
    }

    public boolean checkmahd(String mahd)
    {
        DSHoaDon ds=new DSHoaDon();
        ds.dshoadon=Arrays.copyOf(QLBH.dshoadon,QLBH.dshoadon.length);
        for(HoaDon q :dshoadon)
        {
            if(q.getMaHD().equals(mahd))
            {
                return false;
            }
        }
        return true;

    }





    public void them( )
    {
        dshoadon = Arrays.copyOf(dshoadon, dshoadon.length+1);
        dshoadon[n]=new HoaDon();
        dshoadon[n].nhap();
        n++;
    }
    public void them(HoaDon temp)
    {
        dshoadon = Arrays.copyOf(dshoadon, dshoadon.length+1);
        dshoadon[n]=new HoaDon(temp);
        n++;
    }
    public void sua(String mahd)
    {
        Scanner scanner=new Scanner(System.in);
        String mahdnew=scanner.nextLine();
        for(int i=0;i<n;i++)
        {
            if(dshoadon[i].getMaHD().equals(mahd))
            {
                dshoadon[i].setMahd(mahdnew);
            }
        }
    }
    public void xoa(String mahd)
    {
        for(int i=0;i<n;i++)
        {
            if(dshoadon[i].getMaHD().equals(mahd))
            {
                for(int j=i;j<n-1;j++)
                {
                    dshoadon[j]= dshoadon[j+1];

                }
                dshoadon =Arrays.copyOf(dshoadon, dshoadon.length-1);
                n--;
            }
        }
    }
    public HoaDon timKiemHoaDonTheoMaHD(String mahd)
    {
        for(int i=0;i<n;i++)
        {
            if(dshoadon[i].getMaHD().equals(mahd))
            {
                return dshoadon[i];
            }
        }
        return null;
    }
    public void timKIemHoaDonTheoMaNV(String manv)
    {
        for(HoaDon q:dshoadon)
        {
            if(q.getMaNV().equals(manv))
            {
                q.xuat();
            }
        }
    }
    public void timKiemHodDonTheoMaKH(String makh)
    {
        for(HoaDon q :dshoadon)
        {
            if(q.getMaKH().equals(makh))
            {
                q.xuat();
            }
        }
    }

    public double tinhTongTienTheoMaKH(String makh)
    {
        double tongtien=0;
        for(int i=0;i<n;i++)
        {
            if(dshoadon[i].getMaKH().equals(makh))
            {
                tongtien=tongtien+ dshoadon[i].getTongTien();
            }
        }
        return tongtien;
    }

    public void timKiemHoaDonTheoKhoangThoiGian(String thoidiema, String thoidiemb) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // Sử dụng dateFormat thay vì date
            Date star = dateFormat.parse(thoidiema);
            Date end = dateFormat.parse(thoidiemb);
            System.out.printf("\nHóa đơn lập từ %s đến %s:\n", thoidiema, thoidiemb);


            for (HoaDon q : dshoadon) {
                Date ngaylaphd = dateFormat.parse(q.getNgayLapHD());  // Sử dụng dateFormat để parse
                if (!ngaylaphd.before(star) && !ngaylaphd.after(end)) {
                    q.xuat();
                }
            }
        } catch (ParseException e) {
            System.out.println("Lỗi định dạng ngày tháng! Vui lòng nhập theo định dạng dd/MM/yyyy.");
        }
    }
    public void menuTimKIem()
    {
        Scanner scanner=new Scanner(System.in);
        DSHoaDon ds=new DSHoaDon();
        ds.dshoadon=Arrays.copyOf(QLBH.dshoadon,QLBH.dshoadon.length);
        ds.n=QLBH.dshoadon.length;
        int option;
        while(true)
        {
            System.out.println("1.tim kiem theo ma hoa don");
            System.out.println("2.tim kiem theo ngay lap hoa don ");
            System.out.println("3.tim kiem theo nhan vien lap hoa don");
            System.out.println("4.tim kiem theo khach hang ");
            System.out.println("5.thoat");
            option=scanner.nextInt();
            scanner.nextLine();
            switch (option)
            {
                case 1:
                    System.out.println("nhap ma hoa don muon tim :");
                    String mahd=scanner.nextLine();
                    if(ds.timKiemHoaDonTheoMaHD(mahd)!=null) {
                        ds.timKiemHoaDonTheoMaHD(mahd).xuat();
                    }
                    else {
                        System.out.println("ma hoa don khong ton tai !");
                    }
                    break;
                case 2 :
                    System.out.println("nhap thoi diem bat dau :");
                    String star=scanner.nextLine();
                    System.out.println("nhap thoi diem ket thuc :");
                    String end=scanner.nextLine();
                    ds.timKiemHoaDonTheoKhoangThoiGian(star,end);
                    break;
                case 3 :
                    System.out.println("nhap ma nhan vien :");
                    String manv=scanner.nextLine();
                    ds.timKIemHoaDonTheoMaNV(manv);
                    break;
                case 4:
                    System.out.println("ma khach hang :");
                    String makh=scanner.nextLine();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("nhap sai vui long nhap lai !");


            }
        }
    }




}
