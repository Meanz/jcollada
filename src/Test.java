
import org.fractalstudio.jcollada.ColladaDocument;
import org.fractalstudio.jcollada.JCollada;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Meanz
 */
public class Test {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ColladaDocument document = JCollada.parseDocument("./data/zoey/zoey.dae");
        System.err.println("Loaded Collada document in " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
