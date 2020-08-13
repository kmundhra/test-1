import java.lang.*;
import java.util.*;
class universe {
    public boolean[][] grid= new boolean[5][5];
    public universe(int m,int n){
        for(int i=0;i<m;i++)
            for (int j = 0; j < n; j++) {
                this.grid[i][j] = false;
            }
    }
    public int count_alive(int a,int b){
        int count=0;
        for(int i=a-1;i<a+2;i++){
            for(int j=b-1;j<b+2;j++){
                if(i>=0 && i<=this.grid.length-1 && j>=0 && j<=this.grid[0].length-1){
                    if((this.grid[i][j]==true) && (i!=a || j!=b)){
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
                //System.out.println(alive_count);
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
    public void makeAlive(int a,int b){
        this.grid[a][b]=true;
    }
    public boolean isAlive(int a,int b){
        return (this.grid[a][b]==true)? true:false;
    }
    public boolean equals(Object o) {
        if (o != null && o instanceof universe) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (((universe)o).grid[i][j] != grid[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
}
public class gameOfLife {
    public static void main(String args[]){
        System.out.println("Enter the number of alive cells in seed");
        Scanner sc=new Scanner(System.in);
        int totalAliveCells=sc.nextInt();
        universe grid1=new universe(5,5);
        System.out.println("Enter the alive cells in seed one by one");
        for(int i=0;i<totalAliveCells;i++){
            int p=sc.nextInt();
            int q=sc.nextInt();
            grid1.makeAlive(p,q);
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print((grid1.isAlive(i,j))? "X " :"-" + " ");
            }
            System.out.println();
        }
        System.out.println();
        universe grid2=grid1.tick();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print((grid2.isAlive(i,j))? "X " :"-" +" ");
            }
            System.out.println();
        }

    }
}
