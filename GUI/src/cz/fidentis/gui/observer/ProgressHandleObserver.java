/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.fidentis.gui.observer;

import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;

/**
 *
 * @author xferkova
 */
public class ProgressHandleObserver implements Observable{
    private ProgressHandle p;

    private boolean isFinished;

    public ProgressHandleObserver(String handleMsg) {
        p = ProgressHandleFactory.createSystemHandle(handleMsg);

        isFinished = false;
    }
    
    public void startHandle(){
        if(!isFinished)
            p.start();

    }
   
    @Override
    public void update() {
        if(!isFinished)
            p.finish();
        
        isFinished = true;
    }
    
}
