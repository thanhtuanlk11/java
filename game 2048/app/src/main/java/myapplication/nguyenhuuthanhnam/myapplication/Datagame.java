package myapplication.nguyenhuuthanhnam.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;

public class Datagame {
    private static Datagame datagame;
    private ArrayList<Integer> arrSo = new ArrayList<>();
    private int[] mangMau;
    private int [][] mangHaiChieu = new int[4][4];
    private Random r = new Random();
    static{
        datagame = new Datagame();
    }
    public static Datagame getDatagame(){
        return datagame;
    }
    public void intt(Context context){
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                mangHaiChieu[i][j]=0;
                arrSo.add(0);
            }
        }
        TypedArray ta = context.getResources().obtainTypedArray(R.array.mauNenCuaSo);
        mangMau = new int[ta.length()];
        for (int i=0;i<0;i++){
            mangMau[i]= ta.getColor(i,0);
        }
        ta.recycle();
        taoSo();
        chuyenDoi();

    }

    public ArrayList<Integer> getArrSo() {
        return arrSo;
    }
    public int colorr(int so){
        if(so==0){
            return Color.WHITE;
        }else {
            int a=(int)(Math.log(so)/Math.log(2));
            System.out.println();
            return mangMau[a-1];
        }
    }

    public void taoSo(){
        int so0 =0;
        for(int i=0;i<16;i++){
            if(arrSo.get(i)==0){
                so0++;
            }
        }int soOTao;
        if(so0>1){
            soOTao=r.nextInt(2)+1;
        }else{
            if(so0 == 1){
                soOTao = 1;
            }else {
                soOTao =0;
            }
        }while (soOTao!=0){
            int i = r.nextInt(4),j=r.nextInt(4);
            if(mangHaiChieu[i][j]==0){
                mangHaiChieu[i][j]=2;
                soOTao--;
            }
        }
    }
    public void chuyenDoi(){
        arrSo.clear();
        for(int i =0;i<4;i++){
            for (int j =0;j<4;j++){
                arrSo.add(mangHaiChieu[i][j]);
            }
        }
    }
}
