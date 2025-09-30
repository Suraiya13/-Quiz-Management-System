package quiz.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> List<T> readJsonFile(String filePath, Type typeToken) {
        File file = new File(filePath);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (Reader reader = new FileReader(file)) {
            List<T> data = gson.fromJson(reader, typeToken);
            return data != null ? data : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static <T> void writeJsonFile(String filePath, List<T> data) {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            System.err.println("Error writing file: " + filePath);
            e.printStackTrace();
        }
    }

    public static void createFileIfNotExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
                writeJsonFile(filePath, new ArrayList<>());
            } catch (IOException e) {
                System.err.println("Error creating file: " + filePath);
                e.printStackTrace();
            }
        }
    }
}
