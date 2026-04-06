import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    protected Vector<E> data; 

    public VectorHeap() {
        data = new Vector<E>();
    }
    
    protected int parent(int i) {
        return (i - 1) / 2;
    }

    protected int left(int i) {
        return 2 * i + 1;
    }

    protected int right(int i) {
        return 2 * i + 2;
    }

    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1); 
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        
        E minVal = getFirst(); 
        
        data.set(0, data.get(data.size() - 1));

        data.setSize(data.size() - 1); 
        
  
        if (data.size() > 1) {
            percolateDown(0);
        }
        
        return minVal;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }

        return data.get(0); 
    }

    @Override
    public boolean isEmpty() {
        return data.size() == 0;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }

    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);

        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent)); 
            leaf = parent;
            parent = parent(leaf); 
        }
        data.set(leaf, value);
    }

    protected void percolateDown(int root) {
        int heapSize = data.size();
        E value = data.get(root);

        while (left(root) < heapSize) {
            int child = left(root);
            
            if (child < heapSize - 1 && data.get(child + 1).compareTo(data.get(child)) < 0) {
                child++; 
            }
            
            if (value.compareTo(data.get(child)) <= 0) {
                break;
            }
            
            data.set(root, data.get(child));
            root = child; 
        }
        data.set(root, value); 
    }
}