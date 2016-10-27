/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fidentis.utils;

import Jama.Matrix;
import com.jogamp.graph.math.Quaternion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import javax.vecmath.Vector3f;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xferkova
 */
public class MathUtilsTest {
    
    private Random r;
    private static final File csvPath = new File("..\\resources\\testCsv.csv");
    private static List<ArrayList<Float>> csvValues;
    
    public MathUtilsTest() {
        r = new Random();
        csvValues = parseCSV(csvPath);
    }

    @Test
    public void testDistancePointSame(){
        Vector3f p = new Vector3f(r.nextFloat(), r.nextFloat(), r.nextFloat());
        
        assertTrue(MathUtils.instance().distancePoints(p, p) == 0.0);
    }
    
    @Test
    public void testDistancePointsDif(){
        Vector3f p = new Vector3f(r.nextFloat(), r.nextFloat(), r.nextFloat());
        Vector3f p2= new Vector3f(r.nextFloat(), r.nextFloat(), r.nextFloat());
        
        assertTrue(MathUtils.instance().distancePoints(p, p2) == MathUtils.instance().distancePoints(p2, p));
    }
    
    @Test
    public void testDistanceCoordinatesSame(){
        float coord = r.nextFloat();
        
        assertTrue(MathUtils.instance().distanceCoordinates(coord, coord) == 0.0);
    }
    
    @Test
    public void testDistanceCoordinatesDif(){
        float coord = r.nextFloat();
        float coord2 = r.nextFloat();
        
         assertTrue(MathUtils.instance().distanceCoordinates(coord2, coord) == -1 * MathUtils.instance().distanceCoordinates(coord, coord2));
    }
    
    private List<ArrayList<Float>> parseCSV(File path){
        String line;
        List<ArrayList<Float>> res = new ArrayList<>();
        int counter = 0;
        
        assert path.getPath().toLowerCase().endsWith(".csv");
        
         try(BufferedReader br = new BufferedReader(new FileReader(path));) {
             while((line = br.readLine()) != null){
                 if (counter == 0){
                     counter++;
                     continue;
                 }
                 
                 String[] lineParts = line.split(";");
                 ArrayList<Float> r = new ArrayList<>(lineParts.length - 1);
                 
                 for(int i = 1; i < lineParts.length; i++){
                     r.add(Float.parseFloat(lineParts[i]));
                 }
                 
                 res.add(r);
             }
 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ex.toString());
            } catch (IOException ex) {
                Logger.getLogger(ex.toString());
            }
         
         return res;
    }
    
    @Test
    public void testSymetricMatrix(){
        List<ArrayList<Float>> sym = MathUtils.instance().symetricMatrix(csvValues);
        
        for(int i = 0; i < sym.size(); i++){
            for(int j = 0; j < sym.get(i).size(); j++){
                assertTrue(sym.get(i).get(j) == sym.get(j).get(i));
            }
        }
    }
    
    @Test
    public void testClamp(){
        float value = r.nextFloat();
        
        float clamp = MathUtils.instance().clamp(value, 0.0f, 0.5f);
        
        assertTrue(clamp <= 0.5f && clamp >= 0.0f);
    }
    
    @Test
    public void testCrossProduct(){
        Vector3f a = new Vector3f(2,3,4);
        Vector3f b = new Vector3f(5,6,7);
        
        Vector3f res = MathUtils.instance().crossProduct(a, b);
        
        assertTrue(res.x == -3.0);
        assertTrue(res.y == 6.0);
        assertTrue(res.z == -3.0);
    }
    
    @Test
    public void testDotProduct(){
        Vector3f a = new Vector3f(9,2,7);
        Vector3f b = new Vector3f(4,8,10);
        
        assertTrue(a.dot(b) == 122);
    }
    
    @Test
    public void testQuaternionMultiplication(){
        Quaternion q1 = new Quaternion(1,0,1,0);
        Quaternion q2 = new Quaternion(1f, 0.5f, 0.5f, 0.75f);
        Quaternion result = MathUtils.instance().multiply(q1, q2);
        
        assert(result.getX() == 0.25);
        assert(result.getY() == 0.5);
        assert(result.getZ() == 1.25);
        assert(result.getW() == -1.5);
    }
    
    private Matrix arrayToColumnMatrix(float[] matrix){
        Matrix m = new Matrix(4,4);
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                m.set(i,j, matrix[i * 4 + j]);
            }
        }
        
        return m;
    }
    
    @Test
    public void toMatrixTest(){
        float[] matrix = new float[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        
        Matrix m = arrayToColumnMatrix(matrix);
        
        assert(m.get(0,0) == 1);
        assert(m.get(2,2) == 11);
        assert(m.get(3,3) == 16);
        assert(m.get(1,3) == 8);
        assert(m.get(3,1) == 14);
    }
    
}
