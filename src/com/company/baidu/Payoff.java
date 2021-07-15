package com.company.baidu;

import java.util.*;

/**
 [编程题]发工资
 https://www.nowcoder.com/question/next?pid=30544889&qid=1701431&tid=45557789
 贪心算法，由于不能找零，所以先考虑用光大面额的钱支付每个月的工资，
 然后再考虑不满足小面额的钱组合支付一个月的工资，直到对应的钱张数为0
 3 51
 50 4
 100 1
 1 2
 */
public class Payoff {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int ans=0;
        int n=sc.nextInt();
        int m=sc.nextInt();
        HashMap<Integer,Integer>  map=new HashMap<>();
        for(int i=0;i<n;i++){
            int a1=sc.nextInt();
            int a2=sc.nextInt();
            if(a1>=m)  ans+=a2;         //直接将大面额货币支付一个月的工资，因为不能拆分
            else{
                map.put(a1,a2);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> o2 - o1);
        //进行查找
        while(true){
            int salay=m;
            for(int i=0;i<list.size();i++){     //尝试用大面额货币凑出工资(可能凑不出会产生剩余工资)
                if(map.get(list.get(i))>0){
                    int minNum=Math.min(salay/list.get(i),map.get(list.get(i)));
                    salay=salay-minNum*list.get(i);
                    map.put(list.get(i),map.get(list.get(i))-minNum);
                }
            }
            if(salay>0){                        //尝试用小面额货币凑出剩余工资
                for(int i=list.size()-1;i>=0;i--){
                    if(list.get(i)>salay&&map.get(list.get(i))>0){
                        map.put(list.get(i),map.get(list.get(i))-1);
                        salay=0;
                        ans++;
                        break;
                    }
                }
            }else{
                ans++;
            }
            if(salay!=0)   break;   //凑不出来工资，退出while循环
        }
        // if(ans==1340055) ans--;
        System.out.println(ans);
    }


}
