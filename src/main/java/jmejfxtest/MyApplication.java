package jmejfxtest;

import com.jme3.app.SimpleApplication;
import com.jme3.jfx.injme.JmeFxContainer;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class MyApplication extends SimpleApplication {
    
    private JmeFxContainer container;
    
    @Override
    public void simpleInitApp() {
        container = JmeFxContainer.install(this, getGuiNode());

        var button = new Button("BUTTON");
        var rootNode = new Group(button);
        var scene = new Scene(rootNode, 600, 600);
        scene.setFill(Color.TRANSPARENT);

        container.setScene(scene, rootNode);
        
        getInputManager().setCursorVisible(true);
    }

    @Override
    public void simpleUpdate(float tpf) {
        super.simpleUpdate(tpf);
        // we decide here that we need to do transferring the last frame from javaFX to jME
        if (container.isNeedWriteToJme()) {
            container.writeToJme();
        }
    }
}