package com.mygdx.game.ECSRemastered.entities;

import com.mygdx.game.ECSRemastered.components.Component;

import java.util.LinkedList;
import java.util.List;

public class Entity {

    private LinkedList<Component> components;
    private String name;

    public Entity(String name) {
        this.name = name;
        components = new LinkedList<Component>();
    }

    public void addComponent(Component component) {
        component.setEntity(this);
        components.add(component);
    }

    @SuppressWarnings("unchecked")
    public <T extends Component> T getComponent(Class<T> componentType) {
        for (Component component : components) {
            if (componentType.isInstance(component))
                return (T) component;
        }
        throw new IllegalArgumentException("ERROR: " + this + " does not possess Component of type: " + componentType);
    }

    @SuppressWarnings("unchecked")
    public <T extends Component> List<T> getComponents(Class<T> componentType) {
        LinkedList<Component> componentSet = new LinkedList<Component>();

        for (Component component : components) {
            if (componentType.isInstance(component))
                componentSet.add(component);
        }
        return (List<T>) componentSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(float delta){
        for (Component component : components) {
            component.update(delta);
        }
    }

}
