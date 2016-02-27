
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VectorialDataSample {
    private ArrayList<Point> points;
    private int[] xs;
    private int[] ys;
    private int period;
    private int label;
    
    public VectorialDataSample(int period, int label){
        this.period = period;
        this.points = new ArrayList<Point>();
        this.xs = new int[]{0};
        this.ys = new int[]{0};
        this.label = label;
    }

    void addPoint(Point p) {
        points.add(p);
    }
    public int size(){
        return points.size();
    }
    public int[] getXs(){
        if(this.xs.length==points.size()) return xs;
        refreshXYVectors();
        return xs;
    }
    
   public int[] getYs(){
        if(this.ys.length==points.size()) return ys;
        refreshXYVectors();
        return this.ys;
    }
    private void refreshXYVectors() {
        int[] xs = new int[points.size()];;
        int[] ys = new int[points.size()];
        for (int i = 0; i < xs.length; i++) {
            xs[i] = (int) points.get(i).getX();
            ys[i] = (int) points.get(i).getY();
        }
        this.ys=ys;
        this.xs=xs;   
    }
    void saveFigure(){
        try {
            File dir = new File("generatedfigures");
            dir.mkdir();
            File file = File.createTempFile("fig"+label+"-"+period+"ms"+"-",
                    ".vdsf", dir);
            PrintWriter writer = new PrintWriter(dir+"/"+file.getName(), "UTF-8");
            writer.println(period);
            writer.println(label);
            for (int i = 0; i < xs.length; i++) {
                writer.println(xs[i]+" "+ys[i]);
            }
            writer.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VectorialDataSample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(VectorialDataSample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VectorialDataSample.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }


}
