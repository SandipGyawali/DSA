package Sorting;

import java.util.ArrayList;
public class Heap{
  private ArrayList<Integer> list;

  Heap(){
    list = new ArrayList<>();
  }

  public void insert(int val){
    //we know in heap-sort we add the element to the last-leaf i.e to the last place of array
    list.add(val);
    //now heapify the process that makes the root of the element to be smaller than the children
    upHeap(list.size() - 1);
  }

  public Integer remove() throws Exception{
    if(list.isEmpty()){
      throw new Exception("Cannot remove when heap is empty");
    }

    //while removing we always remove the first element from the heap
    Integer temp = list.get(0);
    Integer lastVal = list.remove(list.size() - 1);
    if(!list.isEmpty()){
      list.set(0, lastVal);
      downHeap(0);
    }

    return temp;
  }

  public void upHeap(int index){
    if(index == 0){
      return;
    }

    int p = parent(index);
    if(list.get(index).compareTo(list.get(p)) < 0){
      swap(p, index);
      upHeap(p);
    }
  }

  public void downHeap(int index){
    int min = index;
    int left = left(index);
    int right = right(index);

    if(left < list.size() && list.get(left).compareTo(list.get(min)) < 0){
      min = left;
    }

    if(right < list.size() && list.get(right).compareTo(list.get(min)) < 0){
      min = right;
    }

    //if minIndex is not equal to the index then swap
    if(min != index){
      swap(min, index);
      downHeap(min);
    }
  }

  public ArrayList<Integer> heapSort() throws Exception{
    ArrayList<Integer> sortedList = new ArrayList<>();

    int size = list.size();
    for(int i = 0; i < size; i++){
      sortedList.add(remove());
    }

    return sortedList;
  }

  private int parent(int index){
    return (index - 1) / 2;
  }

  private int left(int index){
    return (2 * index) + 1;
  }

  private int right(int index){
    return (2 * index) + 2;
  }

  public void swap(int first, int second){
    //first and second variable are index
    Integer temp = list.get(first);
    list.set(first, list.get(second));
    list.set(second, temp);
  }

  public static void main(String[] args) throws Exception{
    Heap heap = new Heap();
    heap.insert(34);
    heap.insert(45);
    heap.insert(22);
    heap.insert(89);
    heap.insert(76);

    System.out.println(heap.remove());
    System.out.println(heap.heapSort());
  }
}