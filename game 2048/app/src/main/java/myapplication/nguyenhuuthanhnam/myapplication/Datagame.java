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
        for (int i=0;i<ta.length();i++){
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
    public void vuotTrai(){
        for(int i= 0;i<4;i++){
            for(int j=0;j<4;j++){
                int so = mangHaiChieu[i][j];
                if(so == 0){
                    continue;//0
                }else{
                    for (int k = j+1;k<4;k++){
                        int sox = mangHaiChieu[i][k];
                        if(sox == 0){
                            continue;
                        }else {
                            if(sox == so){
                                mangHaiChieu[i][j] = so*2;
                                mangHaiChieu[i][k] = 0;
                                break;
                            }else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        for(int i =0;i<4;i++){
            for(int j =0;j<4;j++){
                int so = mangHaiChieu[i][j];
                if (so == 0){
                    for(int k =j +1;k<4;k++){
                        int so1 = mangHaiChieu[i][k];
                        if(so1 == 0){
                            continue;
                        }else {
                            mangHaiChieu[i][j] = mangHaiChieu[i][k];
                            mangHaiChieu[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
        taoSo();
        chuyenDoi();

    }
    public void vuotPhai(){
        for(int i= 3;i>=0;i--){
            for(int j=3;j>=0;j--){
                int so = mangHaiChieu[i][j];
                if(so == 0){
                    continue;//0
                }else{
                    for (int k = j-1;k>=0;k--){
                        int sox = mangHaiChieu[i][k];
                        if(sox == 0){
                            continue;
                        }else {
                            if(sox == so){
                                mangHaiChieu[i][j] = so*2;
                                mangHaiChieu[i][k] = 0;
                                break;
                            }else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        for(int i= 3;i>=0;i--){
            for(int j=3;j>=0;j--){
                int so = mangHaiChieu[i][j];
                if (so == 0){
                    for(int k =j -1;k>=0;k--){
                        int so1 = mangHaiChieu[i][k];
                        if(so1 == 0){
                            continue;
                        }else {
                            mangHaiChieu[i][j] = mangHaiChieu[i][k];
                            mangHaiChieu[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
        taoSo();
        chuyenDoi();

    }
    public void vuotXuong(){
        for(int i= 0;i<4;i++){
            for(int j=0;j<4;j++){
                int so = mangHaiChieu[j][i];
                if(so == 0){
                    continue;//0
                }else{
                    for (int k = j+1;k<4;k++){
                        int sox = mangHaiChieu[k][i];
                        if(sox == 0){
                            continue;
                        }else {
                            if(sox == so){
                                mangHaiChieu[j][i] = so*2;
                                mangHaiChieu[k][i] = 0;
                                break;
                            }else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        for(int i =0;i<4;i++){
            for(int j =0;j<4;j++){
                int so = mangHaiChieu[j][i];
                if (so == 0){
                    for(int k =j +1;k<4;k++){
                        int so1 = mangHaiChieu[k][i];
                        if(so1 == 0){
                            continue;
                        }else {
                            mangHaiChieu[j][i] = mangHaiChieu[k][i];
                            mangHaiChieu[k][i] = 0;
                            break;
                        }
                    }
                }
            }
        }
        taoSo();
        chuyenDoi();

    }
    public void vuotLen(){
        for(int i= 3;i>=0;i--){
            for(int j=3;j>=0;j--){
                int so = mangHaiChieu[j][i];
                if(so == 0){
                    continue;//0
                }else{
                    for (int k = j-1;k>=0;k--){
                        int sox = mangHaiChieu[k][i];
                        if(sox == 0){
                            continue;
                        }else {
                            if(sox == so){
                                mangHaiChieu[j][i] = so*2;
                                mangHaiChieu[k][i] = 0;
                                break;
                            }else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        for(int i= 3;i>=0;i--){
            for(int j=3;j>=0;j--){
                int so = mangHaiChieu[j][i];
                if (so == 0){
                    for (int k = j-1;k>=0;k--){
                        int so1 = mangHaiChieu[k][i];
                        if(so1 == 0){
                            continue;
                        }else {
                            mangHaiChieu[j][i] = mangHaiChieu[k][i];
                            mangHaiChieu[k][i] = 0;
                            break;
                        }
                    }
                }
            }
        }
        taoSo();
        chuyenDoi();

    }
}
