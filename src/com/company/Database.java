
package com.company;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Database {
    private static ArrayList<Square> squareArrayList = new ArrayList<>();

    public Database() {
        squareArrayList = new ArrayList<>();
    }

    public void add(double side, double area, double perimeter, double diagonal) {
        this.squareArrayList.add(new Square(side,area,perimeter,diagonal));
    }

    public Square getS(int index) {
        return this.squareArrayList.get(index);
    }

    public Square removeS(int index) {
        return this.squareArrayList.remove(index);
    }

    @Override
    public String toString() {
        return "Database of Square{" + squareArrayList + '}';
    }

    public void save(String filename) throws IOException {
        FileWriter outStream = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(outStream);
        for (Square square : squareArrayList) {
            try {
                bw.write(String.valueOf(square.side));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(square.area));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(square.perimeter));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(square.diagonal));
                bw.write(System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bw.close();
        outStream.close();
    }

    public void load(String filename) throws IOException {
        this.clear();
        Scanner scanner = new Scanner(new FileReader(filename));
        double side =-1;
        double area=-1;
        double perimeter=-1;
        double diagonal=-1;
        while (scanner.hasNextLine()) {
            side = Double.parseDouble(scanner.nextLine()) ;
            area = Double.parseDouble(scanner.nextLine());
            perimeter = Double.parseDouble(scanner.nextLine());
            diagonal = Double.parseDouble(scanner.nextLine());
            this.squareArrayList.add(new Square(side,area,perimeter,diagonal));
        }
        scanner.close();
    }



    public void clear() {
        this.squareArrayList.clear();
    }

    public void serialize(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.squareArrayList);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void deserialize(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.squareArrayList = (ArrayList<Square>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Square and Pyramid class not found");
            c.printStackTrace();
        }
    }

    public void jacksonSerialize(String filename) throws IOException {
        new ObjectMapper().writeValue(new File(filename), this);
    }

    public void jacksonDeserialize(String filename) throws IOException {
        Database db1 = new ObjectMapper().readValue(new File(filename), Database.class);
        this.squareArrayList=db1.squareArrayList;
    }

    public void serializeFastJSON(String filename) throws IOException {
        FileWriter outStream = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(outStream);
        bw.write(JSON.toJSONString(this.squareArrayList));
        bw.close();
        outStream.close();
    }

    public void deserializeFastJSON(String filename) throws IOException {
        Scanner scanner = new Scanner(new FileReader(filename));
        this.clear();
        ArrayList<JSONObject> JSONlist = JSON.parseObject(scanner.nextLine(), ArrayList.class);
        for (JSONObject st : JSONlist) {
            this.add(new Square(st.getDoubleValue("side"),st.getDoubleValue("area"),st.getDoubleValue("perimeter"),st.getDoubleValue("diagonal")));
        }
        scanner.close();
    }


    public void add(Square square) {
        this.squareArrayList.add(square);
    }
}
