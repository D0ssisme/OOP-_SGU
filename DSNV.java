import java.util.Scanner;
import java.util.Arrays;

public class DSNV {
    private NhanVien[] ds = new NhanVien[1];
    private int n;

    public DSNV() {

    }

    public DSNV(NhanVien[] temp, int n) {
        this.ds = temp;
        this.n = n;

    }

    public DSNV(DSNV temp) {
        this.ds = temp.ds;
        this.n = temp.n;

    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap so luong nhan vien : ");
        n = scanner.nextInt();
        ds = new NhanVien[n];
        if (n <= 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            ds[i] = new NhanVien();
            ds[i].nhap();
        }

    }

    public void xuat() {
        if (n == 0) {
            System.out.print("danh sach hien dang rong !");
            return;
        }
        System.out.printf("%-10s %-15s %-15s %-10s %-15s %-15s %-15s %-20s\n",
                "Mã NV", "Họ", "Tên", "Lương", "Chức vụ", "SĐT", "CCCD", "Địa chỉ");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            ds[i].xuat();
        }

    }

    public void them() {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[n] = new NhanVien();
        ds[n].nhap();
        n++;
    }

    public void them1NhanVien(NhanVien temp) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[n] = new NhanVien(temp);
        n++;

    }

    public void themKNhanVien(int k) {
        for (int i = 1; i <= k; i++) {
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[n] = new NhanVien();
            ds[n].nhap();
            n++;

        }
    }

    public void sua(String manv) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaNV().equals(manv)) {

                System.out.print("nhap vao ma sinh vien moi :");
                String masvnew = scanner.nextLine();
                ds[i].setMaNV(masvnew);
                return;

            }
        }
        System.out.print("khong tim thay ma nhan vien " + manv + "vui long kiem tra lai !");

    }

    public void xoa(String manv) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaNV().equals(manv)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];

                }
                ds = Arrays.copyOf(ds, ds.length - 1);
                n--;
                return;
            }
        }
        System.out.print("khong thay ma nhan vien " + manv + " vui long kiem tra lai !");

    }

    public NhanVien timKiemNhanVienTheoMa(String manv) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaNV().equals(manv)) {
                return ds[i];
            }
        }
        return null;

    }
    

}
