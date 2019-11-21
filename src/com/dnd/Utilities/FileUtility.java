package com.dnd.Utilities;

import com.dnd.DataObjects.CampaignObject;
import com.google.gson.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtility {

    public static final String FILE_NAME = "data.txt";

    public static void save(CampaignObject gameObject){
        Gson gson = new Gson();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(gson.toJson(gameObject));
            writer.close();
        }
        catch (Exception ex){
            System.err.println("Error saving file: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static CampaignObject load(){
        try{
            Gson gson = new Gson();
            String data = new String(Files.readAllBytes(Paths.get(FILE_NAME)), StandardCharsets.UTF_8);

            return gson.fromJson(data, CampaignObject.class);
        }
        catch (Exception ex){
            System.err.println("Error loading file: " + ex.getMessage());
            ex.printStackTrace();
        }

        // You may want to return null here so that you know if this fails and
        // don't accidentally overwrite your existing file.
        return new CampaignObject();
    }

    public static CampaignObject getFileOnStartup() {
        if (!Files.exists(Paths.get(FILE_NAME))) {
            Screen.redText("No data.txt file found at " + Paths.get(FILE_NAME) + ", creating a new one.");
            return new CampaignObject();
        } else {
            Screen.greenText("data.txt found at " + Paths.get(FILE_NAME));
            return FileUtility.load();
        }
    }

    public static CampaignObject getNewCampaignObject() {
        return new CampaignObject();
    }
}
