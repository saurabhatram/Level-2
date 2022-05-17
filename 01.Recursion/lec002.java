public class lec002 {
    
 
    public static int coinChangePermuInf(int[] coins, int tar, String asf)
    {
        if(tar==0)
        {
            System.out.println(asf);
            return 1;
        }
        int count=0;
        for(int i=0;i<coins.length;i++)
        {
            if(tar-coins[i]>=0)
            {
               count+= coinChangePermuInf(coins, tar-coins[i], asf+coins[i]);
            }
        }

        return count;
    }

    public static int coinChangeCombiInf(int[] coins,int tar, int idx, String asf)
    {
        if(tar==0)
        {
            System.out.println(asf);
            return 1;
        }

        int count=0;

        for(int i=idx;i<coins.length;i++)
        {
            if(tar-coins[i]>=0)
            {
                count+=coinChangeCombiInf(coins,tar-coins[i],i,asf+coins[i]);
            }
        }
        return count;
    }
    public static int coinChangePermuSingle(int[] coins, int tar, String asf)
    {
        if(tar==0)
        {
            System.out.println(asf);
            return 1;
        }
        int count=0;
        for(int i=0;i<coins.length;i++)
        {
            if(coins[i]>0 && tar-coins[i]>=0)
            {
                int val= coins[i];
                coins[i]=-coins[i];
               count+= coinChangePermuSingle(coins, tar-val, asf+val);
               coins[i]=-coins[i];
            }
        }

        return count;
    }
    public static int coinChangeCombiSingle(int[] coins,int tar, int idx, String asf)
    {
        if(tar==0)
        {
            System.out.println(asf);
            return 1;
        }

        int count=0;

        for(int i=idx;i<coins.length;i++)
        {
            if(tar-coins[i]>=0)
            {
                count+=coinChangeCombiSingle(coins,tar-coins[i],i+1,asf+coins[i]);
            }
        }
        return count;
    }

    
    public static void main(String[] args)
    {
        int[] coins={2,3,5,7};
        int tar=10;
       //System.out.println( "Count is PermuInf--"+coinChangePermuInf(coins,tar,""));
       // System.out.println( "Count is CombiInf--"+coinChangeCombiInf(coins,tar,0,""));
       //System.out.println( "Count is--"+coinChangePermuSingle(coins,tar,""));
       // System.out.println( "Count is--"+coinChangeCombiSingle(coins,tar,0,""));
    }    
}
