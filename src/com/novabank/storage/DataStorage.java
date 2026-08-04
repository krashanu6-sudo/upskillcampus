package com.novabank.storage;

import java.io.*;
import java.util.ArrayList;

/**
 * DataStorage class is responsible for
 * saving and loading project data
 * using Java Serialization.
 */
public class DataStorage {

    public static <T> void saveData(ArrayList<T> list, String fileName) {

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(fileName));

            out.writeObject(list);

            out.close();

        } catch (Exception e) {

            System.out.println("Error Saving Data!");

        }

    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> loadData(String fileName) {

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(fileName));

            ArrayList<T> list =
                    (ArrayList<T>) in.readObject();

            in.close();

            return list;

        } catch (Exception e) {

            return new ArrayList<>();

        }

    }

}