import java.util.Scanner;
import java.util.Arrays;

public class DSQuat {
    private Quat[] ds=new Quat[1];
    private int n;
    public DSQuat()
    {

    }
    public DSQuat(int n,Quat[]temp)
    {
        this.n=n;
        this.ds=temp;
    }
    public DSQuat(DSQuat temp)
    {
        this.ds=temp.ds;
        this.n=temp.n;
    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhap so luong quat : ");
        n=scanner.nextInt();
        for(int i=0;i<n;i++)
        {
            
        }


    }


    
}
