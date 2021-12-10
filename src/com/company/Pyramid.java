package com.company;

public class Pyramid extends Square {
    final double NumberForVolume=0.33;
    final double NumberOfSides=4;
    final double apothem;
    public Pyramid (){
        super();
        apothem= Math.random()*this.side+this.side;
    }

    public double getVolume(){
        return this.apothem*NumberForVolume*this.getAreaSq();
    }
    public double getArea(){
        return this.getAreaSq()+this.apothem*this.side*NumberOfSides/2;
    }
    @Override
    public String toString() {
        if (apothem != 0) {
            return "Pyramid:" +
                    "\n\tbase side = " + String.format("%6.2f", side) +
                    "\n\tapothem = " + String.format("%6.2f", apothem) +
                    "\n\tvolume = " + String.format("%6.2f", getVolume()) +
                    "\n\tarea = " + String.format("%6.2f", getArea()) + "\n";
        }
        else{return"Pyramid:"+
                "\n\tbase side = 0";}
    }

}