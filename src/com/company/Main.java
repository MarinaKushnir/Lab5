
package com.company;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Scanner;


@Getter
@Setter

public class Main {

    public static void main(String[] args) throws IOException {
        Database db = new Database();
        db.add(8.53, 72.76, 34.12, 12.06);
        db.add(2.95,8.7,11.8,4.17);
        db.add(8.77, 76.91, 35.08, 12.4);
        System.out.println(db);

        Scanner sc = new Scanner(System.in);
        int numSq = 0;
        while (numSq <= 0) {
            if (numSq < 0) {
                System.out.println("Number<0 .Enter the number of squares:");
            } else {
                System.out.println("Enter the number of squares:");
            }
            while (!sc.hasNextInt()) {
                System.out.println("That not a number .Enter the number of squares:");
                sc.next();
            }
            numSq = sc.nextInt();
        }

        long timeStart = System.currentTimeMillis(), t1, t2, t3, t4, t5;
        for (int i = 0; i < numSq; i++) {
            db.add(8.77,76.91, 35.08, 12.4);
        }
        t1 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        db.save("db.txt");
        db.clear();
        db.load("db.txt");
        t2 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        db.serialize("db_s.txt");
        db.clear();
        db.deserialize("db_s.txt");
        t3 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        db.jacksonSerialize("square.json");
        db.clear();
        db.jacksonDeserialize("square.json");
        t4 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        db.serializeFastJSON("db_fastjson.txt");
        db.clear();
        db.deserializeFastJSON("db_fastjson.txt");
        t5 = System.currentTimeMillis() - timeStart;

        System.out.println("ArrayList of " + numSq + " objects");
        System.out.println("Initial Data Generation:	" + t1 + " ms");
        System.out.println("Text format Save/load:		" + t2 + " ms");
        System.out.println("Java serialization/des:		" + t3 + " ms");
        System.out.println("Jackson serialization/des:	" + t4 + " ms");
        System.out.println("FASTJson serialization/des:	" + t5 + " ms");



    }
}




