package uk.ac.ucl.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model
{
  private ArrayList<MyList> lists;
  private File file;

  public Model(){
    lists = new ArrayList<>();
  }

  public ArrayList<MyList> getLists(){
    return lists;
  }

  public ArrayList<String> getListNames(){
    ArrayList<String> listNames = new ArrayList<>();
    for (MyList aList: lists){
      listNames.add(aList.getName());
    }
    return listNames;
  }

  private void writeToFile(){
    try {
      FileWriter fw = new FileWriter(file);
      for (MyList aList : lists) {
        fw.write(aList.getName());
        for (String item : aList.getItems())
          fw.write(" ," + item);
        fw.write("\r\n");
      }
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void deleteList(String s) {
    lists.removeIf(aList -> aList.getName().equals(s));
    writeToFile();
  }

  public void deleteItem(String name, int index){
    for (MyList list : lists) {
      if (list.getName().equals(name)) {
        for (int i = 0; i < list.getSize(); i++) {
          if (i == index - 1) { list.deleteItem(i);  break;}
        }
      }
    }
    writeToFile();
  }

  private String parse(String s){
    String[] inputs = s.split(" ; ");
    StringBuilder sb = new StringBuilder();
    for (String tag: inputs) {
      if (tag.startsWith("T: ")) sb.append("<font>").append(tag.substring(3)).append("</font>");
      else if (tag.startsWith("U: "))
        sb.append("<a href=\"").append(tag.substring(3)).append("\">").append(tag.substring(3)).append("</a>");
      else if (tag.startsWith("I: "))
        sb.append("<img src=\"./images/").append(tag.substring(3)).append("\">");
      else if (tag.startsWith("L: "))
        sb.append("<a href=\"/viewList.html?id=").append(tag.substring(3)).append("\">List: ").append(tag.substring(3)).append("</a>");
    }
    return sb.toString();
  }

  public void changeListName(String name, String newName){
    for (MyList list : lists) {
      if (list.getName().equals(newName))  return;
    }
    for (MyList list : lists) {
      if (list.getName().equals(name))  { list.setName(newName);  break;}
    }
    writeToFile();
  }

  public void changeItem(String name, String newItem, int index){
    for (MyList list : lists) {
      if (list.getName().equals(name)) {
        if (index == list.getSize()+1) { list.addItem(parse(newItem));  break; }
        for (int i = 0; i < list.getSize(); i++) {
          if (i == index - 1)  { list.setItemToIndex(i, parse(newItem));  break; }
        }
      }
    }
    writeToFile();
  }

  public void createNewList(String listname){
    MyList newList = new MyList();
    newList.setName(listname);
    lists.add(newList);
    writeToFile();
  }

  public void readFile(File file)
  {
    this.file = file;
    try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
      String line = buffer.readLine();
      while (line != null) {
        MyList aList = new MyList();
        String[] data = line.split(" ,");
        aList.setName(data[0]);
        for (int i=1 ; i< data.length ; i++){
          aList.addItem(data[i]);
        }
        lists.add(aList);
        line = buffer.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // This also returns dummy data. The real version should use the keyword parameter to search
  // the patient data and return a list of matching items.
  public List<String> searchFor(String keyword)
  {
    List<String> results = new ArrayList<>();
    for(MyList aList : lists) {
      if (aList.getName().contains(keyword))  results.add(aList.getName());
    }
    return results;
  }
}
