package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.worker.Worker;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collection;

public class JSONFileWorkerWriter implements WorkerWriter{

    private String dataFileName;

    public JSONFileWorkerWriter(String dataFileName){
         this.dataFileName = dataFileName;
    }

    @Override
    public void saveWorkers(Collection<Worker> workers) {
        try {
            OutputStream os = new FileOutputStream(dataFileName, false);
            Writer writer = new OutputStreamWriter(os);

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String jsonString = gson.toJson(workers);
            writer.write(jsonString);
            writer.close();
        }catch(Exception e){
            System.err.println("Error with file.");
        }
    }
}
