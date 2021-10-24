import java.util.Scanner;

public class PhysicalExamination {

    static final int VMAX = 21; //시력 분포 0.0에서 0.1단위 21개

    static class PhyscData {
        String name;
        int height;
        double vision;

        //생성자
        PhyscData(String name, int height, double vision){
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    //키의 평균값
    static double aveHeight(PhyscData[] dat){
        double sum = 0;

        for(int i = 0; i < dat.length; i++){
            sum += dat[i].height;
        }

        return sum/ dat.length;
    }

    static void distVision(PhyscData[] dat,int[] dist){
        int i = 0;

        dist[i] = 0;
        for(int j = 0; j < dat.length; j++){
            if(dat[j].vision >= 0.0 && dat[j].vision <= VMAX / 10.0){
                dist[(int)(dat[j].vision*10)]++;
            }
        }
    }
}
