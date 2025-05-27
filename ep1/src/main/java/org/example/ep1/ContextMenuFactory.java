package org.example.ep1;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ContextMenuFactory<T> {
    private final Map<String, Consumer<T>> actions = new HashMap<>();

    public void addAction(String menuText, Consumer<T> action) {
        actions.put(menuText, action);
    }

    public ContextMenu createContextMenu(T item) {
        ContextMenu menu = new ContextMenu();
        actions.forEach((text, action) -> {
            MenuItem menuItem = new MenuItem(text);
            menuItem.setOnAction(e -> action.accept(item));
            menu.getItems().add(menuItem);
        });
        return menu;
    }
}