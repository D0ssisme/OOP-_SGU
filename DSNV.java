import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class DSNV implements DanhSach {
    public NhanVien[] dsnhanvien = new NhanVien[1];
    public int n;

    public DSNV() {

    }

    public DSNV(NhanVien[] temp, int n) {
        this.dsnhanvien = temp;
        this.n = n;

    }

    public DSNV(DSNV temp) {
        this.dsnhanvien = temp.dsnhanvien;
        this.n = temp.n;

    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap so luong nhan vien : ");
        n = scanner.nextInt();
        dsnhanvien = new NhanVien[n];

        for (int i = 0; i < n; i++) {
            dsnhanvien[i] = new NhanVien();
            dsnhanvien[i].nhap();
        }

    }

    public void xuat() {
        if (n == 0) {
            System.out.print("danh sach hien dang rong !");
            return;
        }

        for (int i = 0; i < n; i++) {
            dsnhanvien[i].xuat();
        }

    }



    public void docfile() {
        int i = 0;
        String filePath = "nhanvien.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            this.dsnhanvien = new NhanVien[Integer.parseInt(line)];

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                this.dsnhanvien[i] = new NhanVien();
                this.dsnhanvien[i].setMaNV(data[0]);
                this.dsnhanvien[i].setHoNV(data[1]);
                this.dsnhanvien[i].setTenNV(data[2]);
                this.dsnhanvien[i].setLuong(Double.parseDouble(data[3]));
                this.dsnhanvien[i].setChucVu((data[4]));
                this.dsnhanvien[i].setSoDienThoai(data[5]);
                this.dsnhanvien[i].setCCCD(data[6]);
                this.dsnhanvien[i].setDiaChi(data[7]);


                i++;
            }

            System.out.println("Đã đọc xong!");
            this.n=i;


        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi đọc file: " + e.getMessage());
        }
    }

    public boolean checkmanv(String manv)
    {
        DSNV ds=new DSNV();
        ds.dsnhanvien=Arrays.copyOf(QLBH.dsnhanvien,QLBH.dsphieunhap.length);
        for(NhanVien q:dsnhanvien)
        {
            if(q.getMaNV().equals(manv))
            {
                return false;
            }
        }
        return true;
    }







    public void them() {
        dsnhanvien = Arrays.copyOf(dsnhanvien, dsnhanvien.length + 1);
        dsnhanvien[n] = new NhanVien();
        dsnhanvien[n].nhap();
        n++;
    }

    public void them1NhanVien(NhanVien temp) {
        dsnhanvien = Arrays.copyOf(dsnhanvien, dsnhanvien.length + 1);
        dsnhanvien[n] = new NhanVien(temp);
        n++;

    }

    public void themKNhanVien(int k) {
        for (int i = 1; i <= k; i++) {
            dsnhanvien = Arrays.copyOf(dsnhanvien, dsnhanvien.length + 1);
            dsnhanvien[n] = new NhanVien();
            dsnhanvien[n].nhap();
            n++;

        }
    }

    public void sua(String manv) {
        Scanner scanner = new Scanner(System.in);
        String manvnew=scanner.nextLine();
        for (int i = 0; i < n; i++) {
            if (dsnhanvien[i].getMaNV().equals(manv)) {

                dsnhanvien[i].setMaNV(manvnew);


            }
        }


    }

    public void xoa(String manv) {
        for (int i = 0; i < n; i++) {
            if (dsnhanvien[i].getMaNV().equals(manv)) {
                for (int j = i; j < n - 1; j++) {
                    dsnhanvien[j] = dsnhanvien[j + 1];

                }
                dsnhanvien = Arrays.copyOf(dsnhanvien, dsnhanvien.length - 1);
                n--;
                return;
            }
        }
        System.out.print("khong thay ma nhan vien " + manv + " vui long kiem tra lai !");

    }

    public NhanVien timKiemNhanVienTheoMa(String manv) {
        for (int i = 0; i < n; i++) {
            if (dsnhanvien[i].getMaNV().equals(manv)) {
                return dsnhanvien[i];
            }
        }
        return null;

    }

    public void thongKeTongTienHoaDonTheoNhanVien() {
        DSHoaDon dsHoaDon = new DSHoaDon();
        dsHoaDon.dshoadon = Arrays.copyOf(QLBH.dshoadon, QLBH.dshoadon.length); // Sao chép danh sách hóa đơn
        double tong = 0;

        System.out.println("=======================================================");
        System.out.printf("| %-30s | %-15s |\n", "Mã Nhân Viên", "Tổng Tiền HD (VND)");
        System.out.println("=======================================================");
        for (NhanVien nv : dsnhanvien) {
            for (HoaDon hd : dsHoaDon.dshoadon) {
                if (nv.getMaNV().equals(hd.getMaNV())) {
                    tong += hd.getTongTien();
                }
            }

            System.out.printf("| %-30s | %-18.0f |\n", nv.getMaNV(), tong);
            tong = 0; // Reset tổng tiền cho nhân viên tiếp theo
        }

        System.out.println("=======================================================");
    }




}
