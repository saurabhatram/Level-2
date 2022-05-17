/* // own ans
import java.util.ArrayList;
import java.util.Scanner;

// 
//  // lec001
//  
public class lec001 {

    public static void main(String[] args) {
    int n,m;
    Scanner sc= new Scanner(System.in);
    
    // n= sc.nextInt();
    // m=sc.nextInt();

    n=3;
    m=4;
    int[][] arr= new int[n][m];


    System.out.println(getMazePaths(arr,0,0,""));
    }

    static int[][] dir={{1,0},{1,1},{0,1}};
    static String[] ans={"v","d","h"};

    public static ArrayList<String> getMazePaths(int[][] arr,int src,int dest,String path)
    {
        int n=arr.length;
        int m=arr[0].length;
        if(arr.length-1==src && arr[0].length-1==dest)
        {
            ArrayList<String> base = new ArrayList<>();
          //  System.out.println("hi");
            base.add(path);
            return base;
        }
        ArrayList<String> myAns= new ArrayList<String>();
        ArrayList<String> recAns;

        for(int d=0;d<dir.length;d++)
        {
            int r=src+dir[d][0];
            int c=dest+dir[d][1];
            String way=ans[d];
            if(r>=0&&r<n && c>=0&& c<m && arr[r][c]!=1)
            {
                
                arr[r][c]=1;
                //System.out.print(path+way);   
                recAns=getMazePaths(arr, r, c,path+way);
                
                if(recAns.size()>0)
                {
                    myAns.addAll(recAns);
                }
                arr[r][c]=0;
            }                
        }
        //System.out.println();

        return myAns;

        
    }
}

*/

import java.util.*;
public class lec001{
  
    public static boolean inRange(int i,int  j, int n ,int m)
  {
    if(i < 0 || i >= n || j < 0 || j >= m)
    return false;
    
    return true;
  }

  public static int mazePath_01(int sr,int sc,int dr,int dc,int[][] dir,String[] dirN,String asf)
  {
    if(sr==dr && sc==dc)
    {
        System.out.println(asf);
        return 1;
    }
    int count=0;
    for(int d=0;d<dir.length;d++)
    {
        int r= sr+dir[d][0];
        int c= sc+dir[d][1];

        if(inRange(r, c, dr+1, dc+1))
        {   
            count+=mazePath_01(r,c,dr,dc,dir,dirN,asf+dirN[d]);
        }
     
    }
    return count;
  }
  public static void mazePath()
  {
      int n=2;
      int m=2;
      String[] dirN={"H","V","D"};
      int[][] dir={{0,1},{1,0},{1,1}};
      int ans= mazePath_02(0,0,n-1,m-1,dir,dirN,"");
      System.out.println(ans);

  }

  ///////maze path 1 ends

  
//maze path with infinite jumps

public static int mazePath_02(int sr,int sc,int dr,int dc,int[][] dir,String[] dirN,String asf)
{
 
    if(sr==dr && sc==dc)
    {
        System.out.println(asf);
        return 1;
    }
    int count=0;
    for(int d=0;d<dir.length;d++)
    {   
        for(int jump=1;jump<=dr||jump<=dc;jump++)
        {
            int r= sr+dir[d][0]*jump;
            int c= sc+dir[d][1]*jump;

            if(inRange(r, c, dr+1, dc+1))
            {
                count+=mazePath_02(r,c,dr,dc,dir,dirN,asf+dirN[d]+jump);
            }
         }
     
    }
    return count;   
}


//maze path with infinite jumps ends

//Flood Fills

public static boolean inRange(int i,int  j, int n ,int m,boolean[][] arr)
{
  if(i < 0 || i >= n || j < 0 || j >= m||arr[i][j]==true)
  return false;
  
  return true;
}
public static void floodfills()
{
    int n=2;
    int m=2;
    boolean[][] arr= new boolean[n][m];
    String[] dirN={"A","B","C","D","E","F","G","H"};
    int[][] dir={{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    int ans= floodfills_01(0,0,n-1,m-1,dir,dirN,"",arr);
    System.out.println(ans);

}
public static int floodfills_01(int sr,int sc,int dr,int dc,int[][] dir,String[] dirN,String asf,boolean[][]arr)
{
  if(sr==dr && sc==dc)
  {
      System.out.println(asf);
      return 1;
  }
  arr[sr][sc]=true;
  int count=0;
  for(int d=0;d<dir.length;d++)
  {
      int r= sr+dir[d][0];
      int c= sc+dir[d][1];
      if(inRange(r, c, dr+1, dc+1,arr))
      {     
          count+=floodfills_01(r,c,dr,dc,dir,dirN,asf+dirN[d],arr);
        }
   
  }
  arr[sr][sc]=false;
  return count;
}
//Flood Fills ends

    public static void main(String[] args)
    {
        //mazePath();
        //floodfills();
        //System.out.println( uniquePaths(3, 7));
        floodfillsjump();
    }

    

//Leetcode -62


    public static int uniquePaths(int n, int m) {
        
    int[][] dir= {{0,1},{1,0}};
    int[][] dp=new int[n][m];
        
    return uniquePaths_01(0,0,n-1,m-1,dir,dp);
    }
    
    // public boolean inRange(int i,int j,int n,int m)
    // {
    //     if(i<0 || i>=n || j<0 || j>=m)
    //         return false;
        
    //     return true;
    // }
    
    public static int uniquePaths_01(int sr,int sc,int dr,int dc,int[][] dir,int[][] dp)
    {
        if(sr==dr && sc== dc)
        {
            return dp[sr][sc]=1;
            

        }
        
        if(dp[sr][sc]!=0)
            return dp[sr][sc];
        
        int count=0;
        
        for(int i=0;i<dir.length;i++)
        {
            int r=sr+dir[i][0];
            int c= sc+dir[i][1];
            
            if(inRange(r,c,dr+1,dc+1))
            {
                count+=uniquePaths_01(r,c,dr,dc,dir,dp);
            }
            
        }
        
     return   dp[sr][sc]=count;
    
    }

//Leetcode 63
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
    int n=obstacleGrid.length;
    int m=obstacleGrid[0].length;
    int[][] dir= {{1,0},{0,1}};
    int[][] dp = new int[n][m];
   if(obstacleGrid[n-1][m-1]==1 || obstacleGrid[0][0]==1)
    return 0;
    
    if(n==0||m==0)
        return 0;
        
        return uniquePaths(obstacleGrid,0,0,n-1,m-1,dir,dp);
    }
    public static boolean inRange(int i,int j,int n,int m,int[][] grid)
    {
        if(i<0 || j<0 || i>=n ||j>=m || grid[i][j]==1)
            return false;
        return true;
    }
    public static int uniquePaths(int[][] grid,int sr,int sc,int dr,int dc,int[][] dir,int[][] dp)
    {   
        
        if(sr==dr&& sc==dc)
        {        
       return dp[sr][sc]=1;
        }
        if(dp[sr][sc]!=0)
            return dp[sr][sc];
        
        int count=0;
       // grid[sr][sc]=1; //we have not written this stmt because yw fn grid ka use bas obstacle check karne k liye use hota hai, baki sadhe tarike se movement hoti hai no flood fill is used only maze path
        for(int d=0;d<dir.length;d++)
        {
            int r= sr+ dir[d][0];
            int c= sc+ dir[d][1];
            
            if(inRange(r,c,dr+1,dc+1,grid))
            {
                count+=uniquePaths(grid,r,c,dr,dc,dir,dp);       
            }
        }
        //grid[sr][sc]=0;
        
        return dp[sr][sc]=count;
    }

    //flood-fills with jumps

    public static void floodfillsjump() {
        int n=3;
        int m=3;

        boolean[][] grid= new boolean[n][m];
        int[][] dir={{0,1},{1,1},{1,0}};
        String[] dirN= {"H","D","V"};
        ArrayList<String> al=floodfillsjump_01(0,0,n-1,m-1,dir,dirN,grid);
        System.out.println(al);
        System.out.println(al.size());
    }
    public static ArrayList<String> floodfillsjump_01(int sr,int sc,int dr,int dc, int[][] dir, String[] dirN,boolean[][] grid) {
        
        if(sr==dr&& sc==dc)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns= new ArrayList<>();
        ArrayList<String> recAns= new ArrayList<>();
        grid[sr][sc]=true;

        for(int d=0;d<dir.length;d++)
        {
                for(int jump=1;jump<=dr||jump<=dc;jump++) 
                {
                    int r=sr+dir[d][0]*jump;
                    int c=sc+dir[d][1]*jump;

                    if(inRange(r, c, dr+1, dc+1,grid))
                    {
                        recAns=floodfillsjump_01(r, c, dr, dc, dir, dirN, grid);

                        if(recAns.size()>0)
                        {
                            recAns.add(dirN[d]+jump);
                            myAns.addAll(recAns);
                        }
                    }

                }
        }
        grid[sr][sc]=false;
        return myAns;
    }


    
}