import java.io.*;
import java.util.*;
class sudoku
{
    static int a[][]=new int[9][9];
    private static void rec(int i,int j)
    {
        if(i==8&&j==9)
        {
            print(a);
            System.exit(0);
        }
        if(j>=9)
        {
            j=0;
            i=i+1;
            rec(i,j);
        }
        if(a[i][j]!=0)
        {
            rec(i,j+1);
        }
        else
        {
            for(int k=1;k<=9;k++)
            {
                if(check1(i,j,k)==false && check2(i,j,k)==false)
                {
                    a[i][j]=k;
                    rec(i,j+1);
                }
            }
            a[i][j]=0;
        }
    }

    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        String y[]=new String[9];
        for(int i=0;i<y.length;i++)
        {
            y[i]=sc.nextLine();
        }
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                if(y[i].charAt(j)=='.')
                {
                    a[i][j]=0;
                }
                else
                {
                    a[i][j]=Integer.parseInt(y[i].charAt(j)+"");
                }
            }
        }
        System.out.println();
        rec(0,0);
    }

    private static void print(int a[][])
    {
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }        
    }
    
    private static boolean check1(int r,int c,int n)
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[r][i]==n || a[i][c]==n)
            {
                return true;
            }
        }
        return false;
    }
    
    private static boolean check2(int r,int c,int n)
    {
        int s1=0;
        int s2=0;
        int s3=0;
        int s4=0;
        if(r>=0 && r<=2 && c>=0 && c<=2)
        {
            s1=0;
            s2=2;
            s3=0;
            s4=2;
        }
        else if(r>=0 && r<=2 && c>=3 && c<=5)
        {
            s1=0;
            s2=2;
            s3=3;
            s4=5;
        }
        else if(r>=0 && r<=2 && c>=6 && c<=8)
        {
            s1=0;
            s2=2;
            s3=6;
            s4=8;
        }
        else if(r>=3 && r<=5 && c>=0 && c<=2)
        {
            s1=3;
            s2=5;
            s3=0;
            s4=2;
        }
        else if(r>=3 && r<=5 && c>=3 && c<=5)
        {
            s1=3;
            s2=5;
            s3=3;
            s4=5;
        }
        else if(r>=3 && r<=5 && c>=6 && c<=8)
        {
            s1=3;
            s2=5;
            s3=6;
            s4=8;
        }
        else if(r>=6 && r<=8 && c>=0 && c<=2)
        {
            s1=6;
            s2=8;
            s3=0;
            s4=2;
        }
        else if(r>=6 && r<=8 && c>=3 && c<=5)
        {
            s1=6;
            s2=8;
            s3=3;
            s4=5;
        }
        else if(r>=6 && r<=8 && c>=6 && c<=8)
        {
            s1=6;
            s2=8;
            s3=6;
            s4=8;
        }
        for(int i=s1;i<=s2;i++)
        {
            for(int j=s3;j<=s4;j++)
            {
                if(a[i][j]==n)
                    return true;
            }
        }
        return false;
    }
}