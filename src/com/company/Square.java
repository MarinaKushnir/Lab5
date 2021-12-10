package com.company;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


public class Square implements Serializable {
    final double NumberOfSides=4;
    @Getter @Setter double side;
    double area;
    double perimeter;
    double diagonal;

    Square(){
        this.side = Math.random() * 11+1;
    }

    public Square(double side, double area, double perimeter, double diagonal) {
        this.side=side;
        this.area=area;
        this.perimeter=perimeter;
        this.diagonal=diagonal;
    }

    public double getAreaSq(){
        return area=this.side*side;
    }
    public void setAreaSq(double area) {this.area = area;}
    public double getPerimeter(){
        return perimeter=this.side*NumberOfSides;
    }
    public void setPerimeter(double perimeter){
        this.perimeter=perimeter;
    }
    public double getDiagonal(){
        return diagonal=this.side*Math.sqrt(2);
    }
    public void setDiagonal(double diagonal){
        this.diagonal=diagonal;
    }

    @Override
    public String toString(){
        if (side!=0){
            return"Square:"+
                    "\n\tside = "+String.format("%6.2f",side)+
                    "\n\tarea = "+String.format("%6.2f",getAreaSq())+
                    "\n\tperimeter = "+String.format("%6.2f",getPerimeter())+
                    "\n\tdiagonal = "+String.format("%6.2f",getDiagonal())+"\n";
        }
        else{return"Square:"+
                "\n\tside = 0";}

    }


}