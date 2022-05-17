public class lec003 {
    //I ve spent 3-4 hours on this fn and i was stuck at using for loop like the previous lec002 recording i just copy pasted and code from mind and should've thought of it first as tree and then think like is the tree really emulating the subsequence tree, making the tree out of code is difficult rather 1st make the tree and then code
    public static int combiSubseqInf(int[] coins, int tar,int idx,String asf)
    {
        if(tar==0)
        {
            System.out.println(asf);
            return 1;
        }
        if(idx>=coins.length || tar<0 )
        return 0;

        int count=0;
        

            if(tar-coins[idx]>=0)
            count+=combiSubseqInf(coins, tar-coins[idx],idx,asf+coins[idx]);
        
            count+=combiSubseqInf(coins, tar,idx+1,asf);
        

        return count;


    }

    public static int CombiSubseqSingle(int[] coins,int tar, int idx,String asf)
    {
        if(tar==0)
        {
            System.out.println(asf);
            return 1;
        }

        if(idx>=coins.length || tar<0)
        return 0;

        int count=0;
        if(tar-coins[idx]>=0)
        count+=   CombiSubseqSingle(coins, tar-coins[idx], idx+1, asf+coins[idx]);
        
        count+=CombiSubseqSingle(coins, tar, idx+1, asf);

        return count;
    }

    public static int subSeqPermuInf(int[] coins,int tar,int idx, String asf) {
        
        if(tar==0)
        {
            System.out.println(asf);
            return 1;
        }
        if(idx>=coins.length || tar<0)
        return 0;

        int count=0;

        if(tar-coins[idx]>=0)
            count+=subSeqPermuInf(coins, tar-coins[idx],0, asf+coins[idx]);
            count+=subSeqPermuInf(coins, tar, idx+1, asf);
        return count;
    }

    public static int subSeqPermuSingle(int[] coins,int tar,int idx, String asf) {
        
        if(tar==0)
        {
            System.out.println(asf);
            return 1;
        }
        
        if(idx>=coins.length || tar<0)
        return 0;

        int count=0;

        if(tar-coins[idx]>=0 && coins[idx]>=0)
            {
                int val= coins[idx];
                coins[idx]=-coins[idx];
                count+=subSeqPermuSingle(coins, tar-val,0, asf+val);
                coins[idx]=-coins[idx];
            }
            
            count+=subSeqPermuSingle(coins, tar, idx+1, asf);
        return count;
    }

    public static void main(String[] args) {
        int[] coins={2,3,5,7};
        int tar=10;
       System.out.println("count-Subseq-Combi-Inf->"+combiSubseqInf(coins, tar, 0, ""));
       System.out.println("count-CombiSubseqSingle->"+CombiSubseqSingle(coins, tar, 0, ""));
       System.out.println("count-PermuSubseqInf->"+subSeqPermuInf(coins, tar, 0, ""));
       System.out.println("count-PermuSubseqSingle->"+subSeqPermuSingle(coins, tar, 0, ""));
        
    }
}
