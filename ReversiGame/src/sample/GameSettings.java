package sample;
import java.io.*;
import java.util.ArrayList;

import javafx.scene.paint.Color;

/**
 * Created by Eilon on 1/13/2018.
 */
public class GameSettings {
    private File settings;
    private Color p1;
    private Color p2;
    private int size;
    private boolean readyForGame;

    GameSettings() {
        this.settings = new File("settings.txt");
        this.readyForGame = false;
    }
    public boolean isReadyForGame(){
        return this.readyForGame;
    }
    public Color getP1Color(){
        return this.p1;
    }
    public Color getP2Color() {
        return this.p2;
    }
    public int getSize() {
        return this.size;
    }
    public void writeTOSettings(int size, Color p1Color, Color p2Color) throws Exception{
        BufferedWriter writer;
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(settings)));
        String boardSize = Integer.toString(size);
        String color1 = p1Color.toString();
        String color2 = p2Color.toString();
        writer.write(boardSize);
        writer.newLine();
        writer.write(color1);
        writer.newLine();
        writer.write(color2);
        writer.newLine();
        writer.close();

    }
    public void readFromSettings() throws Exception{
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(settings)));
        String line = reader.readLine();
        ArrayList<String> args = new ArrayList<>();
        while(line != null) {
            args.add(line);
            line = reader.readLine();
        }
        this.size = Integer.parseInt(args.get(0));
        this.p1 = Color.valueOf(args.get(1));
        this.p2 = Color.valueOf(args.get(2));
        this.readyForGame = true;
    }


}
