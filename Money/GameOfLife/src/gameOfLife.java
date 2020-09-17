import java.io.*;
import java.util.*;
class universe{
    public boolean[][] grid;
    public universe(int m,int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=false;

            }
        }
    }
    public int count_alive(int a,int b){
        int count=0;
        for(int i=a-1;i<a+2;i++){
            for(int j=b-1;j<b+2;j++){
                if(i>=0 && i<=this.grid.length && j>=0 && j<=this.grid[0].length){
                    if(this.grid[i][j]=true && (i!=a || j!=b)){
                        count=count+1;
                    }
                    else{
                        continue;
                    }
                }
                else{
                    continue;
                }
            }
        }
        return count;
    }
    public universe tick(){
        universe temp=new universe(this.grid.length,this.grid[0].length);
        for(int i=0;i<this.grid.length;i++){
            for(int j=0;j<this.grid[0].length;j++){
                int alive_count=this.count_alive(i,j);
                if(alive_count<2){
                    temp.grid[i][j]=false;
                }
                else if(alive_count>3){
                    temp.grid[i][j]=false;
                }
                else if(alive_count==3){
                    temp.grid[i][j]=true;
                }
                else{
                    temp.grid[i][j]=this.grid[i][j];
                }
            }
        }
        return temp;
    }
}
public class gameOfLife {
    public static void main(String args[]){
        System.out.println("Enter the number of alive cells in seed");
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();
        universe grid1=new universe(5,5);
        System.out.println("Enter the alive cells in seed one by one");
        for(int i=0;i<n;i++){
            int p=sc.nextInt();
            int q=sc.nextInt();
            grid1.grid[p][q]=true;
        }
        universe grid2=grid1.tick();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.println(grid2.grid[i][j]);
            }
        }
//hey
    }
}
