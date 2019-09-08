package test1;

import javax.swing.plaf.synth.SynthEditorPaneUI;

/**
 * @author lz
 * @data 2019-08-24
 * @comment 描述
 */
public class add implements Runnable{
    private cilent cilent;

    public add(test1.cilent cilent) {
        this.cilent = cilent;
    }

    @Override
    public void run() {
        while (true){
            cilent.add();
        }
    }
}
