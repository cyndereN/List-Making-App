package uk.ac.ucl.model;

import java.util.ArrayList;

public class MyList {
    private String name;
    private ArrayList<String> items;

    public MyList(){
        name = "";
        items = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public int getSize(){
        return items.size();
    }

    public String getItemFromIndex(int index){
        return items.get(index);
    }

    public void setItemToIndex(int index, String val){
        items.set(index, val);
    }

    public void addItem(String val){
        items.add(val);
    }

    public void deleteItem(int index) { items.remove(index); }

}
