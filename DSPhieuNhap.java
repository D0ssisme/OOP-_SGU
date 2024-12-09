import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
public class DSPhieuNhap implements DanhSach {
    public int n;
    public  PhieuNhap[] dsphieunhap =new PhieuNhap[1];
    public DSPhieuNhap()
    {

    }
    public DSPhieuNhap(DSPhieuNhap temp)
    {
        this.n=temp.n;
        this.dsphieunhap =temp.dsphieunhap;
    }
    public DSPhieuNhap(int n,PhieuNhap[]ds)
    {
        this.n=n;
        this.dsphieunhap =ds;

    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập số lượng phiếu nhập");
        n=scanner.nextInt();
        dsphieunhap =new PhieuNhap[n];
        for(int i=0;i<n;i++)
        {
            dsphieunhap[i]=new PhieuNhap();
            dsphieunhap[i].nhap();
        }

    }
    public void xuat( )
    {

        for(int i=0;i<n;i++)
        {
           dsphieunhap[i].xuat();

        }
    }



    public void docfile() {
        int i = 0;
        String filePath = "phieunhap.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            this.dsphieunhap = new PhieuNhap[Integer.parseInt(line)];

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                this.dsphieunhap[i] = new PhieuNhap();
                this.dsphieunhap[i].setMaPN(data[0]);
                this.dsphieunhap[i].setNgayNhap(data[1]);
                this.dsphieunhap[i].setMaNV(data[2]);
                this.dsphieunhap[i].setMaNCC(data[3]);
                this.dsphieunhap[i].setTongTien(Double.parseDouble(data[4]));

                i++;
            }

            System.out.println("Đã đọc xong!");
            this.n=i;


        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi đọc file: " + e.getMessage());
        }
    }

    public boolean checkmapn(String mapn)
    {
        DSPhieuNhap ds=new DSPhieuNhap();
        ds.dsphieunhap=Arrays.copyOf(QLBH.dsphieunhap,QLBH.dsphieunhap.length);
        for(PhieuNhap q:dsphieunhap)
        {
            if(q.getMaPN().equals(mapn))
            {
                return false;
            }
        }
        return true;
    }







    public void them()
    {
        dsphieunhap =Arrays.copyOf(dsphieunhap, dsphieunhap.length+1);
        dsphieunhap[n]=new PhieuNhap();
        dsphieunhap[n].nhap();
        n++;
    }
    public void them(PhieuNhap temp)
    {
        dsphieunhap =Arrays.copyOf(dsphieunhap, dsphieunhap.length+1);
        dsphieunhap[n]=new PhieuNhap(temp);
        n++;
    }
    public void sua(String mapn)
    {
        Scanner scanner = new Scanner(System.in);
        String mapnnew=scanner.nextLine();
        for(int i=0;i<n;i++)
        {
            if(dsphieunhap[i].getMaPN().equals(mapn))
            {
                dsphieunhap[i].setMaPN(mapnnew);
            }
        }
        
    }


    public void xoa(String mapn)
    {
        for(int i=0;i<n;i++)
        {
            if(dsphieunhap[i].getMaPN().equals(mapn))
            {
                for(int j=i;j<n-1;j++)
                {
                    dsphieunhap[j]= dsphieunhap[j+1];
                }
                dsphieunhap = Arrays.copyOf(dsphieunhap, dsphieunhap.length-1);
                n--;
            }
        }
    }
    public PhieuNhap timKiemTheoMaPN(String mapn)
    {
        for(int i=0;i<n;i++)
        {
            if(dsphieunhap[i].getMaPN().equals(mapn))
            {
                return dsphieunhap[i];
            }
        }
        return null;
    }
    public void timKiemTheoMaNV(String manv)
    {
        DSPhieuNhap ds=new DSPhieuNhap();
        ds.dsphieunhap=Arrays.copyOf(QLBH.dsphieunhap,QLBH.dsphieunhap.length);
        ds.n=QLBH.dsphieunhap.length;
        for(PhieuNhap q:dsphieunhap)
        {
            if(q.getMaNV().equals(manv))
            {
                q.xuat();
            }
        }
    }
    public void timKiemTHeoMaNCC(String mancc)
    {
    DSPhieuNhap ds=new DSPhieuNhap();
    ds.dsphieunhap=Arrays.copyOf(QLBH.dsphieunhap,QLBH.dsphieunhap.length);
    ds.n=QLBH.dsphieunhap.length;
        for(PhieuNhap q:dsphieunhap)
    {
        if(q.getMaNCC().equals(mancc))
        {
            q.xuat();
        }
    }


    }

    public void timKiemPhieuNHapTheoKhoangThoiGian(String thoidiema, String thoidiemb) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {

            Date star = dateFormat.parse(thoidiema);
            Date end = dateFormat.parse(thoidiemb);
            System.out.printf("\nPhiếu Nhập lập từ %s đến %s:\n", thoidiema, thoidiemb);


            for (PhieuNhap q : dsphieunhap) {
                Date ngaylappn = dateFormat.parse(q.getNgayNhap());  // Sử dụng dateFormat để parse
                if (!ngaylappn.before(star) && !ngaylappn.after(end)) {
                    q.xuat();
                }
            }
        } catch (ParseException e) {
            System.out.println("Lỗi định dạng ngày tháng! Vui lòng nhập theo định dạng dd/MM/yyyy.");
        }
    }
    public void menuTimKiem()
    {
        DSPhieuNhap ds=new DSPhieuNhap();
        ds.dsphieunhap=Arrays.copyOf(QLBH.dsphieunhap,QLBH.dsphieunhap.length);
        ds.n=QLBH.dsphieunhap.length;
        Scanner scanner=new Scanner(System.in);
        int option;
        while(true) {
            System.out.println("---------MENU TIM KIEM PHIEU NHAP---------");
            System.out.println("1.Tim kiem theo ma phieu nhap ");
            System.out.println("2.tim kiem theo ngay lap ");
            System.out.println("3.tim kiem theo ma nhan vien");
            System.out.println("tim kiem theo ma nha cung cap ");
            System.out.println("5.thoat");
            option=scanner.nextInt();
            scanner.nextLine();

            switch (option)
            {
                case 1:
                    System.out.println("nhap ma phieu nhap muon tim :");
                    String mapn=scanner.nextLine();
                    if(ds.timKiemTheoMaPN(mapn)!=null) {
                        ds.timKiemTheoMaPN(mapn).xuat();
                    }
                    else
                    {
                        System.out.println("ma phieu nhap khong ton tai !");
                    }
                    break;
                case 2:
                    System.out.println("nhap thoi diem bat dau :");
                    String star=scanner.nextLine();
                    System.out.println("nhap thoi diem ket thuc :");
                    String end=scanner.nextLine();
                    ds.timKiemPhieuNHapTheoKhoangThoiGian(star,end);
                    break;
                case 3:
                    System.out.println("nhap ma nhan vien :");
                    String manv=scanner.nextLine();
                    ds.timKiemTheoMaNV(manv);
                    break;
                case 4:
                    System.out.println("nhap ma nha cung cap :");
                    String mancc=scanner.nextLine();
                    ds.timKiemTHeoMaNCC(mancc);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("nhap sai vui long nhap lai !");
            }
        }


    }



}
